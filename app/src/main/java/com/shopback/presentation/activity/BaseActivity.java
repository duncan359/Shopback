package com.shopback.presentation.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;



public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bindViews();
        initView(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    private void bindViews() {
        ButterKnife.bind(this);
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showLoading(){
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Please wait");
        dialog.setCancelable(false);
        dialog.show();
    }

    protected void hideLoading(){
        dialog.hide();
    }
}
