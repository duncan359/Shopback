package com.shopback.presentation.activity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shopback.MyApplication;
import com.shopback.R;
import com.shopback.data.UserDetail;
import com.shopback.di.UserListResponse;
import com.shopback.presentation.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class UserDetailActivity extends BaseActivity implements MainPresenter.MainView  {
    @BindView(R.id.avatarImageView)
    SimpleDraweeView avatarImageView;
    @BindView(R.id.txt_num)
    TextView txt_num;
    @BindView(R.id.bioImageView)
    TextView bioImageView;
    @BindView(R.id.item_name)
    TextView item_name;
    @BindView(R.id.staffBadge)
    TextView staffBadge;
    @BindView(R.id.txt_location)
    TextView txt_location;
    @BindView(R.id.txt_url)
    TextView txt_url;
    @BindView(R.id.ll_pro)
    LinearLayout ll_pro;
    @BindView(R.id.ll_header)
    LinearLayout ll_header;
    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;
    @Inject
    MainPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initializeDagger();
        initializePresenter();
        initData();
    }
    private void initData() {
        Intent intent = getIntent();
        presenter.UserDetail(intent.getStringExtra("Username"));
    }
    private void initializePresenter() {
        presenter.setView(this);
    }
    private void initializeDagger() {
        ((MyApplication) getApplication()).getApplicationComponent().inject(this);
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        return intent;

    }


    @Override
    public void UserList(List<UserListResponse> result) {


    }


    @OnClick(R.id.btn_cancel)
    void cancal()
    {
        finish();
    }
    @Override
    public void UserDetail(UserDetail result) {
        ll_bottom.setVisibility(View.VISIBLE);
        ll_header.setVisibility(View.VISIBLE);
        ll_pro.setVisibility(View.GONE);
        if(result.getBlog()!=null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                txt_url.setText(Html.fromHtml("<a href=" + result.getBlog() + ">" + result.getBlog(), Html.FROM_HTML_MODE_COMPACT));
                txt_url.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                txt_url.setText(Html.fromHtml("<a href=" + result.getBlog() + ">" + result.getBlog()));
                txt_url.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        txt_location.setText(result.getLocation()==null?"":result.getLocation());
        item_name.setText(result.getLogin()==null?"":result.getLogin());
        txt_num.setText(result.getName()==null?"":result.getName());
        Uri imageUrl = Uri.parse(result.getAvatarUrl());
        avatarImageView.setImageURI(imageUrl);
        if(result.getBio()!=null) {
            bioImageView.setText(result.getBio());
        }
        if(result.isSiteAdmin())
        {
            staffBadge.setVisibility(View.VISIBLE);
        }
        else {
            staffBadge.setVisibility(View.GONE);
        }

    }
}
