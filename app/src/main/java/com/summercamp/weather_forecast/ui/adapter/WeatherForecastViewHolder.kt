package com.summercamp.weather_forecast.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.summercamp.weather_forecast.R
import com.summercamp.weather_forecast.model.local.LocalWeatherItem
import kotlinx.android.synthetic.main.weather_list_item.view.*

class WeatherForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(item: LocalWeatherItem) {
        itemView.apply {
            date?.text = item.date
            time?.text = item.time
            min_temp?.text = context.getString(R.string.minTemp, item.tempMin?.toString())
            max_temp?.text = context.getString(R.string.maxTemp, item.tempMax?.toString())
            feels_like?.text = context.getString(R.string.feelsLike,item.feelsLike?.toString())
            summary?.text = item.summary
            description?.text = item.description
        }
    }
}
