package com.summercamp.weather_forecast.model.repository

import com.summercamp.weather_forecast.model.local.LocalWeatherForecast

interface OpenWeatherForecastRepository {
    fun getWeatherForecast(cityName: String) : LocalWeatherForecast
}