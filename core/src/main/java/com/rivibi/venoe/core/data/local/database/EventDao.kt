package com.rivibi.venoe.core.data.local.database

import androidx.room.Dao
import androidx.room.Query
import com.rivibi.venoe.core.data.local.entity.EventEntity
import com.rivibi.venoe.core.data.local.entity.OrganizerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun getAllEvents(): Flow<List<EventEntity>>

    @Query("SELECT * FROM organizer")
    fun getAllOrganizers(): Flow<List<OrganizerEntity>>
}