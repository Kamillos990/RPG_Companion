package com.example.rpgcompanion
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fabAddCharacter(view: View) {
        val newCharIntent = Intent(this, CharacterDetailsActivity::class.java)
        startActivity(newCharIntent)
    }

}
