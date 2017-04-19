package com.example.a39092.rxjavatest.module.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.RxActivity;

/**
 * @author chenxi
 * @title RxJavaTest
 * @date 2017/4/13
 * @description
 */


public class BaseActivity extends RxActivity {
    ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProgressDialog();
    }

    public void initPresenter() {
    }

    public void initData() {
    }

    public void initView() {
    }

    public void showProgress() {
        if (mDialog == null)
            initProgressDialog();
        mDialog.show();
    }

    public void hideProgress() {
        if (mDialog != null)
            mDialog.dismiss();
    }

    private void initProgressDialog() {
        mDialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        mDialog.setMessage("加载数据");
    }
}
