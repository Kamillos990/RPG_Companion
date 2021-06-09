package com.example.rpgcompanion
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface DnDAPI {

    @GET("api/classes")
    suspend fun getClasses(): Classes

    @GET("api/races")
    suspend fun getRaces(): Races

    @GET("api/alignments")
    suspend fun getAlignments(): Alignments

}