package com.demo_image_slider.pulkit.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by pulkit on 11/3/18.
 */

public class LatoMediumTextView extends AppCompatTextView {

    public LatoMediumTextView(Context context) {
        super(context);
        init();
    }

    public LatoMediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LatoMediumTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(typeface, 1);
    }

}
