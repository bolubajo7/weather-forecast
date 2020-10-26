package com.summercamp.weather_forecast.ui



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.summercamp.weather_forecast.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getForecastButton.setOnClickListener { getForecastForCity() }
    }

    private fun getForecastForCity() {
        val cityName = CityName.text.toString()
        val intent = ForecastActivity.newInstance(this, cityName)
        startActivity(intent)
    }
}