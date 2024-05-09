package com.example.rhythmgame2024

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Features(val song: Song, val highScore: String, val combo: String) : Parcelable
