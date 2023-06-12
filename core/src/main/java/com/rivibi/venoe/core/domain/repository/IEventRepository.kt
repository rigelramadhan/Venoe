package com.rivibi.venoe.core.domain.repository

import com.rivibi.venoe.core.data.Resource
import com.rivibi.venoe.core.domain.entity.Event
import kotlinx.coroutines.flow.Flow

interface IEventRepository {
    fun getUpcomingEvents(): Flow<Resource<List<Event>>>

    fun getOngoingEvents(): Flow<Resource<List<Event>>>

    fun getPastEvents(): Flow<Resource<List<Event>>>

    fun getAllEvents(): Flow<Resource<List<Event>>>

    suspend fun addEvent(event: Event)

    suspend fun updateEvent(event: Event)

    suspend fun deleteEvent(id: String)
}