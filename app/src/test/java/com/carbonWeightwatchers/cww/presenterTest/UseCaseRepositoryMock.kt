package com.carbonWeightwatchers.cww.presenterTest

import com.carbonWeightwatchers.cww.FakeCarbonWeightWatcherData
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.util.Resource
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCaseRepositoryMock : WeightWatcherRepository {


    override suspend fun getCarbonWeightWatcher(): Resource<List<CarbonWeightWatcherModelItem>>? {
        val dummyData: List<CarbonWeightWatcherModelItem> =
            FakeCarbonWeightWatcherData.carbonWeightWatcher

        return Resource.Success(dummyData)
    }

    override fun getCarbonWeightWatcherFromCache(): Flow<List<CarbonWeightWatcherModelItem>> {

        val dummyData: List<CarbonWeightWatcherModelItem> =
            FakeCarbonWeightWatcherData.carbonWeightWatcher

        return flow {
            emit(dummyData)
        }
    }

    override suspend fun saveCarbonWeightWatcherToCache(cwwLists: List<CarbonWeightWatcherModelItem>) {

    }
}