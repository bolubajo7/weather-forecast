package com.summercamp.weather_forecast.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.summercamp.weather_forecast.model.repository.OpenWeatherForecastRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class WeatherForecastViewModel @Inject constructor(
    private val openWeatherRepository: OpenWeatherForecastRepository
) : ViewModel() {

    fun getWeatherForecast(cityName: String) = liveData(context = Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = openWeatherRepository.getWeatherForecast(cityName)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Unknown error"))
        }
    }

}
