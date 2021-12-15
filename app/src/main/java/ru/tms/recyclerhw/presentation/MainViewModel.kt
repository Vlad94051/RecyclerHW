package ru.tms.recyclerhw.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tms.recyclerhw.presentation.recycler.News

class MainViewModel() : ViewModel() {

    private val listNews = mutableListOf(
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
        News("title1", "subtitle1"),
        News("title2", "subtitle2"),
        News("title3", "subtitle3"),
    )

    private val _news = MutableLiveData<List<News>>(listNews)
    val news: LiveData<List<News>> get() = _news

    fun onNewsItemClicked(position: Int) {
        val item = _news.value?.get(position) ?: return

        val list = _news.value?.toMutableList() ?: return

        list[position] = item.copy(isChecked = !item.isChecked)

        _news.value = list

    }
}