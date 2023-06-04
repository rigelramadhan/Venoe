package com.rivibi.venoe.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rivibi.venoe.core.data.local.entity.EventEntity
import com.rivibi.venoe.core.data.local.entity.EventOrganizerCrossRef
import com.rivibi.venoe.core.data.local.entity.LocationEntity
import com.rivibi.venoe.core.data.local.entity.OrganizerEntity

@Database(
    entities = [EventEntity::class, LocationEntity::class, OrganizerEntity::class, EventOrganizerCrossRef::class],
    version = 1
)
abstract class EventDatabase : RoomDatabase() {

}