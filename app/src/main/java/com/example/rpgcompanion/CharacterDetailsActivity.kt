package com.example.rpgcompanion
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.activity_character_details.*
import kotlinx.android.synthetic.main.character_details_activity.*
import kotlinx.android.synthetic.main.content_grimoire.*
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterDetailsActivity : AppCompatActivity() {




    var character: Hero? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)


        character = intent.getParcelableExtra<Hero>("EXTRA_CHAR")


        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.putAttrs(character)
        viewPager?.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
    }

    fun fabSave(view : View?) {
        val char = Hero(editName.text.toString(), spinner_races.selectedItem.toString(), spinner_classes.selectedItem.toString(), spinner_alignments.selectedItem.toString(), Integer.parseInt(hp.text.toString()), Integer.parseInt(lvl.text.toString()), Integer.parseInt(xp.text.toString()), txtBackground.text.toString(), txtAppearance.text.toString(), txtTraits.text.toString(), txtIdeals.text.toString(), txtBonds.text.toString(), txtFlaws.text.toString())
        val storage: Storage = Storage(this, char.name!!)
        storage.saveCharacter(char)

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
    }

}


