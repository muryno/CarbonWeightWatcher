package com.carbonWeightwatchers.cww.data.repository.datasource


import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModel
import retrofit2.Response

interface WeightWatcherRemoteDataSource {
    suspend fun getCarbonWeightWatcherFromApi(): Response<CarbonWeightWatcherModel>

}