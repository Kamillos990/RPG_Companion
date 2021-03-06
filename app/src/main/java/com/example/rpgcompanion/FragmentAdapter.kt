package com.example.rpgcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter



class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var character: Hero? = null

    fun putAttrs(char: Hero?) {
        if (char != null) {
            character = char
        }
    }

    override fun getItem(position: Int): Fragment
    {
        var frag: Fragment?
        when (position) {
            0 -> {
                frag = FragGeneral()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag

            }
            1 -> {
                frag = FragChar()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag
            }
            2 -> {
                frag = FragAbilities()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag
            }
            3 -> {
                frag = FragAttacks()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag

            }
            4 -> {
                frag = FragSpells()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag

            }
            else -> {
                frag = FragInventory()
                val bundle = Bundle()
                if (character != null) {
                    bundle.putParcelable("character", character)
                    frag.arguments = bundle
                }
                return frag

            }
        }
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "General"
            1 -> "Character"
            2 -> "Abilities"
            3 -> "Attacks"
            4 -> "Spells"
            else -> return "Inventory"
        }
    }
}