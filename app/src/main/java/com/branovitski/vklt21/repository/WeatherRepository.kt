package com.branovitski.vklt21.repository

import com.branovitski.vklt21.network.NetworkManager
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val manager: NetworkManager) {

    suspend fun getForecast() = manager.weatherApi().getForecast()
}