package dev.ry4nkim.fitpet_homework.domain.usecase

import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse
import io.reactivex.rxjava3.core.Single
import dev.ry4nkim.fitpet_homework.domain.repository.WeatherRepository
import dev.ry4nkim.fitpet_homework.domain.usecase.base.SingleUseCase
import javax.inject.Inject

class RequestWeatherApiUseCase @Inject constructor(
    private val repository: WeatherRepository
) : SingleUseCase<WeatherApiResponse, RequestWeatherApiUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<WeatherApiResponse> {
        return with(params) {
            repository.requestWeatherApi(woeid)
        }
    }

    class Params(
        val woeid: String
    )
}