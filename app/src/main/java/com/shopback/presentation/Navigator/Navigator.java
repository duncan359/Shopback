package com.shopback.presentation.Navigator;

import android.content.Context;
import android.content.Intent;

import com.shopback.presentation.activity.UserDetailActivity;


/**
 * Navigator responsible for app-wide screen navigation
 */

public class Navigator {


    public static void startDetailActivity(Context context, String Username) {

        if (context == null) {
            throw new IllegalArgumentException("context or breedName is null");
        }
        Intent intent = UserDetailActivity.getCallingIntent(context);
        intent.putExtra("Username",Username);
        context.startActivity(intent);

    }





}
