package com.rivibi.venoe.core.utils

import com.rivibi.venoe.core.data.local.entity.EventEntity
import com.rivibi.venoe.core.data.local.entity.EventWithOrganizers
import com.rivibi.venoe.core.data.local.entity.OrganizerEntity
import com.rivibi.venoe.core.domain.entity.Event
import com.rivibi.venoe.core.domain.entity.Organizer

object DataMapper {
    fun mapEntityToDomain(input: EventEntity): Event = Event(
        id = input.id,
        name = input.name,
        description = input.description,
        bannerUrl = input.banner_url,
        startTime = input.startTime,
        endTime = input.endTime,
        location = input.location,
    )

    fun mapEntityToDomain(input: List<EventEntity>): List<Event> = input.map {
        Event(
            id = it.id,
            name = it.name,
            description = it.description,
            bannerUrl = it.banner_url,
            startTime = it.startTime,
            endTime = it.endTime,
            location = it.location,
        )
    }

    fun mapEntityToDomain(input: EventWithOrganizers): Event = Event(
        id = input.event.id,
        name = input.event.name,
        description = input.event.description,
        bannerUrl = input.event.banner_url,
        startTime = input.event.startTime,
        endTime = input.event.endTime,
        location = input.event.location,
        organizers = mapOrganizerEntityToDomain(input.organizers)
    )

    fun mapOrganizerEntityToDomain(input: OrganizerEntity): Organizer = Organizer(
        id = input.id,
        name = input.name,
        email = input.email,
        logoUrl = input.logo_url,
        headerUrl = input.header_url,
        phone = input.phone,
        location = input.location
    )

    fun mapOrganizerEntityToDomain(input: List<OrganizerEntity>): List<Organizer> = input.map {
        Organizer(
            id = it.id,
            name = it.name,
            email = it.email,
            logoUrl = it.logo_url,
            headerUrl = it.header_url,
            phone = it.phone,
            location = it.location
        )
    }
}