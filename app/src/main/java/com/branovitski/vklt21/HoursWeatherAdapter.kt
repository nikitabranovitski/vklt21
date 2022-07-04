package com.branovitski.vklt21

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.branovitski.vklt21.databinding.ListItemBinding
import com.branovitski.vklt21.model.Hour

class HoursWeatherAdapter : ListAdapter<Hour, HoursWeatherViewHolder>(HourWeatherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursWeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ListItemBinding.inflate(inflater, parent, false)
        return HoursWeatherViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HoursWeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class HourWeatherDiffCallback : DiffUtil.ItemCallback<Hour>() {

    override fun areItemsTheSame(oldItem: Hour, newItem: Hour): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Hour, newItem: Hour): Boolean {
        return false
    }
}