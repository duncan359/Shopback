package com.shopback.di;



import com.shopback.presentation.activity.UserDetailActivity;
import com.shopback.presentation.activity.UserListActivity;

import javax.inject.Singleton;


import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(UserListActivity activity);

    void inject(UserDetailActivity activity);

}