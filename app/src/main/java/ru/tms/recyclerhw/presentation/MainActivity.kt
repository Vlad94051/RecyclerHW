package ru.tms.recyclerhw.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.tms.recyclerhw.R
import ru.tms.recyclerhw.presentation.recycler.News
import ru.tms.recyclerhw.presentation.recycler.NewsAdapter
import ru.tms.recyclerhw.presentation.recycler.OnNewsClickListener

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel = MainViewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    override fun onResume() {
        super.onResume()
        Log.e("!!!!:","onResume")
    }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {

        override fun onIconClickListener(position: Int) {
            viewModel.onNewsItemClicked(position)
        }

        override fun onItemClickListener(news: News) {
            Toast.makeText(
                this@MainActivity,
                news.title,
                Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        initRecycler()

        viewModel.news.observe(this) { news ->
            adapter.submitList(news)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("NAME", "name1")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString("NAME")
    }

    private fun initRecycler() {
        recyclerList.adapter = adapter
        recyclerList.layoutManager = LinearLayoutManager(this)
    }
}