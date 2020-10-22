package com.summercamp.weather_forecast.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.summercamp.weather_forecast.R
import com.summercamp.weather_forecast.model.repository.OpenWeatherForecastRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.forecast_activity.*
import javax.inject.Inject

@AndroidEntryPoint
class ForecastActivity :  AppCompatActivity() {

    @Inject
    lateinit var openWeatherForecastRepository : OpenWeatherForecastRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forecast_activity)
        val cityName = intent.getStringExtra(EXTRA_MESSAGE)
        forecastCityName.text = cityName

    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context?, cityName: String): Intent {
            return Intent(context, ForecastActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, cityName)
            }
        }

        private const val EXTRA_MESSAGE = "CITY NAME"
    }
}