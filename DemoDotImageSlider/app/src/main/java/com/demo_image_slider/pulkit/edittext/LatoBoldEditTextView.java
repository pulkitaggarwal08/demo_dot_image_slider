package com.demo_image_slider.pulkit.edittext;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by pankaj on 07/05/16.
 */
public class LatoBoldEditTextView extends AppCompatEditText {

    public LatoBoldEditTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LatoBoldEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoBoldEditTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Bold.ttf");
        setTypeface(typeface ,1);

    }
}
