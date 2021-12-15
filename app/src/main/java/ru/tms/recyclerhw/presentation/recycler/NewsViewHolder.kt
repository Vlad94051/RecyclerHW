package ru.tms.recyclerhw.presentation.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import ru.tms.recyclerhw.R

class NewsViewHolder(
    itemView: View,
    private val itemClickListener: OnNewsClickListener
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun fromParent(parent: ViewGroup, itemClickListener: OnNewsClickListener) =
            NewsViewHolder(
                 LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news, parent, false),
                 itemClickListener
            )
    }

    private val title: TextView by lazy { itemView.title }
    private val subtitle: TextView by lazy { itemView.subtitle }
    private val iconCheckBox: CheckBox by lazy { itemView.saveIcon }

    private val itemContainer by lazy { itemView.itemContainer }

    private val headImage by lazy { itemView.headImage }

    fun bindView(item: News) {
        title.text = item.title
        subtitle.text = item.subtitle

        loadImageByUrl(item.imageUrl)

        iconCheckBox.isChecked = item.isChecked

        itemContainer.setOnClickListener {
            itemClickListener.onItemClickListener(item)
        }

        iconCheckBox.setOnClickListener {
            itemClickListener.onIconClickListener(adapterPosition)
        }
    }

    private fun loadImageByUrl(url: String) {
        Glide.with(headImage.context)
            .load(url)
            .into(headImage)
    }
}