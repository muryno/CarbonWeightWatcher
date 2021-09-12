package com.carbonWeightwatchers.cww.domain.repository

import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface WeightWatcherRepository {
    suspend fun getCarbonWeightWatcher(): Resource<List<CarbonWeightWatcherModelItem>>?
    fun getCarbonWeightWatcherFromCache(): Flow<List<CarbonWeightWatcherModelItem>>
    suspend fun saveCarbonWeightWatcherToCache(cwwLists: List<CarbonWeightWatcherModelItem>)

}