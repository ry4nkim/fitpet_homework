package dev.ry4nkim.fitpet_homework.domain.model

import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
    @SerializedName("consolidated_weather")
    val consolidatedWeather: List<ConsolidatedWeather>,
    @SerializedName("latt_long")
    val lattLong: String,
    @SerializedName("location_type")
    val locationType: String,
    val parent: Parent,
    val sources: List<Source>,
    @SerializedName("sun_rise")
    val sunRise: String,
    @SerializedName("sun_set")
    val sunSet: String,
    val time: String,
    val timezone: String,
    @SerializedName("timezone_name")
    val timezoneName: String,
    val title: String,
    val woeid: Int
) {
    data class ConsolidatedWeather(
        @SerializedName("air_pressure")
        val airPressure: Double,
        @SerializedName("applicable_date")
        val applicableDate: String,
        val created: String,
        val humidity: Int,
        val id: Long,
        @SerializedName("max_temp")
        val maxTemp: Double,
        @SerializedName("min_temp")
        val minTemp: Double,
        val predictability: Int,
        @SerializedName("the_temp")
        val theTemp: Double,
        val visibility: Double,
        @SerializedName("weather_state_abbr")
        val weatherStateAbbr: String,
        @SerializedName("weather_state_name")
        val weatherStateName: String,
        @SerializedName("wind_direction")
        val windDirection: Double,
        @SerializedName("wind_direction_compass")
        val windDirectionCompass: String,
        @SerializedName("wind_speed")
        val windSpeed: Double,
        var title: String
    )

    data class Parent(
        @SerializedName("latt_long")
        val lattLong: String,
        @SerializedName("location_type")
        val locationType: String,
        val title: String,
        val woeid: Int
    )

    data class Source(
        @SerializedName("crawl_rate")
        val crawlRate: Int,
        val slug: String,
        val title: String,
        val url: String
    )
}