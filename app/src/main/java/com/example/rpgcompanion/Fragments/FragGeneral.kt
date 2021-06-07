package com.example.swapp.Fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.charactermaster.Hero
import com.example.swapp.CharacterDetailsActivity
import com.example.swapp.viewmodel.ViewModel
import com.example.swapp.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.character_details_activity.*
import com.example.swapp.Fragments.CHARACTER as CHARACTER1
import javax.inject.Inject


private const val CHARACTER = "character"

class FragGeneral : Fragment() {
    @Inject
    lateinit var viewModel: ViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    private var character: Hero? = null
    private var viewGroup: ViewGroup? = null
    private var editable: Boolean = true
    lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            character = it.getParcelable(CHARACTER1)
        }


        viewModel = ViewModelProvider(this, factory).get(ViewModel::class.java)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as CharacterDetailsActivity).component
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = container
        v= inflater.inflate(R.layout.character_details_activity, viewGroup, false)


        viewModel.getClasses()
        viewModel.myClassesResponse.observe(viewLifecycleOwner, Observer { response ->
            response.let {
                val classArray = arrayListOf<String>()

                response.body()!!.results.forEach(){
                    classArray.add(it.name)
                }


                val adapter_classes = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_spinner_item, classArray)
                adapter_classes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_classes.adapter = adapter_classes
            }
        })

        viewModel.getRaces()
        viewModel.myRacesResponse.observe(viewLifecycleOwner, Observer { response ->
            response.let {
                val racesArray = arrayListOf<String>()

                response.body()!!.results.forEach() {
                    racesArray.add(it.name)
                }
                val adapter_races = ArrayAdapter(
                    requireActivity().applicationContext,
                    android.R.layout.simple_spinner_item,
                    racesArray
                )
                adapter_races.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_races.adapter = adapter_races
            }
        })


        viewModel.getAlignments()
        viewModel.myAlignmentsResponse.observe(viewLifecycleOwner, Observer { response ->
            response.let {
                val alignmentsArray = arrayListOf<String>()

                response.body()!!.results.forEach(){
                    alignmentsArray.add(it.name)
                }
                val adapter_alignments = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_spinner_item, alignmentsArray)
                adapter_alignments.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner_alignments.adapter = adapter_alignments
            }
        })
        return  v
    }

    companion object {
        fun newInstance(): FragGeneral =
            FragGeneral()
    }
}


