package com.example.mthree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MyViewPagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public MyViewPagerAdapter(Context context){
    this.context = context;
    }

    public int[] tut = {
            R.drawable.pageviewer1,
            R.drawable.pageviewer1,
            R.drawable.pageviewer1,
            R.drawable.pageviewer1,
    };

    @Override
    public int getCount() {
        return tut.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideitem,container,false);
        ImageView imageView = view.findViewById(R.id.imageViewSlide);
        imageView.setImageResource(tut[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
