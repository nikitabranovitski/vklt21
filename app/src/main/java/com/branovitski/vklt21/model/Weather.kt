package com.branovitski.vklt21.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("location")
    val location: Location,
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    @SerializedName("forecast")
    val forecast: Forecast
)
