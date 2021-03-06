package com.carbonWeightwatchers.cww.dataModuleTest

import com.carbonWeightwatchers.cww.data.api.CarbonWeightWatcherService
import com.carbonWeightwatchers.cww.utils.BaseUnitTest
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidTest
@ExperimentalCoroutinesApi
class WeightWatcherRemoteDataSourceImpTest : BaseUnitTest() {


    lateinit var carbonWeightWatcherAPIService: CarbonWeightWatcherService
    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setsUp() {
        mockWebServer = MockWebServer()
        carbonWeightWatcherAPIService = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CarbonWeightWatcherService::class.java)
    }


    fun enqueueMockUpResponse(fileName: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        val source = inputStream?.source()?.buffer()

        val mockResponse = MockResponse()
        mockResponse.setBody(source!!.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }


    @Test
    fun checkFakeResponseList() {
        runBlocking {
            enqueueMockUpResponse("ww_posts.json")
            val respose = carbonWeightWatcherAPIService.getCarbonWeightWatcherApi().body()
            val predefineResponse = mockWebServer.takeRequest()
            assertThat(respose).isNotNull()
            assertThat(predefineResponse.path).isEqualTo("/assets/cmx/us/messages/collections.json")
        }
    }


    @Test
    fun getWeightWatcherFakeResponse() {
        runBlocking {

            enqueueMockUpResponse("ww_posts.json")

            val respose = carbonWeightWatcherAPIService.getCarbonWeightWatcherApi().body()
            assertThat(respose).isNotNull()
            assertThat(respose?.get(0)?.title).isEqualTo("Summer Grilling")

        }
    }


}