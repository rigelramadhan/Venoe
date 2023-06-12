package com.rivibi.venoe.core.data.local

import androidx.sqlite.db.SimpleSQLiteQuery
import com.rivibi.venoe.core.data.datautils.EventQueryFilter
import com.rivibi.venoe.core.data.local.database.EventDao
import com.rivibi.venoe.core.data.local.entity.EventEntity
import com.rivibi.venoe.core.data.local.entity.EventWithOrganizers
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val eventDao: EventDao
) {
    fun getFilteredEvents(filter: EventQueryFilter): Flow<List<EventEntity>> {
        val queryBuilder = StringBuilder("SELECT * FROM event ")
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val timeNow = formatter.format(Date())

        when (filter) {
            EventQueryFilter.UPCOMING ->
                queryBuilder.append("WHERE end_time > $timeNow ORDER BY start_time ASC")

            EventQueryFilter.ONGOING ->
                queryBuilder.append("WHERE start_time > $timeNow AND end_time < $timeNow ORDER BY start_time ASC")

            EventQueryFilter.PAST -> queryBuilder.append("WHERE end_time < $timeNow ORDER BY end_time DESC")
        }

        val query = SimpleSQLiteQuery(queryBuilder.toString())
        return eventDao.getFilteredEvents(query)
    }

    fun getEvents(): Flow<List<EventEntity>> {
        return eventDao.getAllEvents()
    }

    fun getEventDetails(eventId: String): Flow<EventWithOrganizers> = eventDao.getEventById(eventId)

    suspend fun insertEvent(event: EventEntity) = eventDao.insertEvent(listOf(event))

    suspend fun updateEvent(event: EventEntity) = eventDao.updateEvent(event)

    suspend fun deleteEvent(eventId: String) = eventDao.deleteEvent(eventId)
}