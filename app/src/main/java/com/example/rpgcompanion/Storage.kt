package com.example.rpgcompanion

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import java.io.ByteArrayOutputStream


class Storage(val context: Context, val prefName: String = "") {
    val contextKey = "CHARACTER_MASTER"
    val sharedPreferences: SharedPreferences = context.getSharedPreferences(contextKey, Context.MODE_PRIVATE)

    fun saveCharacter(char: Hero) {
        val prefsEdit: SharedPreferences.Editor = sharedPreferences.edit()
        prefsEdit.putString(char.name, char.name)
        prefsEdit.apply()


        val charPrefs: SharedPreferences = context.getSharedPreferences(char.name, Context.MODE_PRIVATE)
        val charEdit: SharedPreferences.Editor = charPrefs.edit()
        charEdit.putString("name", char.name)
        charEdit.putString("name", char.charRace)
        charEdit.putString("alignment", char.charAlignment)
        charEdit.putString("charClass", char.charClass)
        charEdit.putInt("hp", char.hp)
        charEdit.putInt("level", char.level)
        charEdit.putInt("xp", char.xp)
        charEdit.putString("background", char.background)
        charEdit.putString("appearance", char.appearance)
        charEdit.putString("traits", char.traits)
        charEdit.putString("ideals", char.ideals)
        charEdit.putString("bonds", char.bonds)
        charEdit.putString("flaws", char.flaws)
        charEdit.apply()
    }

    fun loadCharacters(): ArrayList<Hero>{
        val entries: Map<String, *> = sharedPreferences.all
        val chars = arrayListOf<Hero>()

        for ((key, value) in entries.entries) {
            val charPrefs: SharedPreferences = context.getSharedPreferences(value.toString(), Context.MODE_PRIVATE)
            val c = Hero(
                charPrefs.getString("name", ""),
                charPrefs.getString("charRace", ""),
                charPrefs.getString("charClass", ""),
                charPrefs.getString("charAlignments", ""),
                charPrefs.getInt("hp", 0),
                charPrefs.getInt("level", 1),
                charPrefs.getInt("xp", 0),
                charPrefs.getString("background", ""),
                charPrefs.getString("appearance", ""),
                charPrefs.getString("traits", ""),
                charPrefs.getString("ideals", ""),
                charPrefs.getString("bonds", ""),
                charPrefs.getString("flaws", "")
            )
            chars.add(c)
        }

        return chars
    }

    fun clear() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.clear()
        editor.apply()
    }
}