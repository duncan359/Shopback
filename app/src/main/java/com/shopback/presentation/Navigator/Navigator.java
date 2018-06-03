package com.shopback.presentation.Navigator;

import android.content.Context;
import android.content.Intent;

import com.shopback.presentation.activity.UserDetailActivity;
import com.shopback.presentation.activity.UserListActivity;
import com.shopback.presentation.activity.UserPagarListActivity;


public class Navigator {


    public static void startDetailActivity(Context context, String Username) {

        if (context == null) {
            throw new IllegalArgumentException("context or breedName is null");
        }
        Intent intent = UserDetailActivity.getCallingIntent(context);
        intent.putExtra("Username",Username);
        context.startActivity(intent);

    }

    public static void startMainActivity(Context context) {

        if (context == null) {
            throw new IllegalArgumentException("context or breedName is null");
        }
        Intent intent = UserListActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public static void startPagarActivity(Context context) {

        if (context == null) {
            throw new IllegalArgumentException("context or breedName is null");
        }
        Intent intent = UserPagarListActivity.getCallingIntent(context);
        context.startActivity(intent);
    }



}
