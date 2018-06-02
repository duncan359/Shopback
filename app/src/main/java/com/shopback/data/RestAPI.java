package com.shopback.data;

import com.shopback.di.UserListResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RestAPI {
    @GET("users")
    Flowable <List<UserListResponse>> Userlist (@Query("since") String since);

    @GET("users/{username}")
    Flowable<UserDetail> getUser(@Path("username") String username);
}
