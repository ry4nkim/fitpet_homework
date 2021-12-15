package dev.ry4nkim.fitpet_homework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.ry4nkim.fitpet_homework.data.repository.WeatherRepositoryImpl
import dev.ry4nkim.fitpet_homework.domain.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProfileRepository(
        weatherRepository: WeatherRepositoryImpl
    ): WeatherRepository {
        return weatherRepository
    }
}