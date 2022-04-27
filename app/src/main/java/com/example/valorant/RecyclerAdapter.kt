package com.example.valorant

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val list: List<List<String>>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.main_card_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(list[position][0]).into(holder.characterImage)
        holder.mapText.text = list[position][1]
        holder.dateText.text = list[position][2]
        holder.winCountText.text = list[position][3]
        holder.loseCountText.text = list[position][4]
        holder.kdaText.text = list[position][5]
        holder.kdText.text = list[position][6]
        holder.hsText.text = list[position][7]
        holder.adrText.text = list[position][8]
        holder.acsText.text = list[position][9]
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val characterImage: ImageView = item.findViewById(R.id.character_icon)
        val mapText: TextView = item.findViewById(R.id.map_text)
        val dateText: TextView = item.findViewById(R.id.date_text)
        val winCountText: TextView = item.findViewById(R.id.match_my_score_text)
        val loseCountText: TextView = item.findViewById(R.id.match_enemy_score_text)
        val kdaText: TextView = item.findViewById(R.id.kda_text)
        val kdText: TextView = item.findViewById(R.id.kd_text)
        val hsText: TextView = item.findViewById(R.id.hs_text)
        val adrText: TextView = item.findViewById(R.id.adr_text)
        val acsText: TextView = item.findViewById(R.id.acs_text)
    }
}