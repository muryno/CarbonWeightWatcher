package com.carbonWeightwatchers.cww.data.repository.datasourceImpl


import com.carbonWeightwatchers.cww.data.db.CarbonWeightWatcherDao
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.repository.datasource.CarbonWeightWatcherCacheDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarbonWeightWatcherCacheDataSourceImpl @Inject constructor(val carbonWeightWatcherDao: CarbonWeightWatcherDao) :
    CarbonWeightWatcherCacheDataSource {

    override fun getCarbonWeightWatcherFromCache(): Flow<List<CarbonWeightWatcherModelItem>> {
        return carbonWeightWatcherDao.getCarbonWeightWatcher()
    }

    override suspend fun saveCarbonWeightWatcherToCache(wwLists: List<CarbonWeightWatcherModelItem>) {
        carbonWeightWatcherDao.deleteCarbonAllWeightWatcher()
        carbonWeightWatcherDao.saveCarbonWeightWatcher(wwLists)
    }

    override suspend fun deleteFromWatcher() {

        deleteFromWatcher()
        carbonWeightWatcherDao.deleteCarbonAllWeightWatcher()
    }
}