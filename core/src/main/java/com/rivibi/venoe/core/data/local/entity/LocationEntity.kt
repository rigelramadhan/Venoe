package com.rivibi.venoe.core.data.local.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("long")
    val long: Double,
)
