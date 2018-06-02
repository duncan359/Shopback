package com.shopback.presentation.viewmodel;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by Duncan on 30/6/2016.
 */
public class MyCustomEditText extends android.support.v7.widget.AppCompatEditText {
    public MyCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(),"fonts/MyriadPro-Regular.ttf"));


    }
}
