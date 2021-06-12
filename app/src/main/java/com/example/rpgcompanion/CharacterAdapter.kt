package com.example.rpgcompanion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgcompanion.R
import kotlinx.android.synthetic.main.list_view_character.view.*

class CharacterAdapter(private val context: MainActivity, private val characters: ArrayList<Hero>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view_character, parent, false))
    }
    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.charName.text = characters.get(position).name
        holder.charRace.text = "Race: " + characters.get(position).charRace
        holder.charClass.text = "Class: " + characters.get(position).charClass
        holder.charAlignment.text = "Alignment: " + characters.get(position).charAlignment



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
        val charAlignment = view.lblAlignment
        val btnDetails = view.btnDetails
    }
}