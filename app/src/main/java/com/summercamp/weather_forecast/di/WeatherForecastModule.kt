package com.summercamp.weather_forecast.di

import com.summercamp.weather_forecast.model.api.WeatherForecastAPI
import com.summercamp.weather_forecast.model.mapper.OpenWeatherForecastResponseMapper
import com.summercamp.weather_forecast.model.mapper.OpenWeatherForecastResponseMapperImpl
import com.summercamp.weather_forecast.model.repository.OpenWeatherForecastRepository
import com.summercamp.weather_forecast.model.repository.OpenWeatherForecastRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object WeatherForecastModule {

    @Provides
    fun provideOpenWeatherForecastResponseMapper() : OpenWeatherForecastResponseMapper = OpenWeatherForecastResponseMapperImpl()

    @Provides
    fun provideWeatherForecastApI() : WeatherForecastAPI = getOpenWeatherForecastAPI()

    @Provides
    fun provideWeatherForecastRepository(weatherForecastAPI: WeatherForecastAPI, mapper: OpenWeatherForecastResponseMapper) : OpenWeatherForecastRepository {
        return OpenWeatherForecastRepositoryImpl(weatherForecastAPI, mapper)

    }

    private fun getOpenWeatherForecastAPI(): WeatherForecastAPI {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) //this can be another library like moshi, jackson
            .build()
            .create(WeatherForecastAPI::class.java)
    }
}

