package com.shopback.di;

import android.content.Context;

import com.shopback.data.RestAPI;
import com.shopback.data.repository.Repository;
import com.shopback.data.repository.RepositoryImpl;

import javax.inject.Named;
import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Dagger Module providing application wide dependencies
 */
@Module
public class ApplicationModule {

    private final Context context;
    public static final String NAME_UI_THREAD = "ui_thread";
    public static final String NAME_EXECUTOR_THREAD = "executor_thread";

    public ApplicationModule(Context context) {
        this.context = context.getApplicationContext();
    }


    @Provides
    @Named(NAME_UI_THREAD)
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named(NAME_EXECUTOR_THREAD)
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.context;
    }


    @Provides
    @Singleton
    RestAPI provideDogAPI(Retrofit retrofit) {
        return retrofit.create(RestAPI.class);
    }

    @Provides
    @Singleton
    public Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }
//
//    @Provides
//    @Singleton
//    public DogRepository provideDogRepository(DogRepositoryImpl repository) {
//        return repository;
//    }
//

}
