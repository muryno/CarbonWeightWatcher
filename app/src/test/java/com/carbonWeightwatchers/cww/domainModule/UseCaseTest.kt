package com.carbonWeightwatchers.cww.domainModule


import com.carbonWeightwatchers.cww.FakeCarbonWeightWatcherData
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.data.util.Resource
import com.carbonWeightwatchers.cww.domain.UseCase.GetWeightWatcherUseCase
import com.carbonWeightwatchers.cww.domain.repository.WeightWatcherRepository
import com.carbonWeightwatchers.cww.utils.BaseUnitTest
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@HiltAndroidTest
@ExperimentalCoroutinesApi
class UseCaseTest : BaseUnitTest() {

    private lateinit var weightWaterRepository: WeightWatcherRepository
    private lateinit var getWeightWatcherUseCase: GetWeightWatcherUseCase

    private var weightWatcherModelItem = FakeCarbonWeightWatcherData.carbonWeightWatcher

    @Before
    fun setUp() {
        weightWaterRepository = Mockito.mock(WeightWatcherRepository::class.java)
        getWeightWatcherUseCase = GetWeightWatcherUseCase(weightWaterRepository)
    }

    @Test
    fun executeCarbonWeightWatcherFromApiCaseNotEqualNullTest() = runBlocking {
        Mockito.`when`(weightWaterRepository.getCarbonWeightWatcher()).thenReturn(
            Resource.Success(
                weightWatcherModelItem
            )
        )
        val reponse: Resource<List<CarbonWeightWatcherModelItem>>? =
            weightWaterRepository.getCarbonWeightWatcher()

        assertThat(reponse).isNotNull()
    }


    @Test
    fun executeCarbonWeightWatcherFromCacheCaseNotEqualNullTest() = runBlocking {
        Mockito.`when`(weightWaterRepository.getCarbonWeightWatcherFromCache()).thenReturn(
            flow {
                emit(weightWatcherModelItem)
            }
        )
        assertThat(
            weightWaterRepository.getCarbonWeightWatcherFromCache().count()
        ).isGreaterThan(
            0
        )
    }


}