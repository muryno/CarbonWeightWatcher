package com.carbonWeightwatchers.cww.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.carbonWeightwatchers.cww.BuildConfig
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Weight_Watcher_Model_Item")
data class CarbonWeightWatcherModelItem(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("filter")
    val filter: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
) : Serializable {

    fun imageUrl(): String = BuildConfig.BASE_URL + image


}