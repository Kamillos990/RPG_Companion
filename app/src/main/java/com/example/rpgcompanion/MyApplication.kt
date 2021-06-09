package com.example.rpgcompanion

import android.app.Application
import com.example.rpgcompanion.DaggerComponent

class MyApplication: Application() {
    val appComponent = DaggerComponent.create()
}