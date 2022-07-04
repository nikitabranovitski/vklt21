package com.branovitski.vklt21.network

import com.branovitski.vklt21.model.Weather
import retrofit2.http.GET

interface WeatherApiService {

    @GET("v1/forecast.json?key=50404c792866416ab3d172233223006&q=Minsk&days=1&aqi=yes&alerts=yes")
    suspend fun getForecast(): Weather

}