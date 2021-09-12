package com.carbonWeightwatchers.cww.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem


@Database(
    entities = [CarbonWeightWatcherModelItem::class],
    version = 1,
    exportSchema = false
)
abstract class CWWDBDatabase : RoomDatabase() {
    abstract fun weightWatcherDao(): CarbonWeightWatcherDao

}