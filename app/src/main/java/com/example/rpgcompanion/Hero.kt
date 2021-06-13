package com.example.rpgcompanion

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String? = "",
    var charRace: String? = "",
    val charClass: String? = "",
    var charAlignment: String? = "",
    var hp: Int = 0,
    var level: Int = 0,
    var xp: Int = 0,
    val background: String? = "",
    val appearance: String? = "",
    val traits: String? = "",
    val ideals: String? = "",
    val bonds: String? = "",
    val flaws: String? = ""):Parcelable
//) : Parcelable {
//    constructor(parcel: Parcel): this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString()
//    )
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object : Parceler<Hero> {
//        override fun Hero.write(parcel: Parcel, flags: Int) {
//            parcel.writeString(name)
//            parcel.writeString(charRace)
//            parcel.writeString(charClass)
//            parcel.writeString(charAlignment)
//            parcel.writeInt(hp)
//            parcel.writeInt(level)
//            parcel.writeInt(xp)
//            parcel.writeString(background)
//            parcel.writeString(appearance)
//            parcel.writeString(traits)
//            parcel.writeString(ideals)
//            parcel.writeString(bonds)
//            parcel.writeString(flaws)
//        }
//        override fun create(parcel: Parcel): Hero {
//            return Hero(parcel)
//        }
//    }
//}
