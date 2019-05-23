package com.example.dneprovdanila.stack_overflow_android;

import android.nfc.Tag;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.util.Log;


import com.example.dneprovdanila.stack_overflow_android.POJO.API;
import com.example.dneprovdanila.stack_overflow_android.POJO.Item;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.Observable;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {



    private static final String TAG =  "TAG";
    RecyclerView recyclerView;
    ArrayList<Item> items;
    SwipeRefreshLayout swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        //Log.d(Html.,"113");
        setContentView(R.layout.activity_main);


        Log.e(TAG, "onCreate");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        getProductData();


        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getProductData();
            }
        });
    }




    public void getProductData() {

        Log.e(TAG, "getProductData");


        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setRefreshing(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.url))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();



        APiService apiService = retrofit.create(APiService.class);

        Observable<API> observable = apiService.getproductdata(100,"desc", "activity","android", "stackoverflow").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());





        Log.e(TAG, "pre subscribe");


        observable.subscribe(new DisposableObserver<API>() {
            @Override
            public void onNext(API api) {

                Log.e(TAG, "onNext");

                items = (ArrayList<Item>)api.getItems();
                Toast.makeText(getApplicationContext(), "onNext", Toast.LENGTH_LONG).show();
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(items);
                RecyclerView.LayoutManager recycle = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(recycle);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");

            }
        });

        swipe.setRefreshing(false);
        Log.e(TAG, "Finish");

    }
}

