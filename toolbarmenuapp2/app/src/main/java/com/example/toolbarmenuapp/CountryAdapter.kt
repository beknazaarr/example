package com.example.toolbarmenuapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countries: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFlag: TextView = itemView.findViewById(R.id.tvFlag)
        val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)
        val tvCapital: TextView = itemView.findViewById(R.id.tvCapital)
        val tvPopulation: TextView = itemView.findViewById(R.id.tvPopulation)

        fun bind(country: Country) {
            tvFlag.text = country.flag
            tvCountryName.text = country.name
            tvCapital.text = "Столица: ${country.capital}"
            tvPopulation.text = "Население: ${country.population}"

            itemView.setOnClickListener {
                onItemClick(country)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size
}