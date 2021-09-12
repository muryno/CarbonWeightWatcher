package com.carbonWeightwatchers.cww.domain.UseCase

import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.util.Resource
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetWeightWatcherUseCase @Inject constructor(private val weightWaterRepository: WeightWatcherRepository) {

    suspend fun fetchWeightWatchersFromApi(): Flow<Resource<List<CarbonWeightWatcherModelItem>>> =
        flow {
            emit(Resource.Loading)
            val responses = weightWaterRepository.getCarbonWeightWatcher()
            responses?.let { emit(it) }
        }.catch {
            emit(Resource.Error(it))
        }

    suspend fun saveWeightWatcher(data: List<CarbonWeightWatcherModelItem>) =
        weightWaterRepository.saveCarbonWeightWatcherToCache(data)

    fun getLiveWeightWatcher(): Flow<List<CarbonWeightWatcherModelItem>> =
        weightWaterRepository.getCarbonWeightWatcherFromCache()
}