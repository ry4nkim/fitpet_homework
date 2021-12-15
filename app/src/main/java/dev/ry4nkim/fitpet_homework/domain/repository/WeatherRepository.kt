package dev.ry4nkim.fitpet_homework.domain.repository

import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {

    fun requestWeatherApi(woeid: String): Single<WeatherApiResponse>
}