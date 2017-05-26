package com.example.a39092.rxjavatest.module.main.view

import android.os.Bundle
import android.widget.ListView
import com.example.a39092.rxjavatest.R
import com.example.a39092.rxjavatest.model.bean.ResponseBody
import com.example.a39092.rxjavatest.module.base.BaseActivity
import com.example.a39092.rxjavatest.module.main.presenter.MainPresenter
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

class MainActivity : BaseActivity(), MainView {


    var lvMovie: ListView? = null
    private var presenter: MainPresenter? = null

    private var adapter: LvMovieAdapter? = null
    private var movies: ArrayList<ResponseBody.SubjectsBean>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        initView()
        initData()
    }

    override fun initPresenter() {
        presenter = MainPresenter(this)
    }

    override fun initView() {
        lvMovie = findViewById(R.id.lv_movie) as ListView?
        movies = ArrayList<ResponseBody.SubjectsBean>()
        adapter = LvMovieAdapter(movies!!, this)
        lvMovie!!.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    override fun initData() {
        presenter!!.getMovies(1, 10)
    }

    override fun onLoadMovies(response: Observable<ResponseBody>) {
        response.compose(this.bindToLifecycle<ResponseBody>()).subscribe(object : Observer<ResponseBody> {
            override fun onSubscribe(d: Disposable) {
                showProgress()
            }

            override fun onNext(value: ResponseBody) {
                movies!!.addAll(value.subjects!!)
            }

            override fun onError(e: Throwable) {}

            override fun onComplete() {
                hideProgress()
                adapter!!.notifyDataSetChanged()
            }
        })
    }
}
