package dev.ry4nkim.fitpet_homework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.viewpump.ViewPump
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var viewPump: ViewPump

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(viewPump)
    }
}