package com.summercamp.weather_forecast.model.repository

import com.summercamp.weather_forecast.model.local.LocalWeatherForecast

interface OpenWeatherForecastRepository {
    suspend fun getWeatherForecast(cityName: String) : LocalWeatherForecast
}