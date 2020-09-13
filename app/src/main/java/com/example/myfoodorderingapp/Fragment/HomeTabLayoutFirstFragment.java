package com.example.myfoodorderingapp.Fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodorderingapp.Adapter.HomeTabRecyclerAdapter;
import com.example.myfoodorderingapp.Model.CategoryItemModel;
import com.example.myfoodorderingapp.R;

import java.util.ArrayList;


public class HomeTabLayoutFirstFragment extends Fragment {

    private RecyclerView category_first_recycler;
    private ArrayList<CategoryItemModel> categoryModelArrayList;
    private RelativeLayout loading_layout;
    private String isFrom;

    public HomeTabLayoutFirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_first_fragment_tablayout, container, false);
        category_first_recycler = view.findViewById(R.id.recyclerview);
        loading_layout = view.findViewById(R.id.loading_layout);

        if (getArguments()!=null){
            isFrom = getArguments().getString("isFrom");
        }

        SHOW_LOADING_FOR_THREE_SECONDS();

        return view;
    }

    private void SHOW_LOADING_FOR_THREE_SECONDS() {

        SHOW_LOADING_SCREEN();
        View view = loading_layout;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                loading_layout.setVisibility(View.GONE);
                if (isFrom.equals("RESTAURANT")){
                    GET_MENU_ITEMS();
                }else {
                    GET_CATEGOR_FIRST_DATA();
                }
            }
        }, 2000);

    }

    private void GET_CATEGOR_FIRST_DATA() {

        categoryModelArrayList = new ArrayList<>();
        categoryModelArrayList.add(new CategoryItemModel("0", "Nawab's Food", R.drawable.burger, 3.7, 9.2, "Burger", "20-30 min", "95"));
        categoryModelArrayList.add(new CategoryItemModel("1", "PizzaHut", R.drawable.pizza, 4.5, 12.6, "Pizza", "15-20 min", "89"));
        categoryModelArrayList.add(new CategoryItemModel("2", "Mc Donald's", R.drawable.market, 4.9, 14.9, "Burger", "30-40 min", "100"));
        categoryModelArrayList.add(new CategoryItemModel("3", "KFC", R.drawable.restorant, 3.6, 5.2, "Chicken", "50-60 min", "500"));

        if (categoryModelArrayList != null && categoryModelArrayList.size() != 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            category_first_recycler.setLayoutManager(linearLayoutManager);
            category_first_recycler.setNestedScrollingEnabled(false);

            int resId = R.anim.recycler_view_layout_animation;
            if (getActivity()!=null) {
                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
                category_first_recycler.setLayoutAnimation(animation);
            }
            HomeTabRecyclerAdapter pAdapter = new HomeTabRecyclerAdapter(getActivity(), getActivity(), categoryModelArrayList);
            category_first_recycler.setAdapter(pAdapter);
        } else {
            category_first_recycler.setVisibility(View.GONE);
        }
    }

    private void GET_MENU_ITEMS() {

        categoryModelArrayList = new ArrayList<>();
        categoryModelArrayList.add(new CategoryItemModel("0", "Chef's Burger", R.drawable.burger, 3.7, 9.2, "Burger", "20-30 min", "95"));
        categoryModelArrayList.add(new CategoryItemModel("1", "Italian Pizza", R.drawable.pizza, 4.5, 12.6, "Pizza", "15-20 min", "89"));
        categoryModelArrayList.add(new CategoryItemModel("2", "Donut", R.drawable.donut, 4.9, 14.9, "Burger", "30-40 min", "100"));
        categoryModelArrayList.add(new CategoryItemModel("3", "Nachos", R.drawable.nachos, 3.6, 5.2, "Chicken", "50-60 min", "500"));

        if (categoryModelArrayList != null && categoryModelArrayList.size() != 0) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            category_first_recycler.setLayoutManager(linearLayoutManager);
            category_first_recycler.setNestedScrollingEnabled(false);

            int resId = R.anim.recycler_view_layout_animation;
            if (getActivity()!=null) {
                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
                category_first_recycler.setLayoutAnimation(animation);
            }
            HomeTabRecyclerAdapter pAdapter = new HomeTabRecyclerAdapter(getActivity(), getActivity(), categoryModelArrayList);
            category_first_recycler.setAdapter(pAdapter);
        } else {
            category_first_recycler.setVisibility(View.GONE);
        }
    }

    void SHOW_LOADING_SCREEN() {

        loading_layout.setVisibility(View.VISIBLE);

    }

    void HIDE_LOADING_SCREEN() {

        loading_layout.setVisibility(View.GONE);
    }
}
