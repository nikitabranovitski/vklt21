package com.branovitski.vklt21.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    @SerializedName("temp_c")
    val temperatureC: Int,

    @SerializedName("condition")
    val condition: Condition,

    @SerializedName("humidity")
    val humidity: Int
)