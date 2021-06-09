package com.example.rpgcompanion
import retrofit2.Response

object Repository {
    suspend fun getClasses(): Classes {
        return RetrofitInstance.api.getClasses()
    }

   suspend fun getRaces(): Races {
       return RetrofitInstance.api.getRaces()
    }

    suspend fun getAlignments(): Alignments{
        return RetrofitInstance.api.getAlignments()
    }
}