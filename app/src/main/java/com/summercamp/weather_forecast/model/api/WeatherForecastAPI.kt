package com.summercamp.weather_forecast.model.api

import com.summercamp.weather_forecast.model.network.FiveDayForecast

interface WeatherForecastAPI {
    fun getWeatherForecast(cityName: String) : FiveDayForecast
}