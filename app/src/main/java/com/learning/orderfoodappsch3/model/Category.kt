package com.learning.orderfoodappsch3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category (
    val imgCategory: Int,
    val nameCategory: String
) : Parcelable