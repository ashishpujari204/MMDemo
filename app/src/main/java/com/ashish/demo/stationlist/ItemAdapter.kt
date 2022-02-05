package com.ashish.demo.stationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashish.demo.R

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var items = ArrayList<ItemPresentation>()

    fun addItem(items: ArrayList<ItemPresentation>) {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var item: ItemPresentation

        fun bind(itemObject: ItemPresentation) = with(itemView) {
            item = itemObject
            /*weather.apply {
                cityText.text = todayDate
                weatherTypeText.text =
                    context.getString(R.string.weather_condition, weatherCondition)
                sunriseSunsetTimeText.text =
                    context.getString(R.string.sunrise_sunset, sunRiseAndSunSetTime)
                windText.text = context.getString(R.string.wind, wind)
                humidityText.text = context.getString(R.string.humidity, humidity)
                currentTempText.text = currentTemp
            }
            Glide.with(this).load(weather.imageUrl).into(weatherTypeImage)*/
        }
    }
}