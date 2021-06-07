package com.example.swapp

import com.example.swapp.Fragments.FragGeneral
import dagger.Component
import dagger.Subcomponent


@Component
interface Component {

    fun inject(activity: CharacterDetailsActivity)
    fun inject(fragGeneral: FragGeneral)
}