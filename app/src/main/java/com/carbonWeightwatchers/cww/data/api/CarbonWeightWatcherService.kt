package com.carbonWeightwatchers.cww.data.api


import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModel
import retrofit2.Response
import retrofit2.http.GET

interface CarbonWeightWatcherService {

    @GET("assets/cmx/us/messages/collections.json")
    suspend fun getCarbonWeightWatcherApi(): Response<CarbonWeightWatcherModel>

}