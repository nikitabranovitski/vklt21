package com.branovitski.vklt21.model

import android.content.Context
import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName
import okio.IOException


data class Condition(
    @SerializedName("text")
    val text: String,

    @SerializedName("icon")
    val iconUrl: String
)

fun Condition.getIconDrawable(context: Context): Drawable? {
    return try {
        val pathParts = this.iconUrl.split("/")
        val time = pathParts.getOrNull(pathParts.size - 2) ?: return null
        val icon = pathParts.getOrNull(pathParts.size - 1) ?: return null
        val iconStream = context.resources.assets.open("$time/$icon")
        Drawable.createFromStream(iconStream, null)
    } catch (e: IOException) {
        null
    }
}
