package com.carbonWeightwatchers.cww.data.repository

import android.util.Log
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.repository.datasource.CarbonWeightWatcherCacheDataSource
import com.carbonWeightwatchers.cww.data.repository.datasource.WeightWatcherRemoteDataSource
import com.carbonWeightwatchers.cww.data.util.Resource
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import com.carbonWeightwatchers.cww.utils.ResponseToResourceUtils
import kotlinx.coroutines.flow.Flow

class CarbonWeightWatcherRepositoryImpl(
    private val weightWatcherRemoteDataSource: WeightWatcherRemoteDataSource,
    private val CarbonWeightWatcherCacheDataSource: CarbonWeightWatcherCacheDataSource

) : WeightWatcherRepository {

    override suspend fun getCarbonWeightWatcher(): Resource<List<CarbonWeightWatcherModelItem>>? = getWeightWatcherFromAPI()

    override  fun getCarbonWeightWatcherFromCache(): Flow<List<CarbonWeightWatcherModelItem>> = CarbonWeightWatcherCacheDataSource.getCarbonWeightWatcherFromCache()

    override suspend fun saveCarbonWeightWatcherToCache(cwwLists: List<CarbonWeightWatcherModelItem>) = CarbonWeightWatcherCacheDataSource.saveCarbonWeightWatcherToCache(cwwLists)

    private suspend fun getWeightWatcherFromAPI(): Resource<List<CarbonWeightWatcherModelItem>> {

         try {
            val response = weightWatcherRemoteDataSource.getCarbonWeightWatcherFromApi()
             return  ResponseToResourceUtils.responseToResource(response, null)
        } catch (exception: Throwable) {
            Log.i("MyTag", exception.message.toString())
            ResponseToResourceUtils.responseToResource(null, exception)
        }
        return ResponseToResourceUtils.responseToResource(null, Throwable())
    }




}