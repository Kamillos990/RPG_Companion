package com.example.rpgcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment



class FragAttacks : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_attacks, container, false)
    }

    companion object {
        fun newInstance(): FragAttacks =
            FragAttacks()
    }
}