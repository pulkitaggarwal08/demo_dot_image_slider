package com.demo_image_slider.pulkit.button;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by pankaj on 07/05/16.
 */
public class LatoMediumButton extends AppCompatTextView {

    public LatoMediumButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoMediumButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoMediumButton(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(typeface ,1);

    }
}
