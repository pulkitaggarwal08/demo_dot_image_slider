package com.demo_image_slider.pulkit.button;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by pankaj on 07/05/16.
 */
public class LatoBoldButton extends AppCompatButton {

    public LatoBoldButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoBoldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoBoldButton(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Bold.ttf");
        setTypeface(typeface ,1);

    }
}
