package com.carbonWeightwatchers.cww.presenter.di.datasSourceDI

import com.carbonWeightwatchers.cww.data.api.CarbonWeightWatcherService
import com.carbonWeightwatchers.cww.data.db.CarbonWeightWatcherDao
import com.carbonWeightwatchers.cww.data.repository.datasource.CarbonWeightWatcherCacheDataSource
import com.carbonWeightwatchers.cww.data.repository.datasource.WeightWatcherRemoteDataSource
import com.carbonWeightwatchers.cww.data.repository.datasourceImpl.CarbonWeightWatcherCacheDataSourceImpl
import com.carbonWeightwatchers.cww.data.repository.datasourceImpl.CarbonWeightWatcherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class WeightWatcherRemoteDataModuleDI {

    @Singleton
    @Provides
    fun providersRemoteDataSource(wwDbServiceCarbon: CarbonWeightWatcherService): WeightWatcherRemoteDataSource {
        return CarbonWeightWatcherRemoteDataSourceImpl(
            wwDbServiceCarbon
        )
    }


    @Singleton
    @Provides
    fun  provideLocalDataSource(carbonWeightWatcherDao : CarbonWeightWatcherDao): CarbonWeightWatcherCacheDataSource{
        return CarbonWeightWatcherCacheDataSourceImpl(carbonWeightWatcherDao)
    }
}