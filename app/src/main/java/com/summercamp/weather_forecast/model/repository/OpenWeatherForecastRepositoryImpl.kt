package com.summercamp.weather_forecast.model.repository

import com.summercamp.weather_forecast.model.api.WeatherForecastAPI
import com.summercamp.weather_forecast.model.local.LocalWeatherForecast
import com.summercamp.weather_forecast.model.mapper.OpenWeatherForecastResponseMapper

class OpenWeatherForecastRepositoryImpl(
    private val weatherForecastAPI: WeatherForecastAPI,
    private val mapper: OpenWeatherForecastResponseMapper) : OpenWeatherForecastRepository {
    override suspend fun getWeatherForecast(cityName: String): LocalWeatherForecast {
        val networkResponse = weatherForecastAPI.getWeatherForecast(cityName, "db5bc35256f8278a29226e235f95294b", "metric")
        return mapper.map(networkResponse)
    }
}