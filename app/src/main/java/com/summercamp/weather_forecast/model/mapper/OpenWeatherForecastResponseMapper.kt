package com.summercamp.weather_forecast.model.mapper

import com.summercamp.weather_forecast.model.local.LocalWeatherForecast
import com.summercamp.weather_forecast.model.network.FiveDayForecast

interface OpenWeatherForecastResponseMapper {
    fun map(networkResponse: FiveDayForecast) : LocalWeatherForecast
}