package com.example.footballlegends

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlayerAdapter(
    private val context: Context,
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = players.size

    override fun getItem(position: Int): Any = players[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_player, parent, false)

        val player = players[position]

        val tvEmoji = view.findViewById<TextView>(R.id.tvEmoji)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvCountry = view.findViewById<TextView>(R.id.tvCountry)

        tvEmoji.text = player.emoji
        tvName.text = player.name
        tvCountry.text = player.country

        view.setOnClickListener {
            onItemClick(player)
        }

        return view
    }
}