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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
import butterknife.OnClick;

public class UserPagarListActivity extends BaseActivity implements MainPresenter.MainView  {

    @Inject
    MainPresenter presenter;
    int prevStart=0;
    Context context;
    public String since="0";
    public int count =0;
    @BindView(R.id.listview_product)
    ListView lvProduct;
    @BindView(R.id.ll_home)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.ll_pro)
    LinearLayout ll_pro;
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.btn_prev)
    Button btn_prev;
    @BindView(R.id.title)
    TextView title;
    private int increment = 1;
    private int pageCount;
    public int TOTAL_LIST_ITEMS = 100;
    public int NUM_ITEMS_PAGE   = 20;
    private UserListAdapter adapter;
    public boolean isLoading = false;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_userpagarlist;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initializeDagger();
        initializePresenter();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initData();
        toolbar.setTitle(getResources().getString(R.string.id_githubusers));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_npagi) {
                    Navigator.startMainActivity(context);
                    finish();
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
    private void initData() {
        context=this;
        int val = TOTAL_LIST_ITEMS%NUM_ITEMS_PAGE;
        val = val==0?0:1;
        pageCount = TOTAL_LIST_ITEMS/NUM_ITEMS_PAGE+val;
        presenter.UserList(since,"100");
        CheckEnable();
        mSwipeRefreshLayout.setEnabled(false);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
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
    @OnClick(R.id.btn_prev)
    void onPrev()
    {
        increment--;
        loadList(increment,false);
        CheckEnable();
    }

    @OnClick(R.id.btn_next)
    void onNext()
    {
        increment++;
        loadList(increment,true);
        CheckEnable();
    }
    private void CheckEnable()
    {
        if(increment == pageCount)
        {
            btn_next.setEnabled(false);
        }
        else if(increment == 1)
        {
            btn_prev.setEnabled(false);
        }
        else
        {
            btn_prev.setEnabled(true);
            btn_next.setEnabled(true);
        }
    }
    private void loadList(int number,boolean position)
    {
        mSwipeRefreshLayout.setRefreshing(false);
        ll_pro.setVisibility(View.GONE);
        ArrayList<String> sort = new ArrayList<String>();
        title.setText("Page "+(number)+" of "+pageCount);
        int start = number * NUM_ITEMS_PAGE;
        ArrayList<UserListResponse> result;
        if(position) {
           result = new ArrayList<>(((MyApplication) getApplication()).getUserList().subList(prevStart, start));
        }
        else
        {
            result = new ArrayList<>(((MyApplication) getApplication()).getUserList().subList(prevStart-(NUM_ITEMS_PAGE*2), start));
        }
        adapter = new UserListAdapter(this, result);
        lvProduct.setAdapter(adapter);
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserListResponse result =  (UserListResponse) adapter.getItem(position);
                Navigator.startDetailActivity(context,result.getLogin());
            }
        });
        lvProduct.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lvProduct.requestFocus();
                int topRowVerticalPosition =
                        (lvProduct == null || lvProduct.getChildCount() == 0) ?
                                0 : lvProduct.getChildAt(0).getTop();
                mSwipeRefreshLayout.setEnabled(firstVisibleItem == 0 && topRowVerticalPosition >= 0&&increment==1);
            }
        });
        prevStart=start;
    }
    @Override
    public void hideLoading() {

    }
    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, UserPagarListActivity.class);
        return intent;

    }


    @Override
    public void UserList(List<UserListResponse> result) {
        ((MyApplication) getApplication()).clearUserList();
        if(result.size()>0)
        {
            for (int i = 0; i < result.size(); i++) {
                ((MyApplication) getApplication()).addUserList(result.get(i));
            }
            loadList(1,true);
        }
    }

    private void refreshContent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                prevStart=0;
                increment=1;
               // ll_pro.setVisibility(View.VISIBLE);
                presenter.UserList(since,"100");
            }
        },0);
    }
    @Override
    public void UserDetail(UserDetail result) {

    }
}
