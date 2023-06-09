package com.rivibi.venoe.core.domain.usecase

import com.rivibi.venoe.core.data.Resource
import com.rivibi.venoe.core.domain.entity.Event
import com.rivibi.venoe.core.domain.repository.IEventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventInteractor @Inject constructor(
    private val eventRepository: IEventRepository
) : EventUseCase {
    override fun getUpcomingEvents(): Flow<Resource<List<Event>>> = eventRepository.getUpcomingEvents()

    override fun getOngoingEvents(): Flow<Resource<List<Event>>> = eventRepository.getOngoingEvents()

    override fun getPastEvents(): Flow<Resource<List<Event>>> = eventRepository.getPastEvents()

    override fun getAllEvents(): Flow<Resource<List<Event>>> = eventRepository.getAllEvents()

    override suspend fun addEvent(event: Event) = eventRepository.addEvent(event)

    override suspend fun updateEvent(event: Event) = eventRepository.updateEvent(event)

    override suspend fun deleteEvent(id: String) = eventRepository.deleteEvent(id)
}
