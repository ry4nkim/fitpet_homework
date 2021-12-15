package dev.ry4nkim.fitpet_homework.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.ry4nkim.fitpet_homework.R
import dev.ry4nkim.fitpet_homework.databinding.ActivityMainBinding
import dev.ry4nkim.fitpet_homework.presentation.view.activity.base.BaseActivity
import dev.ry4nkim.fitpet_homework.presentation.view.fragment.WeatherFragment
import dev.ry4nkim.fitpet_homework.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModels()

    companion object {
        val TAG: String = MainActivity::class.java.simpleName

        fun show(context: Context) {
            context.run {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherFragment.create())
                .commitNow()
        }
    }
}