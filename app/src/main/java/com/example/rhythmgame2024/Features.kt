package com.example.rhythmgame2024

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Features(val name: String,
                    val fileName : String,
                    val author: String,
                    var highScore: Int = 1,
                    var maxCombo: Int = 0,
                    val beatmap: List<List<Int>>) : Parcelable
