package dev.ry4nkim.fitpet_homework.data.source.remote

import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface ApiService {

    /*@FormUrlEncoded
    @POST(ApiEndPoint.SIGN_IN)
    fun signIn(
        @Path("platform") platform: String,
        @Field("accessToken") accessToken: String
    ): Single<ApiResponse>*/

    @GET(ApiEndPoint.WEATHER_API)
    fun requestWeatherApi(
        @Path("woeid") woeid: String,
    ): Single<WeatherApiResponse>
}