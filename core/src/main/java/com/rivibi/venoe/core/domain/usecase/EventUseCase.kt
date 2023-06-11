package com.rivibi.venoe.core.domain.usecase

import com.rivibi.venoe.core.data.Resource
import com.rivibi.venoe.core.domain.entity.Event
import kotlinx.coroutines.flow.Flow

interface EventUseCase {
    fun getUpcomingEvents(): Flow<Resource<List<Event>>>

    fun getOngoingEvents(): Flow<Resource<List<Event>>>

    fun getPastEvents(): Flow<Resource<List<Event>>>

    fun getAllEvents(): Flow<Resource<List<Event>>>

    fun addEvent(event: Event)

    fun updateEvent(id: String, event: Event)

    fun deleteEvent(id: String)
}
