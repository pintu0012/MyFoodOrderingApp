package com.example.myfoodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myfoodorderingapp.Adapter.HomeTabLayoutAdapter;
import com.example.myfoodorderingapp.Adapter.ViewPagerMainAdapter;
import com.example.myfoodorderingapp.Model.CategoryItemModel;
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
    private ImageButton favorite_button, back_button;
    private CategoryItemModel categoryItemModel;
    private TextView restaurant_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        initialiseViews();
        getSliderView();
        SETUP_TABLAYOUT();

        if (getIntent().getExtras() != null) {

            categoryItemModel = (CategoryItemModel) getIntent().getSerializableExtra("MODEL");

        }

        restaurant_name.setText(categoryItemModel.getTitle());

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void initialiseViews() {
        restaurant_name = findViewById(R.id.restaurant_name);
        favorite_button = findViewById(R.id.favorite_button);
        back_button = findViewById(R.id.back_button);
        slider_pager_id = findViewById(R.id.slider_pager_id);
        worm_dots_indicator = findViewById(R.id.worm_dots_indicator);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
    }

    /************** Slider Pager***********/
    public void getSliderView() {

        ArrayList<RestaurantSliderModel> viewPagerModelArrayList = new ArrayList<>();
        viewPagerModelArrayList.add(new RestaurantSliderModel("0", R.drawable.pizza,
                "https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&auto=format&fit=crop&w=1500&q=80"));
        viewPagerModelArrayList.add(new RestaurantSliderModel("1", R.drawable.burger,
                "https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"));
        viewPagerModelArrayList.add(new RestaurantSliderModel("2", R.drawable.nachos,
                "https://images.unsplash.com/photo-1563379926898-05f4575a45d8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"));
        viewPagerModelArrayList.add(new RestaurantSliderModel("3", R.drawable.fries,
                "https://images.unsplash.com/photo-1493770348161-369560ae357d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"));
        viewPagerModelArrayList.add(new RestaurantSliderModel("4", R.drawable.donut,
                "https://images.unsplash.com/photo-1559847844-5315695dadae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=740&q=80"));

        final ViewPagerMainAdapter viewPagerMainAdapter = new ViewPagerMainAdapter(RestaurantActivity.this, viewPagerModelArrayList);
        slider_pager_id.setAdapter(viewPagerMainAdapter);

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

        tabLayout.addTab(tabLayout.newTab().setText("Promo"));
        tabLayout.addTab(tabLayout.newTab().setText("Burgers"));
        tabLayout.addTab(tabLayout.newTab().setText("Meals"));
        tabLayout.addTab(tabLayout.newTab().setText("Chicken"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        HomeTabLayoutAdapter categoryTabLayoutAdapter = new HomeTabLayoutAdapter(RestaurantActivity.this, getSupportFragmentManager(), tabLayout.getTabCount(), "RESTAURANT");
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
