package com.rivibi.venoe.core.data.repository

import com.rivibi.venoe.core.data.Resource
import com.rivibi.venoe.core.data.datautils.EventQueryFilter
import com.rivibi.venoe.core.data.local.LocalDataSource
import com.rivibi.venoe.core.domain.entity.Event
import com.rivibi.venoe.core.domain.repository.IEventRepository
import com.rivibi.venoe.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
) : IEventRepository {
    override fun getUpcomingEvents(): Flow<Resource<List<Event>>> {
        return localDataSource.getFilteredEvents(EventQueryFilter.UPCOMING).map {
            Resource.Success(DataMapper.mapEntityToDomain(it))
        }
    }

    override fun getOngoingEvents(): Flow<Resource<List<Event>>> {
        return localDataSource.getFilteredEvents(EventQueryFilter.ONGOING).map {
            Resource.Success(DataMapper.mapEntityToDomain(it))
        }
    }

    override fun getPastEvents(): Flow<Resource<List<Event>>> {
        return localDataSource.getFilteredEvents(EventQueryFilter.PAST).map {
            Resource.Success(DataMapper.mapEntityToDomain(it))
        }
    }

    override fun getAllEvents(): Flow<Resource<List<Event>>> {
        return localDataSource.getEvents().map {
            Resource.Success(DataMapper.mapEntityToDomain(it))
        }
    }

    override suspend fun addEvent(event: Event) {
        localDataSource.insertEvent(DataMapper.mapEventDomainToEntity(event))
    }

    override suspend fun updateEvent(event: Event) {
        localDataSource.updateEvent(DataMapper.mapEventDomainToEntity(event))
    }

    override suspend fun deleteEvent(id: String) {
        localDataSource.deleteEvent(id)
    }
}