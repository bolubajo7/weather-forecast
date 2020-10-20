package com.summercamp.weather_forecast.model.network

import com.google.gson.annotations.SerializedName

data class Wind (
    @field: SerializedName("deg")
    val deg: Int?,

    @field: SerializedName("speed")
    val speed: Double?
)
