package com.carbonWeightwatchers.cww.presenter.di

import com.carbonWeightwatchers.cww.domain.UseCase.GetWeightWatcherUseCase
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetUsedCase(weightWaterRepository: WeightWatcherRepository) =
        GetWeightWatcherUseCase(weightWaterRepository)
}