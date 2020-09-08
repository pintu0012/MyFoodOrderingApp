package com.example.myfoodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import com.example.myfoodorderingapp.Adapter.HomeTabLayoutAdapter;
import com.example.myfoodorderingapp.Adapter.ViewPagerMainAdapter;
import com.example.myfoodorderingapp.Model.RestaurantSliderModel;
import com.example.myfoodorderingapp.R;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RestaurantActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPager slider_pager_id;
    private WormDotsIndicator worm_dots_indicator;
    private int currentPage = 0;
    private Timer timer;
    private final long DELAY_MS = 500;
    private final long PERIOD_MS = 3000;
    private ImageButton favorite_button,back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        initialiseViews();
        getSliderView();
        SETUP_TABLAYOUT();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void initialiseViews() {
        favorite_button = findViewById(R.id.favorite_button);
        back_button= findViewById(R.id.back_button);
        slider_pager_id = findViewById(R.id.slider_pager_id);
        worm_dots_indicator = findViewById(R.id.worm_dots_indicator);
        tabLayout= findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.pager);
    }
    /************** Slider Pager***********/
    public void getSliderView() {

        ArrayList<RestaurantSliderModel> viewPagerModelArrayList = new ArrayList<>();
        viewPagerModelArrayList.add(new RestaurantSliderModel("0", R.drawable.pizza));
        viewPagerModelArrayList.add(new RestaurantSliderModel("1", R.drawable.burger));
        viewPagerModelArrayList.add(new RestaurantSliderModel("2", R.drawable.nachos));
        viewPagerModelArrayList.add(new RestaurantSliderModel("3", R.drawable.fries));
        viewPagerModelArrayList.add(new RestaurantSliderModel("4", R.drawable.donut));

        final ViewPagerMainAdapter viewPagerMainAdapter = new ViewPagerMainAdapter(RestaurantActivity.this, viewPagerModelArrayList);
        slider_pager_id.setAdapter(viewPagerMainAdapter);
//         viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        worm_dots_indicator.setViewPager(slider_pager_id);

        try {
            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == viewPagerMainAdapter.getCount()) {
                        currentPage = 0;
                    }
                    slider_pager_id.setCurrentItem(currentPage++, true);
                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                }
            }, DELAY_MS, PERIOD_MS);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
    }

    /********* End Pager****************/

    private void SETUP_TABLAYOUT() {

        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Speed"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourite"));
        tabLayout.addTab(tabLayout.newTab().setText("Rating"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        HomeTabLayoutAdapter categoryTabLayoutAdapter = new HomeTabLayoutAdapter(RestaurantActivity.this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(categoryTabLayoutAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
