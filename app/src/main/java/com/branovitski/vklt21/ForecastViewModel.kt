package com.branovitski.vklt21

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.branovitski.vklt21.model.Hour
import com.branovitski.vklt21.model.CurrentWeather
import com.branovitski.vklt21.model.Location
import com.branovitski.vklt21.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {

    val isRefreshingData = MutableLiveData<Boolean>()
    val locationData = MutableLiveData<Location>()
    val currentWeatherData = MutableLiveData<CurrentWeather>()
    val hoursWeatherData = MutableLiveData<ArrayList<Hour>>()

    init {
        getForecast()
    }

    private fun getForecast() {
        isRefreshingData.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val forecast = repository.getForecast()
                locationData.postValue(forecast.location)
                currentWeatherData.postValue(forecast.currentWeather)
                forecast.forecast.forecastday.forEach{
                    hoursWeatherData.postValue(it.hour)
                }
            } catch (e: Exception) {
                //handle exception
            } finally {
                isRefreshingData.postValue(false)
            }
        }
    }

    fun onSwipedToRefresh() {
        getForecast()
    }
}