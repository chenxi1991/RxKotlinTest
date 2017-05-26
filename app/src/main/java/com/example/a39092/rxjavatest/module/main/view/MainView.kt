package com.example.a39092.rxjavatest.module.main.view

import com.example.a39092.rxjavatest.model.bean.ResponseBody
import com.example.a39092.rxjavatest.module.base.BaseView

import io.reactivex.Observable

/**
 * @author chenxi
 * *
 * @title RxJavaTest
 * *
 * @date 2017/4/13
 * *
 * @description
 */


interface MainView : BaseView {
    fun onLoadMovies(response: Observable<ResponseBody>)
}

