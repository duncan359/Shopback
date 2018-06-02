package com.shopback;

import android.app.Application;
import android.support.v4.BuildConfig;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.shopback.di.ApplicationComponent;
import com.shopback.di.ApplicationModule;
import com.shopback.di.DaggerApplicationComponent;
import com.shopback.di.NetworkModule;

import timber.log.Timber;


/**
 * Application class to initialize Dagger and Timber
 */
public class MyApplication extends Application {

    private ApplicationComponent applicationComponent;

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
}
