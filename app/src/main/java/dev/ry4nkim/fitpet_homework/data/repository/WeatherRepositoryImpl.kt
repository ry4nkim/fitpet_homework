package dev.ry4nkim.fitpet_homework.data.repository

import io.reactivex.rxjava3.core.Single
import dev.ry4nkim.fitpet_homework.data.source.remote.ApiService
import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse
import dev.ry4nkim.fitpet_homework.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override fun requestWeatherApi(woeid: String): Single<WeatherApiResponse> {
        return apiService.requestWeatherApi(woeid)
    }
}