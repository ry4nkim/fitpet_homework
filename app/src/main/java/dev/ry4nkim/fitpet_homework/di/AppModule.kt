package dev.ry4nkim.fitpet_homework.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import dev.ry4nkim.fitpet_homework.R
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideViewPump(): ViewPump {
        return ViewPump.builder().addInterceptor(
            CalligraphyInterceptor(
                CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/nexon_lv2_gothic_regular.otf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            )
        ).build()
    }
}