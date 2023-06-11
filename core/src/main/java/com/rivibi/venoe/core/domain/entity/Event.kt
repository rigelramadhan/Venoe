package com.rivibi.venoe.core.domain.entity

data class Event(
    val id: String,
    val name: String,
    val description: String,
    val bannerUrl: String,
    val startTime: String,
    val endTime: String,
    val location: String,
    val organizers: List<Organizer>? = null,
)
