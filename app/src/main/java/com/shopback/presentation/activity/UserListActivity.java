package com.shopback.presentation.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.shopback.MyApplication;
import com.shopback.R;

import com.shopback.data.UserDetail;
import com.shopback.di.UserListResponse;
import com.shopback.presentation.Navigator.Navigator;
import com.shopback.presentation.adapter.UserListAdapter;
import com.shopback.presentation.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class UserListActivity extends BaseActivity implements MainPresenter.MainView  {

    @Inject
    MainPresenter presenter;

    Context context;
    Message msg;
    public String since="0";
    public String per_page="30";
    public int count =0;
    @BindView(R.id.listview_product)
    ListView lvProduct;
    @BindView(R.id.ll_home)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.ll_pro)
    LinearLayout ll_pro;
    public View ftView;
    public Handler mHandler;
    private UserListAdapter adapter;
    public boolean isLoading = false;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_userlist;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initializeDagger();
        initializePresenter();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initData();
        presenter.UserList(since,per_page);
        toolbar.setTitle(getResources().getString(R.string.id_githubusers));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_pagi) {
                    Navigator.startPagarActivity(context);
                    finish();
                }


                return true;
            }
        });
        mSwipeRefreshLayout.setEnabled(false);
    }
    private void initData() {
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ftView = li.inflate(R.layout.footer_view, null);
        mHandler = new MyHandler();
        context=this;

    }
    @Override
    public void onBackPressed() {
    }
    private void initializePresenter() {
        presenter.setView(this);
    }
    private void initializeDagger() {
        ((MyApplication) getApplication()).getApplicationComponent().inject(this);
    }

    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lvProduct.addFooterView(ftView);
                    break;
                case 1:
                    adapter.addListItemToAdapter((ArrayList<UserListResponse>)msg.obj);
                    lvProduct.removeFooterView(ftView);
                    mSwipeRefreshLayout.setRefreshing(false);
                    if(count<100)
                    {
                        isLoading=false;
                    }
                    break;
                case 2:
                    mSwipeRefreshLayout.setRefreshing(false);
                    lvProduct.removeFooterView(ftView);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, UserListActivity.class);
        return intent;

    }


    @Override
    public void UserList(List<UserListResponse> result) {

        if(result.size()>0)
        {
            if(count==0) {
                ll_pro.setVisibility(View.GONE);
                msg = mHandler.obtainMessage(2);
                adapter = new UserListAdapter(this, result);
                lvProduct.setAdapter(adapter);
                lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        UserListResponse result =  (UserListResponse) adapter.getItem(position);
                        Navigator.startDetailActivity(context,result.getLogin());
                    }
                });

                mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshContent();
                    }
                });
                lvProduct.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {

                    }

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                        lvProduct.requestFocus();

                        if(view.getLastVisiblePosition() == totalItemCount-1 && lvProduct.getCount() >=30&& isLoading == false) {
                            isLoading = true;
                            presenter.UserList(since,per_page);
                            mHandler.sendEmptyMessage(0);
                        }
                        int topRowVerticalPosition =
                                (lvProduct == null || lvProduct.getChildCount() == 0) ?
                                        0 : lvProduct.getChildAt(0).getTop();
                        mSwipeRefreshLayout.setEnabled(firstVisibleItem == 0 && topRowVerticalPosition >= 0);
                    }
                });
            }
            else
            {
                msg = mHandler.obtainMessage(1, result);
                mHandler.sendMessage(msg);
            }
            count+=result.size();
            since = String.valueOf(result.get(result.size()-1).getId());
        }
    }

    private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                count=0;
                since="0";
                presenter.UserList(since,per_page);
            }
        },0);
    }
    @Override
    public void UserDetail(UserDetail result) {

    }

    @Override
    public void httpError() {
        lvProduct.removeFooterView(ftView);
        mSwipeRefreshLayout.setRefreshing(false);
        ll_pro.setVisibility(View.GONE);
        showToast(getResources().getString(R.string.txt_interneterror));
    }
}
