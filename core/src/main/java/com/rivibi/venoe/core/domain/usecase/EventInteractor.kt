package com.rivibi.venoe.core.domain.usecase

import com.rivibi.venoe.core.data.Resource
import com.rivibi.venoe.core.domain.entity.Event
import com.rivibi.venoe.core.domain.repository.IEventRepository
import kotlinx.coroutines.flow.Flow

class EventInteractor(private val eventRepository: IEventRepository) {
    fun getUpcomingEvents(): Flow<Resource<List<Event>>> = eventRepository.getUpcomingEvents()

    fun getOngoingEvents(): Flow<Resource<List<Event>>> = eventRepository.getOngoingEvents()

    fun getPastEvents(): Flow<Resource<List<Event>>> = eventRepository.getPastEvents()

    fun getAllEvents(): Flow<Resource<List<Event>>> = eventRepository.getAllEvents()

    fun addEvent(event: Event) = eventRepository.addEvent(event)

    fun updateEvent(id: String, event: Event) = eventRepository.updateEvent(id, event)

    fun deleteEvent(id: String) = eventRepository.deleteEvent(id)
}
