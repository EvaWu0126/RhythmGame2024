package com.example.rhythmgame2024

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Features(val name: String,
                    val author: String,
                    val score: Int = 1,
                    val combo: Int = 0,
                    val beatmap: List<List<Int>>) : Parcelable
