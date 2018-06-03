package com.shopback.data.repository;




import com.shopback.data.UserDetail;
import com.shopback.di.UserListResponse;

import org.reactivestreams.Subscriber;

import java.util.List;


/**
 * Created by Duncan Lim on 2/6/2018.
 */

public interface Repository {
    void UserList(Subscriber<List<UserListResponse>> subscriber, String since, String per_page) ;
    void UserDetail(Subscriber<UserDetail> subscriber, String username) ;
}
