package com.demo_image_slider.pulkit.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by pankaj on 07/05/16.
 */
public class LatoMediumEditTextView extends AppCompatEditText {

    public LatoMediumEditTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoMediumEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoMediumEditTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(typeface ,1);

    }
}
