package com.example.rpgcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_character.view.*



private const val CHARACTER = "character"

class FragChar : Fragment() {
    private var character: Hero? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            character = it.getParcelable(CHARACTER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_character, container, false)
        if (character != null) {
            v.txtBackground.setText(character?.background)
            v.txtAppearance.setText(character?.appearance)
            v.txtBonds.setText(character?.bonds)
            v.txtFlaws.setText(character?.flaws)
            v.txtTraits.setText(character?.traits)
            v.txtIdeals.setText(character?.ideals)
        }

        return v
    }

    companion object {
        fun newInstance(): FragChar =
            FragChar()
    }
}