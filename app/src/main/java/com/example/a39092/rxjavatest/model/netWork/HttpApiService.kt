package com.example.a39092.rxjavatest.model.netWork

import com.example.a39092.rxjavatest.model.bean.ResponseBody

import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by 39092 on 2017/4/5.
 */

interface HttpApiService {
    @POST("v2/movie/top250")
    fun getMovies(@Query("start") start: Int, @Query("count") count: Int): Observable<ResponseBody>
}
