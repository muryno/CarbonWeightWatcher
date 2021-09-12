package com.carbonWeightwatchers.cww.utils

import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModel
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.util.Resource

import retrofit2.Response

class ResponseToResourceUtils {
    companion object {
        internal fun responseToResource(
            response: Response<CarbonWeightWatcherModel>?,
            exception: Throwable?
        ): Resource<List<CarbonWeightWatcherModelItem>> {
            if (response != null && response.isSuccessful) {

                response.body()?.let { result ->
                    return Resource.Success(result)
                }
            }


                return Resource.Error((exception ?:"") as Throwable)




        }
    }
}