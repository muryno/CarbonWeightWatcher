package com.carbonWeightwatchers.cww.presenterTest

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import com.carbonWeightwatchers.cww.domain.UseCase.GetWeightWatcherUseCase
import com.carbonWeightwatchers.cww.presenter.viewModel.CarbonWeightWatcherViewModel
import com.carbonWeightwatchers.cww.utils.BaseUnitTest
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.mockito.Mock

@HiltAndroidTest
@ExperimentalCoroutinesApi
class ViewModelTest : BaseUnitTest() {

    @Mock
    private lateinit var appContext: Application
    lateinit var carbonWeightWatcherViewModel: CarbonWeightWatcherViewModel


    @Before
    fun setUp() {
        appContext = Application()
        carbonWeightWatcherViewModel = CarbonWeightWatcherViewModel(  GetWeightWatcherUseCase(UseCaseRepositoryMock()),SavedStateHandle())
    }


}