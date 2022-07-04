package com.branovitski.vklt21

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.branovitski.vklt21.databinding.ListItemBinding
import com.branovitski.vklt21.model.Hour
import com.branovitski.vklt21.model.getIconDrawable

class HoursWeatherViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: Hour) {
        binding.tempTextView.text = "${item.temp_c} °C"
        binding.humidityTextView.text = "${item.humidity} %"
        val subStr = item.time.split(" ")
        binding.timeTextView.text = subStr[1]
        item.condition.getIconDrawable(binding.root.context)?.let {
            binding.iconImageView.setImageDrawable(it)
        }
    }

}
