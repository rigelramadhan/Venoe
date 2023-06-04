package com.rivibi.venoe.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.time.LocalDateTime

@Entity(tableName = "queue")
data class QueueEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,

    @ColumnInfo("phase")
    val phase: String,

    @ColumnInfo("start_time")
    val startTime: LocalDateTime,

    @ColumnInfo("actual_start_time")
    val actualStartTime: LocalDateTime,

    @ColumnInfo("duration")
    val duration: Int,

    @ColumnInfo("remaining_time")
    val remainingTime: Int,

    @ColumnInfo("event_id")
    val eventId: String,
)

data class EventAndQueue(
    @Embedded
    val event: EventEntity,

    @Relation(
        parentColumn = "eventId",
        entityColumn = "id"
    )
    val queue: List<QueueEntity>
)
