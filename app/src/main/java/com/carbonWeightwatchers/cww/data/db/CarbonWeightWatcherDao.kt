package com.carbonWeightwatchers.cww.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CarbonWeightWatcherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCarbonWeightWatcher(wwList: List<CarbonWeightWatcherModelItem>)

    @Query("DELETE FROM Weight_Watcher_Model_Item")
    suspend fun deleteCarbonAllWeightWatcher()

    @Query("SELECT * FROM Weight_Watcher_Model_Item")
    fun getCarbonWeightWatcher(): Flow<List<CarbonWeightWatcherModelItem>>
}