package com.rivibi.venoe.core.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.room.Update
import androidx.sqlite.db.SimpleSQLiteQuery
import com.rivibi.venoe.core.data.local.entity.EventAndQueue
import com.rivibi.venoe.core.data.local.entity.EventEntity
import com.rivibi.venoe.core.data.local.entity.EventOrganizerCrossRef
import com.rivibi.venoe.core.data.local.entity.EventWithOrganizers
import com.rivibi.venoe.core.data.local.entity.OrganizerEntity
import com.rivibi.venoe.core.data.local.entity.QueueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
//    QUERIES
    @Query("SELECT * FROM event")
    fun getAllEvents(): Flow<List<EventEntity>>

    @RawQuery
    fun getFilteredEvents(query: SimpleSQLiteQuery): Flow<List<EventEntity>>

    @Query("SELECT * FROM organizer")
    fun getAllOrganizers(): Flow<List<OrganizerEntity>>

    @Transaction
    @Query("SELECT * FROM event")
    fun getAllEventsWithOrganizers(): Flow<List<EventWithOrganizers>>

    @Transaction
    @Query("SELECT * FROM event WHERE id == :eventId")
    fun getEventQueues(eventId: String): Flow<List<EventAndQueue>>

    @Query("SELECT * FROM event WHERE id == :eventId")
    fun getEventById(eventId: String): Flow<EventWithOrganizers>

    @Query("SELECT * FROM organizer WHERE id == :organizerId")
    fun getOrganizerById(organizerId: String): Flow<OrganizerEntity>

//    INSERTS

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEvent(event: List<EventEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrganizer(organizer: List<OrganizerEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEventOrganizerCrossRef(eventOrganizerCrossRef: List<EventOrganizerCrossRef>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQueue(queue: List<QueueEntity>)

//    UPDATE

    @Update
    suspend fun updateEvent(event: EventEntity)

    @Update
    suspend fun updateOrganizer(event: OrganizerEntity)

    @Update
    suspend fun updateQueue(queue: QueueEntity)

//    DELETE

    @Query("DELETE FROM event WHERE id == :eventId")
    suspend fun deleteEvent(eventId: String)

    @Query("DELETE FROM organizer WHERE id == :organizerId")
    suspend fun deleteOrganizer(organizerId: String)

    @Query("DELETE FROM queue WHERE id == :queueId")
    suspend fun deleteQueue(queueId: String)
}