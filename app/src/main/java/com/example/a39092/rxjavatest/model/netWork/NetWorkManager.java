package com.example.a39092.rxjavatest.model.netWork;

import com.example.a39092.rxjavatest.model.bean.ResponseBody;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 39092 on 2017/4/5.
 */

public class NetWorkManager {
    private static NetWorkManager mNetWorkManager;
    private final String BASEURL = "https://api.douban.com/";
    private static final int DEFAULT_TIMEOUT = 5;
    private final HttpApiService mHttpApiService;

    private NetWorkManager() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mHttpApiService = new Retrofit.Builder().client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASEURL)
                .build()
                .create(HttpApiService.class);
    }

    public static NetWorkManager getInstance() {
        if (mNetWorkManager == null) {
            synchronized (NetWorkManager.class) {
                mNetWorkManager = new NetWorkManager();
            }
        }
        return mNetWorkManager;
    }

    public Observable<ResponseBody> getMovies(int start, int count) {
        return mHttpApiService.getMovies(start, count).compose(ThreadUtils.<ResponseBody>IO_MAIN());
    }
}
