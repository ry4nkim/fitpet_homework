package dev.ry4nkim.fitpet_homework.presentation.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.ry4nkim.fitpet_homework.R
import dev.ry4nkim.fitpet_homework.databinding.FragmentWeatherBinding
import dev.ry4nkim.fitpet_homework.presentation.view.adapter.WeatherAdapter
import dev.ry4nkim.fitpet_homework.presentation.view.fragment.base.BaseFragment
import dev.ry4nkim.fitpet_homework.presentation.viewmodel.WeatherViewModel
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding, WeatherViewModel>(
    R.layout.fragment_weather
) {
    override val viewModel: WeatherViewModel by viewModels()

    private var woeidQueue: Queue<String> = LinkedList()

    private lateinit var weatherAdapter: WeatherAdapter

    companion object {
        val TAG: String = WeatherFragment::class.java.simpleName

        fun create(): WeatherFragment {
            val fragment = WeatherFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()

        woeidQueue.add("1132599") // Seoul
        woeidQueue.add("44418") // London
        woeidQueue.add("2379574") // Chicago

        viewModel.setIsLoading(true)
        viewModel.requestWeatherApi(woeidQueue.poll()!!)
    }

    private fun setupRecyclerView() {
        weatherAdapter = WeatherAdapter()
        viewDataBinding.rvWeather.setHasFixedSize(true)
        viewDataBinding.rvWeather.adapter = weatherAdapter
    }

    private fun observeViewModel() {
        viewModel.weatherApiResponse.observe(viewLifecycleOwner, { response ->
            if (response == null) {
                showMessage(getString(R.string.unknown_error))
            } else {
                response.consolidatedWeather[0].title = response.title
                weatherAdapter.addItemList(ArrayList(response.consolidatedWeather))

                if (!woeidQueue.isEmpty()) {
                    viewModel.requestWeatherApi(woeidQueue.poll()!!)
                } else {
                    viewModel.setIsLoading(false)
                }
            }
        })
    }
}