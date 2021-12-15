package dev.ry4nkim.fitpet_homework.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ry4nkim.fitpet_homework.databinding.ItemWeatherBinding
import dev.ry4nkim.fitpet_homework.domain.model.WeatherApiResponse

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private var itemList = ArrayList<WeatherApiResponse.ConsolidatedWeather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemWeatherBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun getItem(position: Int): WeatherApiResponse.ConsolidatedWeather {
        return itemList[position]
    }

    fun addItem(item: WeatherApiResponse.ConsolidatedWeather) {
        this.itemList.add(item)
        notifyDataSetChanged()
    }

    fun addItemList(itemList: ArrayList<WeatherApiResponse.ConsolidatedWeather>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun getItemList(): ArrayList<WeatherApiResponse.ConsolidatedWeather> {
        return itemList
    }

    fun setItemList(itemList: ArrayList<WeatherApiResponse.ConsolidatedWeather>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    inner class ViewHolder internal constructor(
        private val viewDataBinding: ItemWeatherBinding,
    ) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(position: Int, weather: WeatherApiResponse.ConsolidatedWeather) {
            viewDataBinding.position = position
            viewDataBinding.weather = weather
            viewDataBinding.executePendingBindings()
        }
    }
}