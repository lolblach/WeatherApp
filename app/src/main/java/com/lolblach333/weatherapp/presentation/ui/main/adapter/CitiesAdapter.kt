package com.lolblach333.weatherapp.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolblach333.weatherapp.R
import com.lolblach333.weatherapp.data.model.City
import com.lolblach333.weatherapp.databinding.ItemCityBinding

class CitiesAdapter(private val onItemClicked: (City) -> Unit) :
    ListAdapter<City, CitiesAdapter.CityViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)

        return CityViewHolder(ItemCityBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CityViewHolder(private val dataBinding: ItemCityBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(item: City) {
            with(dataBinding) {
                root.setOnClickListener {
                    onItemClicked(item)
                }

                tvCityName.text = item.name
                tvCoordinates.text = "${item.coords.lat}, ${item.coords.lon}"
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: City, newItem: City): Boolean =
                oldItem == newItem
        }
    }
}
