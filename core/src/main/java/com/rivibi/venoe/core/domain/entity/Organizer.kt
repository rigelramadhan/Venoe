package com.rivibi.venoe.core.domain.entity

import androidx.room.ColumnInfo

data class Organizer(
    val id: String,
    val name: String,
    val email: String,
    val logo_url: String,
    val header_url: String,
    val phone: String,
    val location: String,
)
