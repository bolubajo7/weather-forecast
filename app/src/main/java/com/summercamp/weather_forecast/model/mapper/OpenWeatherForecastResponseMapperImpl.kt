package com.summercamp.weather_forecast.model.mapper

import com.summercamp.weather_forecast.model.local.LocalWeatherForecast
import com.summercamp.weather_forecast.model.local.LocalWeatherItem
import com.summercamp.weather_forecast.model.network.FiveDayForecast
import com.summercamp.weather_forecast.model.network.ListItem

class OpenWeatherForecastResponseMapperImpl : OpenWeatherForecastResponseMapper {
    override fun map(networkResponse: FiveDayForecast): LocalWeatherForecast =
        LocalWeatherForecast(
            networkResponse.city?.name,
            networkResponse.city?.country,
            getLocalWeatherListItems(networkResponse.list)
        )


    private fun getLocalWeatherListItems(listItems: List<ListItem>?): List<LocalWeatherItem>? {
        val localWeatherItemList = arrayListOf<LocalWeatherItem>()

        listItems?.forEach { listItem ->
            val localItem = LocalWeatherItem(
                listItem.main?.temp,
                listItem.main?.tempMin,
                listItem.main?.humidity,
                listItem.main?.pressure,
                listItem.main?.feelsLike,
                listItem.main?.tempMax,
                listItem.wind?.speed,
                listItem.weather?.get(0)?.main,
                listItem.weather?.get(0)?.description,
                listItem.dtTxt?.substring(0,10),
                listItem.dtTxt?.substring(11, 19)
            )
            localWeatherItemList.add(localItem)
        }

        return localWeatherItemList
    }

}