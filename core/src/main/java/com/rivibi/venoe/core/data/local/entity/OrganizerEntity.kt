package com.rivibi.venoe.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "organizer")
data class OrganizerEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("email")
    val email: String,

    @ColumnInfo("logo_url")
    val logo_url: String,

    @ColumnInfo("header_url")
    val header_url: String,

    @ColumnInfo("phone")
    val phone: String,

    @ColumnInfo("location_id")
    val location_id: String,

    @ColumnInfo("location")
    val location: String,
)

data class OrganizerAndLocation(
    @Embedded
    val organizer: OrganizerEntity,

    @Relation(
        parentColumn = "locationId",
        entityColumn = "id",
    )
    val location: LocationEntity? = null
)
