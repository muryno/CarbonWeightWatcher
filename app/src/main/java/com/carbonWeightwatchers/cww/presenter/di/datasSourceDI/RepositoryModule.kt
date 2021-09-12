package com.carbonWeightwatchers.cww.presenter.di.datasSourceDI

import com.carbonWeightwatchers.cww.data.repository.CarbonWeightWatcherRepositoryImpl
import com.carbonWeightwatchers.cww.data.repository.datasource.CarbonWeightWatcherCacheDataSource
import com.carbonWeightwatchers.cww.data.repository.datasource.WeightWatcherRemoteDataSource
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providerRepository(
        weightWatcherRemoteDataSource: WeightWatcherRemoteDataSource,

        CarbonWeightWatcherCacheDataSource: CarbonWeightWatcherCacheDataSource


    ): WeightWatcherRepository {
        return CarbonWeightWatcherRepositoryImpl(
            weightWatcherRemoteDataSource = weightWatcherRemoteDataSource,
            CarbonWeightWatcherCacheDataSource = CarbonWeightWatcherCacheDataSource
        )
    }
}