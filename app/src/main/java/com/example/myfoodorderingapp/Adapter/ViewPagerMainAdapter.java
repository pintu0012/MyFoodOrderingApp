package com.example.myfoodorderingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myfoodorderingapp.Model.RestaurantSliderModel;
import com.example.myfoodorderingapp.R;

import java.util.ArrayList;

public class ViewPagerMainAdapter extends PagerAdapter {

    Context context;
    private ArrayList<RestaurantSliderModel> itemList;

    public ViewPagerMainAdapter(Context context, ArrayList<RestaurantSliderModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager_main_item, container, false);
        ImageView imageView = item.findViewById(R.id.imageview);

        imageView.setImageResource(itemList.get(position).getImage());

        container.addView(item);
        return item;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
