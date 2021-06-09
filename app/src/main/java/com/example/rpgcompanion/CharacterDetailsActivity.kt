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
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.activity_character_details.*
import kotlinx.android.synthetic.main.character_details_activity.*
import kotlinx.android.synthetic.main.fragment_character.*


class CharacterDetailsActivity : AppCompatActivity() {




    var character: Hero? = null
    private lateinit var sensorManager: SensorManager
    private var light: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)


        character = intent.getParcelableExtra<Hero>("EXTRA_CHAR")

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.putAttrs(character)
        viewPager?.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
    }
    


}


