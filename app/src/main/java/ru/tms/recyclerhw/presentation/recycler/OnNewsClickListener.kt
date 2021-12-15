package ru.tms.recyclerhw.presentation.recycler

interface OnNewsClickListener {
    fun onIconClickListener(position: Int)
    fun onItemClickListener(news: News)
}