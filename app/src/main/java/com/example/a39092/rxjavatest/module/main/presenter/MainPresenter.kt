package com.example.a39092.rxjavatest.module.main.presenter

import com.example.a39092.rxjavatest.model.netWork.NetWorkManager
import com.example.a39092.rxjavatest.model.bean.ResponseBody
import com.example.a39092.rxjavatest.module.base.BasePresenter
import com.example.a39092.rxjavatest.module.main.view.MainView

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author chenxi
 * *
 * @title RxJavaTest
 * *
 * @date 2017/4/13
 * *
 * @description
 */

class MainPresenter(mainView: MainView) : BasePresenter<MainView>() {
    init {
        mView = mainView
    }


    fun getMovies(pageNum: Int, pageSize: Int) {
        mView!!.onLoadMovies(NetWorkManager.instance.getMovies(pageNum, pageSize))
    }
}
