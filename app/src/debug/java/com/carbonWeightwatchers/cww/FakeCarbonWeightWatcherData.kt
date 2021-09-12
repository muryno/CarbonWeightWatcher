package com.carbonWeightwatchers.cww

import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem


object FakeCarbonWeightWatcherData {

    const val FAKE_NETWORK_DELAY = 1000L

    val carbonWeightWatcher = listOf(
        CarbonWeightWatcherModelItem(
            id = 1,
            title = "muraino",
            image = "http",
            filter = "snacks"
        ),
        CarbonWeightWatcherModelItem(
            id = 2,
            title = "test2",
            image = "http2",
            filter = "snacks2"
        )

    )
}