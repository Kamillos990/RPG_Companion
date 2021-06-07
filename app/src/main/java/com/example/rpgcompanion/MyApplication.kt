package com.example.swapp

import android.app.Application

class MyApplication: Application(){
    val appComponent = DaggerComponent.create()
}