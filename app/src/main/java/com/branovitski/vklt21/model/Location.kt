package com.branovitski.vklt21.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String,

    @SerializedName("region")
    val region: String,

    @SerializedName("country")
    val country: String
)
