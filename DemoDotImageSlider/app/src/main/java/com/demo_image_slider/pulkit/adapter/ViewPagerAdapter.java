package com.demo_image_slider.pulkit.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo_image_slider.pulkit.R;

/**
 * Created by pulkit on 11/3/18.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int iconResId, titleArrayResId;
    private Context context;

    public ViewPagerAdapter(Context context, int iconResId, int titleArrayResId) {
        this.context = context;
        this.iconResId = iconResId;
        this.titleArrayResId = titleArrayResId;
    }

    @Override
    public int getCount() {
        return context.getResources().getIntArray(iconResId).length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Drawable icon = context.getResources().obtainTypedArray(iconResId).getDrawable(position);
        String title = context.getResources().getStringArray(titleArrayResId)[position];

        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager, container, false);
        ImageView iconView = (ImageView) itemView.findViewById(R.id.img_instruction);
        TextView titleView = (TextView) itemView.findViewById(R.id.txt_header);

        iconView.setImageDrawable(icon);
        titleView.setText(title);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
