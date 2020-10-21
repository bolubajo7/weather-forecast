package com.summercamp.weather_forecast.model.repository

import com.summercamp.weather_forecast.model.local.LocalWeatherForecast

class OpenWeatherForecastRepositoryImpl : OpenWeatherForecastRepository {
    override fun getWeatherForecast(cityName: String): LocalWeatherForecast {
        // 1. Get the data from API
        // 2. Pass the API response through the mapper
        // 3. Return the result of the mapper
        TODO("Not yet implemented")
    }
}