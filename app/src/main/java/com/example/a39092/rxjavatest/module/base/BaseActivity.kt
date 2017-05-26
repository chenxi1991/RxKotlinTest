package com.example.a39092.rxjavatest.module.base

import android.app.ProgressDialog
import android.os.Bundle

import com.trello.rxlifecycle2.components.RxActivity

/**
 * @author chenxi
 * *
 * @title RxJavaTest
 * *
 * @date 2017/4/13
 * *
 * @description
 */


open class BaseActivity : RxActivity() {
    internal var mDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initProgressDialog()
    }

    open fun initPresenter() {}

    open fun initData() {}

    open fun initView() {}

    fun showProgress() {
        if (mDialog == null)
            initProgressDialog()
        mDialog!!.show()
    }

    fun hideProgress() {
        if (mDialog != null)
            mDialog!!.dismiss()
    }

    private fun initProgressDialog() {
        mDialog = ProgressDialog(this, ProgressDialog.STYLE_SPINNER)
        mDialog!!.setMessage("加载数据")
    }
}
