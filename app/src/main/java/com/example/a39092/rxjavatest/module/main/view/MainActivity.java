package com.example.a39092.rxjavatest.module.main.view;

import android.os.Bundle;
import android.widget.ListView;

import com.example.a39092.rxjavatest.R;
import com.example.a39092.rxjavatest.model.bean.ResponseBody;
import com.example.a39092.rxjavatest.module.base.BaseActivity;
import com.example.a39092.rxjavatest.module.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity implements MainView {


    @BindView(R.id.lv_movie)
    ListView lvMovie;


    private MainPresenter presenter;

    private LvMovieAdapter adapter;
    private List<ResponseBody.SubjectsBean> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
        initView();
        initData();
    }

    @Override
    public void initPresenter() {
        presenter = new MainPresenter(this);
    }

    @Override
    public void initView() {
        movies = new ArrayList<>();
        adapter = new LvMovieAdapter(movies, this);
        lvMovie.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
        presenter.getMovies(1, 10);
    }

    @Override
    public void onLoadMovies(final Observable<ResponseBody> response) {
        response.compose(this.<ResponseBody>bindToLifecycle()).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
                showProgress();
            }

            @Override
            public void onNext(ResponseBody value) {
                movies.addAll(value.getSubjects());
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                hideProgress();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
