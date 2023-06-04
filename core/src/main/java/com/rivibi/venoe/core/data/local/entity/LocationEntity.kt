package com.rivibi.venoe.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class LocationEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("location")
    val location: String,

    @ColumnInfo("lat")
    val lat: Double,

    @ColumnInfo("long")
    val long: Double,
)
