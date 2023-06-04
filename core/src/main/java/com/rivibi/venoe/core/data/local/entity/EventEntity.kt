package com.rivibi.venoe.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

data class EventEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("banner_url")
    val banner_url: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("location_id")
    val locationId: String,

    @SerializedName("location")
    val location: String,
)

data class EventAndLocation(
    @Embedded
    val event: EventEntity,

    @Relation(
        parentColumn = "locationId",
        entityColumn = "id",
    )
    val location: LocationEntity? = null
)

@Entity(primaryKeys = ["eventId", "organizerId"])
data class EventOrganizerCrossRef(
    val eventId: String,
    @ColumnInfo(index = true)
    val organizerId: String,
)

data class EventWithOrganizers(
    @Embedded
    val event: EventEntity,

    @Relation(
        parentColumn = "eventId",
        entity = OrganizerEntity::class,
        entityColumn = "organizerId",
        associateBy = Junction(
            value = EventOrganizerCrossRef::class,
            parentColumn = "eventId",
            entityColumn = "organizerId",
        )
    )
    val organizers: List<OrganizerEntity>,
)