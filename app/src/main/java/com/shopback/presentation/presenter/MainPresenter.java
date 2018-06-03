package com.shopback.presentation.presenter;

import com.shopback.data.UserDetail;
import com.shopback.di.UserListResponse;
import com.shopback.data.repository.Repository;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Duncan Lim on 19/4/2018.
 */

public class MainPresenter extends Presenter<MainPresenter.MainView> {
    private final Repository repository;

    @Inject
    public MainPresenter(Repository repository)
    {
        this.repository=repository;
    }


    public void UserList(String since, String per_page)
    {
        Subscriber<List<UserListResponse>> sub = new Subscriber<List<UserListResponse>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onNext(List<UserListResponse> result) {
                getView().UserList(result);
            }
        };
        repository.UserList(sub,since,per_page);
    }


    public void UserDetail(String username)
    {
        Subscriber<UserDetail> sub = new Subscriber<UserDetail>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onNext(UserDetail result) {
                getView().UserDetail(result);
            }
        };
        repository.UserDetail(sub,username);
    }


    public interface MainView extends Presenter.View{
        void UserList(List<UserListResponse> result);
        void UserDetail(UserDetail result);
//        void PurchaseResult(GetResponse result);
//        void TopupResult(GetResponse result);
//        void TopupList(GetTopupResponse result);
//        void HistoryResult(GetHistoryResponse result);

    }
}
