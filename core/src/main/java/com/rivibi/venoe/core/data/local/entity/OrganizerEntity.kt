package com.rivibi.venoe.core.data.local.entity

import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

data class OrganizerEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("logo_url")
    val logo_url: String,

    @SerializedName("header_url")
    val header_url: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("location_id")
    val location_id: String,

    @SerializedName("location")
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
