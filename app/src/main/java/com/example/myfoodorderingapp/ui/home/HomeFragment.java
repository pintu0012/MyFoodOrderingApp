package com.example.myfoodorderingapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myfoodorderingapp.Adapter.HomeRecyclerAdapter;
import com.example.myfoodorderingapp.Adapter.HomeTabLayoutAdapter;
import com.example.myfoodorderingapp.Model.HomeRecyclerModel;
import com.example.myfoodorderingapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView textView;
    private RecyclerView home_recycler;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        initialiseViews(root);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        INITIALISE_RECYCLERVIEW();
        SETUP_TABLAYOUT();
        return root;
    }

    private void SETUP_TABLAYOUT() {

        tabLayout.addTab(tabLayout.newTab().setText("Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Speed"));
        tabLayout.addTab(tabLayout.newTab().setText("Favourite"));
        tabLayout.addTab(tabLayout.newTab().setText("Rating"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        HomeTabLayoutAdapter categoryTabLayoutAdapter = new HomeTabLayoutAdapter(getActivity(), getChildFragmentManager(), tabLayout.getTabCount());
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

    private void INITIALISE_RECYCLERVIEW() {

        ArrayList<HomeRecyclerModel> homeRecyclerModelArrayList = new ArrayList<>();
        homeRecyclerModelArrayList.add(new HomeRecyclerModel("0", "Delivery", R.drawable.scooter_icon,"12"));
        homeRecyclerModelArrayList.add(new HomeRecyclerModel("1", "Pick Up", R.drawable.bag_icon,"5"));
        homeRecyclerModelArrayList.add(new HomeRecyclerModel("2", "Dine In", R.drawable.fork_icon,"9"));
        homeRecyclerModelArrayList.add(new HomeRecyclerModel("3", "Booking", R.drawable.star_icon,"15"));

        LinearLayoutManager linearManagerV = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        home_recycler.setLayoutManager(linearManagerV);
        HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(getActivity(),homeRecyclerModelArrayList);
        home_recycler.setAdapter(homeRecyclerAdapter);

    }

    private void initialiseViews(View root) {
        tabLayout= root.findViewById(R.id.tabLayout);
        viewPager= root.findViewById(R.id.pager);
        textView = root.findViewById(R.id.text_home);
        home_recycler = root.findViewById(R.id.home_recycler);
    }
}