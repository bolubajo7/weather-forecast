package com.summercamp.weather_forecast.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.summercamp.weather_forecast.model.repository.OpenWeatherForecastRepository

class WeatherForecastViewModelFactory(
    private val openWeatherForecastRepository: OpenWeatherForecastRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(WeatherForecastViewModel::class.java)) {
            "Unknown Viewmodel class " + modelClass.simpleName
        }
        return WeatherForecastViewModel(openWeatherForecastRepository) as T
    }
}
