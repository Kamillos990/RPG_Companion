package com.example.rpgcompanion
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.content_grimoire.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storage = Storage(this)
        val chars = storage.loadCharacters()


        recyclerView.adapter = CharacterAdapter(this, chars).apply {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        }

        val refresher: SwipeRefreshLayout = pullToRefresh
        refresher.setOnRefreshListener {
            val store = Storage(this)
            val characters = store.loadCharacters()
            recyclerView.adapter = CharacterAdapter(this, characters).apply {
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            }
            (recyclerView.adapter as CharacterAdapter).notifyDataSetChanged()
            pullToRefresh.isRefreshing = false
        }

    }

    fun fabAddCharacter(view: View) {
        val newCharIntent = Intent(this, CharacterDetailsActivity::class.java)
        startActivity(newCharIntent)
    }



}
