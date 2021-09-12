package com.carbonWeightwatchers.cww.presenter.di

import android.content.Context
import androidx.room.Room
import com.carbonWeightwatchers.cww.data.db.CWWDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseAppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, CWWDBDatabase::class.java, "WeightWatcher").build()

//    @Singleton
//    @Provides
//    fun provideDefaultShoppingRepository(
//        dao: WeightWatcherDao,
//        api: PixabayAPI
//    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository

    @Singleton
    @Provides
    fun provideWeightWatcher(
        database: CWWDBDatabase
    ) = database.weightWatcherDao()



}

















