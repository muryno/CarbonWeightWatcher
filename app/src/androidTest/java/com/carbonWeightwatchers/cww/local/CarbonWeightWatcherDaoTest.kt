package com.carbonWeightwatchers.cww.local

import androidx.test.filters.SmallTest
import com.carbonWeightwatchers.cww.data.db.CWWDBDatabase
import com.carbonWeightwatchers.cww.data.db.CarbonWeightWatcherDao
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.utils.BaseUnitAndroidTest
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named
import kotlin.concurrent.thread

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class CarbonWeightWatcherDaoTest : BaseUnitAndroidTest() {


    private lateinit var daoCarbon: CarbonWeightWatcherDao


    @Inject
    @Named("test_db")
    lateinit var database: CWWDBDatabase

    @Before
    fun setup() {
        daoCarbon = database.weightWatcherDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertWeightWatcherItem() = runBlockingTest {
        val weightWatcherModelItem = listOf(
            CarbonWeightWatcherModelItem(0, "filter", "imga", "testing"),
            CarbonWeightWatcherModelItem(1, "filterTwo", "imga", "testing")
        )

        daoCarbon.saveCarbonWeightWatcher(weightWatcherModelItem)


//        val allWeightWatcher = daoCarbon.getCarbonWeightWatcher().count()
//
//        assertThat(allWeightWatcher).isGreaterThan(0)
    }

    @Test
    fun deleteWeightWatcherItem() = runBlockingTest {
        val weightWatcherModelItem = listOf(
            CarbonWeightWatcherModelItem(0, "filter", "imga", "testing"),
            CarbonWeightWatcherModelItem(1, "filterTwo", "imga", "testing")
        )
        daoCarbon.saveCarbonWeightWatcher(weightWatcherModelItem)
        daoCarbon.deleteCarbonAllWeightWatcher()

//        val allWeightWatcher = dao.getWeightWatcher().getOrAwaitValue()
//
//        assertThat(allWeightWatcher).isEmpty()
    }


}













