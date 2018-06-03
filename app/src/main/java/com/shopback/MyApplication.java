package com.shopback;

import android.app.Application;
import android.support.v4.BuildConfig;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.shopback.di.ApplicationComponent;
import com.shopback.di.ApplicationModule;
import com.shopback.di.DaggerApplicationComponent;
import com.shopback.di.NetworkModule;
import com.shopback.di.UserListResponse;

import java.util.ArrayList;

import timber.log.Timber;


public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;
    public ArrayList<UserListResponse> UserList = new ArrayList<UserListResponse>();
    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        initializeTimber();
        initializeFresco();
    }

    private void initializeTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    private void initializeFresco() {

        Fresco.initialize(this);
    }

    private void initializeInjector() {
        applicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(this))
                        .networkModule(new NetworkModule())
                        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void addUserList(UserListResponse add) {
        UserList.add(add);
    }

    public ArrayList<UserListResponse> getUserList() {
        return UserList;
    }

    public void clearUserList()
    {
        UserList.clear();
    }

}
