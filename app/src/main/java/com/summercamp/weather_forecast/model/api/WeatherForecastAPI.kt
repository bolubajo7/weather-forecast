package com.summercamp.weather_forecast.model.api

import com.summercamp.weather_forecast.model.network.FiveDayForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastAPI {
    @GET("/data/2.5/forecast?")
      suspend fun getWeatherForecast(
        @Query("q")city : String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ) : FiveDayForecast

}