package com.example.swapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.charactermaster.Hero
import com.example.rpgcompanion.R
import kotlinx.android.synthetic.main.list_view_character.view.*

class CharacterAdapter(private val context: CharacterDetailsActivity, private val characters: ArrayList<Hero>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view_character, parent, false))
    }
    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.charName.text = characters.get(position).name
        holder.charRace.text = "Race: " + characters.get(position).race
        holder.charClass.text = "Class: " + characters.get(position).charClass
        holder.charLevel.text = "Level: " + characters.get(position).level.toString()
        holder.btnDetails.setOnClickListener {
            val characterIntent: Intent = Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra("EXTRA_CHAR", characters[position])
            }
            startActivity(context, characterIntent, null)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val charName = view.lblName
        val charRace = view.lblRace
        val charClass = view.lblClass
        val charLevel = view.txtLevel
        val charProfileImage = view.imgProfileImage
        val btnDetails = view.btnDetails
    }
}