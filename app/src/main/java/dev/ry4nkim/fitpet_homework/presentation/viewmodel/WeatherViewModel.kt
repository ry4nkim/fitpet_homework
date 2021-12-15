package dev.ry4nkim.fitpet_homework.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse
import dev.ry4nkim.fitpet_homework.domain.usecase.RequestWeatherApiUseCase
import dev.ry4nkim.fitpet_homework.presentation.viewmodel.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val requestWeatherApiUseCase: RequestWeatherApiUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _weatherApiResponse = MutableLiveData<WeatherApiResponse?>()
    val weatherApiResponse: MutableLiveData<WeatherApiResponse?> = _weatherApiResponse

    fun requestWeatherApi(woeid: String) {
        requestWeatherApiUseCase.execute(
            params = RequestWeatherApiUseCase.Params(woeid),
            onSuccess = { response ->
                _weatherApiResponse.value = response
            },
            onError = {
                _weatherApiResponse.value = null
                it.printStackTrace()
            },
            onFinished = {}
        )
    }
}