package com.carbonWeightwatchers.cww.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.carbonWeightwatchers.cww.FakeCarbonWeightWatcherData
import com.carbonWeightwatchers.cww.R
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.presenter.fragment.DetailsFragment
import com.carbonWeightwatchers.cww.presenter.fragment.DetailsFragmentArgs
import com.carbonWeightwatchers.cww.utils.BaseUnitAndroidTest
import com.carbonWeightwatchers.cww.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class DetailsFragmentTest  : BaseUnitAndroidTest() {


    private var carbonWeightWatcherItem: CarbonWeightWatcherModelItem = FakeCarbonWeightWatcherData.carbonWeightWatcher[0]

    @Before
    fun setupTest() {

    }

    @Test
    fun cwwDetailsFragmentTestDisplayedInUi() {

        // WHEN - Details fragment launched to display task
        val bundle = DetailsFragmentArgs(carbonWeightWatcherItem).toBundle()
        launchFragmentInHiltContainer<DetailsFragment>(bundle, R.style.AppTheme)

        Espresso.onView(withId(R.id.imageView_details))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.title_details))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Thread.sleep(3000)
    }

}