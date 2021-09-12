package com.carbonWeightwatchers.cww.data.repository.datasourceImpl

import com.carbonWeightwatchers.cww.data.api.CarbonWeightWatcherService
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModel
import com.carbonWeightwatchers.cww.data.repository.datasource.WeightWatcherRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class CarbonWeightWatcherRemoteDataSourceImpl @Inject constructor(
    private val wwDbServiceCarbon: CarbonWeightWatcherService,
) : WeightWatcherRemoteDataSource {
    override suspend fun getCarbonWeightWatcherFromApi(): Response<CarbonWeightWatcherModel> =
        wwDbServiceCarbon.getCarbonWeightWatcherApi()
}

