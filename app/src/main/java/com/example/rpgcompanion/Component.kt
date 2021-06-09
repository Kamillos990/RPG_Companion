package com.example.rpgcompanion
import dagger.Component
import dagger.Subcomponent


@Component
interface Component {

    fun inject(activity: CharacterDetailsActivity)
    fun inject(fragGeneral: FragGeneral)
}