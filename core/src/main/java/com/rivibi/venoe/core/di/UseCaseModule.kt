package com.rivibi.venoe.core.di

import com.rivibi.venoe.core.data.repository.EventRepository
import com.rivibi.venoe.core.domain.repository.IEventRepository
import com.rivibi.venoe.core.domain.usecase.EventInteractor
import com.rivibi.venoe.core.domain.usecase.EventUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideEventRepository(repository: EventRepository): IEventRepository =
        repository

    @Provides
    fun provideUseCase(interactor: EventInteractor): EventUseCase =
        interactor

}