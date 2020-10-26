package com.summercamp.weather_forecast.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.summercamp.weather_forecast.R
import com.summercamp.weather_forecast.ui.adapter.WeatherListAdapter
import com.summercamp.weather_forecast.viewmodel.Status
import com.summercamp.weather_forecast.viewmodel.WeatherForecastViewModel
import com.summercamp.weather_forecast.viewmodel.WeatherForecastViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.forecast_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class ForecastFragment : Fragment() {
    @Inject
    lateinit var weatherForecastViewModelFactory: WeatherForecastViewModelFactory

    lateinit var viewModel: WeatherForecastViewModel

    private val weatherListAdapter: WeatherListAdapter = WeatherListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.forecast_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
        val cityName = arguments?.let { ForecastFragmentArgs.fromBundle(it).cityName }

        viewModel = weatherForecastViewModelFactory.create(WeatherForecastViewModel::class.java)

        cityName?.let { nonNullCityName ->
            viewModel.getWeatherForecast(nonNullCityName).observe(viewLifecycleOwner, Observer {
                it?.let { result ->
                    when (result.status) {
                        Status.LOADING -> {
                            Log.d(TAG, "Loading...")
                        }
                        Status.SUCCESS -> {
                            Log.d(TAG, "Success..." + result.data)
                            result.data?.let { weatherData ->
                                weatherListAdapter.setData(weatherData.list)
                                forecastCityName.text = "${weatherData.city}, ${weatherData.country}"

                            }
                        }
                        Status.ERROR -> {
                            Log.e(TAG, "Error..." + result.message)
                            // handle the error
                        }
                    }
                }
            })
        }

    }

    private fun setupUI() {
        weatherForecastList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
            adapter = weatherListAdapter
        }
    }

    companion object {
        val TAG: String = ForecastFragment::class.java.simpleName
    }
}