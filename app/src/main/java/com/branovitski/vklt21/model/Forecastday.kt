package com.branovitski.vklt21.model

data class Forecastday(
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: ArrayList<Hour>
)