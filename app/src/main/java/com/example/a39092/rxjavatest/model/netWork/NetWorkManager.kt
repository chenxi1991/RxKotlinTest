package com.example.a39092.rxjavatest.model.netWork

import com.example.a39092.rxjavatest.model.bean.ResponseBody
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 39092 on 2017/4/5.
 */

class NetWorkManager private constructor() {
    private val BASEURL = "https://api.douban.com/"
    private val mHttpApiService: HttpApiService

    init {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        mHttpApiService = Retrofit.Builder().client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASEURL)
                .build()
                .create(HttpApiService::class.java)
    }

    fun getMovies(start: Int, count: Int): Observable<ResponseBody> {
        return mHttpApiService.getMovies(start, count).compose(ThreadUtils.IO_MAIN<ResponseBody>())
    }

    companion object {
        private var mNetWorkManager: NetWorkManager? = null
        private val DEFAULT_TIMEOUT = 5

        val instance: NetWorkManager
            get() {
                if (mNetWorkManager == null) {
                    synchronized(NetWorkManager::class.java) {
                        mNetWorkManager = NetWorkManager()
                    }
                }
                return mNetWorkManager!!
            }
    }
}
