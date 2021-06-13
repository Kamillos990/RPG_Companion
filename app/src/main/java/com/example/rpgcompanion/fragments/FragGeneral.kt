package com.example.rpgcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.character_details_activity.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


private const val CHARACTER = "character"


class FragGeneral : Fragment() {

    private var character: Hero? = null
    private var viewGroup: ViewGroup? = null

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = container
        v=inflater.inflate(R.layout.character_details_activity, viewGroup, false)
        if(character != null){
            v.editName.setText(character?.name)
            v.lvl.setText(character?.level.toString())
            v.xp.setText(character?.xp.toString())
            v.hp.setText(character?.hp.toString())
        }

        return v



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinnerClasses: Spinner = view.findViewById(R.id.spinner_classes)
        val classArray = arrayListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            val responseClasses = Repository.getClasses()
            withContext(Dispatchers.Main)
            {
                responseClasses.results.forEach{
                    classArray.add(it.name)
                    spinnerClasses.adapter = ArrayAdapter(this@FragGeneral.requireContext(),android.R.layout.simple_spinner_item, classArray )
                }
            }

        }


        val spinnerRaces: Spinner = view.findViewById(R.id.spinner_races)
        val racesArray = arrayListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            val responseRaces = Repository.getRaces()
            withContext(Dispatchers.Main)
            {
                responseRaces.results.forEach{
                    racesArray.add(it.name)
                    spinnerRaces.adapter = ArrayAdapter(this@FragGeneral.requireContext(),android.R.layout.simple_spinner_item, racesArray )
                }
            }

        }



        val spinnerAlignments: Spinner = view.findViewById(R.id.spinner_alignments)
        val alignmentsArray = arrayListOf<String>()
        CoroutineScope(Dispatchers.IO).launch {
            val responseRaces = Repository.getAlignments()
            withContext(Dispatchers.Main)
            {
                responseRaces.results.forEach{
                    alignmentsArray.add(it.name)
                    spinnerAlignments.adapter = ArrayAdapter(this@FragGeneral.requireContext(),android.R.layout.simple_spinner_item, alignmentsArray )
                }
            }

        }


    }
    }


