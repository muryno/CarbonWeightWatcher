package com.carbonWeightwatchers.cww.data.repository.datasource

import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import kotlinx.coroutines.flow.Flow


interface CarbonWeightWatcherCacheDataSource {
     fun getCarbonWeightWatcherFromCache(): Flow<List<CarbonWeightWatcherModelItem>>
    suspend fun saveCarbonWeightWatcherToCache(wwLists:List<CarbonWeightWatcherModelItem>)
    suspend fun deleteFromWatcher()
}