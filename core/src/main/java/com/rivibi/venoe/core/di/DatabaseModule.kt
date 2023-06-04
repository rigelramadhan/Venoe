package com.rivibi.venoe.core.di

import android.content.Context
import androidx.room.Room
import com.rivibi.venoe.core.data.local.database.EventDao
import com.rivibi.venoe.core.data.local.database.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): EventDatabase =
        Room.databaseBuilder(context, EventDatabase::class.java, "events.db")
            .fallbackToDestructiveMigration().build()

    @Provides
    fun provideDao(database: EventDatabase): EventDao = database.getDao()
}