package com.rivibi.venoe.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("description")
    val description: String,

    @ColumnInfo("banner_url")
    val banner_url: String,

    @ColumnInfo("date")
    val date: String,

    @ColumnInfo("time")
    val time: String,

    @ColumnInfo("location_id")
    val locationId: String,

    @ColumnInfo("location")
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