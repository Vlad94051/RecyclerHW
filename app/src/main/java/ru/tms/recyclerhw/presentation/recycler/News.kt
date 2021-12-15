package ru.tms.recyclerhw.presentation.recycler

data class News(
    val title: String,
    val subtitle: String,
    val isChecked: Boolean = false,
    val imageUrl: String = "https://www.imgonline.com.ua/examples/bee-on-daisy.jpg"
)