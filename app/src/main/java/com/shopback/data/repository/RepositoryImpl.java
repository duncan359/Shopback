package com.shopback.data.repository;


import com.shopback.data.RestAPI;
import com.shopback.data.UserDetail;
import com.shopback.di.UserListResponse;

import org.reactivestreams.Subscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Duncan Lim on 2/6/2018.
 */

public class RepositoryImpl implements Repository {

    private final RestAPI api;
    @Inject
    public RepositoryImpl(RestAPI api) {
        this.api = api;
    }

    @Override
    public void UserList(Subscriber<List<UserListResponse>> subscriber, String since) {
        api.Userlist(since)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void UserDetail(Subscriber<UserDetail> subscriber, String username) {
        api.getUser(username)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
