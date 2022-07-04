package com.branovitski.vklt21

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.branovitski.vklt21.databinding.ActivityMainBinding
import com.branovitski.vklt21.model.getIconDrawable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastActivity : AppCompatActivity() {

    private val viewModel by viewModels<ForecastViewModel>()
    private lateinit var binding: ActivityMainBinding

    private var hoursWeatherAdapter: HoursWeatherAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSwipeToRefresh()
        setupLocation()
        setupCurrentWeather()
        setupHoursWeatherList()
    }

    private fun setupSwipeToRefresh() {
        viewModel.isRefreshingData.observe(this) {
            binding.refreshLayout.isRefreshing = it
        }

        binding.refreshLayout.setOnRefreshListener { viewModel.onSwipedToRefresh() }
    }

    @SuppressLint("SetTextI18n")
    private fun setupLocation() {
        viewModel.locationData.observe(this) { location ->
            binding.tvLocation.text = "${location.region}, ${location.country}"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupCurrentWeather() {
        viewModel.currentWeatherData.observe(this) { currentWeather ->
            currentWeather.condition.getIconDrawable(this)?.let {
                binding.imvCurrentCondition.setImageDrawable(it)
            }
            binding.tvCurrentCondition.text = currentWeather.condition.text
            binding.tvCurrentTemperature.text = "${currentWeather.temperatureC} °C"
            binding.tvHumidity.text = "${currentWeather.humidity}"
        }
    }

    private fun setupHoursWeatherList() {
        hoursWeatherAdapter = HoursWeatherAdapter()
        binding.hoursWeatherList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hoursWeatherList.adapter = hoursWeatherAdapter

        viewModel.hoursWeatherData.observe(this) {
            hoursWeatherAdapter?.submitList(it)
        }
    }
}