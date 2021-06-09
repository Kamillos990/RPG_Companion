//package com.example.rpgcompanion
//
//import androidx.activity.viewModels
//import android.graphics.Paint
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import retrofit2.Call
//import retrofit2.Response
//import javax.inject.Inject
//
//
//class DnDViewModel @Inject constructor(val repository: Repository):ViewModel() {
//
//    val myClassesResponse:MutableLiveData<Response<Classes>> = MutableLiveData()
//    val myRacesResponse:MutableLiveData<Response<Races>> = MutableLiveData()
//    val myAlignmentsResponse:MutableLiveData<Response<Alignments>> = MutableLiveData()
//
//
//    fun getClasses(){
//        viewModelScope.launch {
//            val response: Response<Classes> = repository.getClasses()
//            myClassesResponse.value=response
//        }
//    }
//
//    fun getRaces(){
//        viewModelScope.launch {
//            val response: Response<Races> = repository.getRaces()
//            myRacesResponse.value=response
//        }
//    }
//
//    fun getAlignments(){
//        viewModelScope.launch {
//            val response: Response<Alignments> = repository.getAlignments()
//            myAlignmentsResponse.value=response
//        }
//    }
//}