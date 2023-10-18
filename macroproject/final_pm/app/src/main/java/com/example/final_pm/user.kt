package com.example.final_pm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class user(
    val username:String,
    val password:String
): Parcelable
