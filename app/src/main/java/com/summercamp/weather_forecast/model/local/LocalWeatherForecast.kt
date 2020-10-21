package com.summercamp.weather_forecast.model.local

data class LocalWeatherForecast (
    val city: String?,

    val country: String?,

    val list: List<LocalWeatherItem>?
)