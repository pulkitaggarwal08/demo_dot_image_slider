package com.demo_image_slider.pulkit;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.demo_image_slider.pulkit.activities.DashBoardActivity;
import com.demo_image_slider.pulkit.adapter.ViewPagerAdapter;
import com.demo_image_slider.pulkit.circleindicator.CirclePageIndicator;
import com.demo_image_slider.pulkit.circleindicator.PageIndicator;
import com.demo_image_slider.pulkit.util.ColorShades;

import at.markushi.ui.CircleButton;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter mAdapter;
    private ViewPager viewPager;
    private PageIndicator circlePageIndicator;
    private int viewPagerSize;
    private CircleButton btnNext;
    private static final String SAVING_STATE_SLIDER_ANIMATION = "SliderAnimationSavingState";
    private boolean isSliderAnimation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }

    private void findIds() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_indicator);
        btnNext = (CircleButton) findViewById(R.id.btn_next);
    }

    private void init() {
        //Todo: remove this comment and run this code, so that slider will not run again.
//        if (AppPreference.getInstance().isNotLoggedIn()) {
//            Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(mIntent);
//            finish();
//        }

        mAdapter = new ViewPagerAdapter(getApplicationContext(), R.array.icons, R.array.titles);
        viewPagerSize = getResources().getIntArray(R.array.icons).length;

        viewPager.setAdapter(mAdapter);
        circlePageIndicator.setViewPager(viewPager);

        viewPager.setPageTransformer(true, new CustomPageTransformer());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                View landingBGView = findViewById(R.id.landing_background);
                int colorBg[] = getResources().getIntArray(R.array.landing_bg);

                ColorShades shades = new ColorShades();
                shades.setFromColor(colorBg[position % colorBg.length])
                        .setToColor(colorBg[(position + 1) % colorBg.length])
                        .setShade(positionOffset);

                landingBGView.setBackgroundColor(shades.generate());
            }

            @Override
            public void onPageSelected(int position) {
                if (position == viewPagerSize - 1) {
                    btnNext.setImageResource(R.drawable.ic_check);
                } else {
                    btnNext.setImageResource(R.drawable.ic_next);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = viewPager.getCurrentItem();
                if (pos == viewPagerSize - 1) {
                    btnNext.setImageResource(R.drawable.ic_check);
                    gotoMainActivity();
                    //Todo: save some value to appPreference, so that this slider will not run again.
                } else if (pos < viewPagerSize - 1) {
                    goToNext();
                }
            }
        });

    }

    private void gotoMainActivity() {
        Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToNext() {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    public class CustomPageTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            View imageView = view.findViewById(R.id.img_instruction);
            //View contentView = view.findViewById(R.id.landing_txt_hint);
            View txt_title = view.findViewById(R.id.txt_header);

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left
                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position);
                setTranslationX(txt_title, pageWidth * position);
                setAlpha(txt_title, 1 + position);
                if (imageView != null) {
                    // Fade the image in
                    setAlpha(imageView, 1 + position);
                }
            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position);
                setTranslationX(txt_title, pageWidth * position);
                setAlpha(txt_title, 1 - position);
                if (imageView != null) {
                    // Fade the image out
                    setAlpha(imageView, 1 - position);
                }
            }
        }
    }

    private void setAlpha(View view, float alpha) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && !isSliderAnimation) {
            view.setAlpha(alpha);
        }
    }

    private void setTranslationX(View view, float translationX) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && !isSliderAnimation) {
            view.setTranslationX(translationX);
        }
    }

    public void onSaveInstanceState(Bundle outstate) {

        if (outstate != null) {
            outstate.putBoolean(SAVING_STATE_SLIDER_ANIMATION, isSliderAnimation);
        }

        super.onSaveInstanceState(outstate);
    }

    public void onRestoreInstanceState(Bundle inState) {

        if (inState != null) {
            isSliderAnimation = inState.getBoolean(SAVING_STATE_SLIDER_ANIMATION, false);
        }
        super.onRestoreInstanceState(inState);

    }

}
