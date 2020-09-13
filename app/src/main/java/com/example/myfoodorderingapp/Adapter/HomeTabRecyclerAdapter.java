package com.example.myfoodorderingapp.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodorderingapp.Activity.RestaurantActivity;
import com.example.myfoodorderingapp.Model.CategoryItemModel;
import com.example.myfoodorderingapp.Model.HomeRecyclerModel;
import com.example.myfoodorderingapp.R;

import java.util.ArrayList;

public class HomeTabRecyclerAdapter extends RecyclerView.Adapter<HomeTabRecyclerAdapter.ViewHolder> {

    private ArrayList<CategoryItemModel> itemList;
    private Context context;
    private CardView cardView;
    private Activity activity;


    public HomeTabRecyclerAdapter(Activity activity,Context context, ArrayList<CategoryItemModel> itemList) {
        this.itemList = itemList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

//        applyCategoryCardViewBackgroundColor(position);
        viewHolder.store_name.setText(itemList.get(position).getTitle());
        viewHolder.imageview.setImageResource(itemList.get(position).getImage());
        viewHolder.distance.setText(String.valueOf(itemList.get(position).getDistance()) + "km");
        viewHolder.time.setText(itemList.get(position).getEstimateTime());
        viewHolder.category.setText(itemList.get(position).getCategory());
        viewHolder.rating.setText(String.valueOf(itemList.get(position).getRating()));
        viewHolder.price.setText("$" + itemList.get(position).getPrice());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity);
                Intent intent = new Intent(context, RestaurantActivity.class);
                intent.putExtra("MODEL", itemList.get(position));
                context.startActivity(intent, options.toBundle());

            }
        });

    }
    public static int getDominantColor(Bitmap bitmap) {
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
        final int color = newBitmap.getPixel(0, 0);
        newBitmap.recycle();
        return color;
    }

    public static int manipulateColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a,
                Math.min(r,255),
                Math.min(g,255),
                Math.min(b,255));
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item, parent, false);
        cardView = v.findViewById(R.id.cardView);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  distance,time,price,category,rating,store_name;
        private ImageView imageview;

        public ViewHolder(final View itemView) {
            super(itemView);
            distance = itemView.findViewById(R.id.distance);
            imageview = itemView.findViewById(R.id.imageview);
            time = itemView.findViewById(R.id.time);
            price = itemView.findViewById(R.id.price);
            category = itemView.findViewById(R.id.category);
            rating = itemView.findViewById(R.id.rating);
            store_name = itemView.findViewById(R.id.store_name);

        }

    }

    // Change the card background color dynamically
    private void applyCategoryCardViewBackgroundColor(int position) {
        int incrementalPosition = position + 1;
        if (incrementalPosition % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#4D3C96"));
        } else if ((incrementalPosition - 2) % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#F1C759"));
        } else if ((incrementalPosition - 3) % 4 == 0) {
            cardView.setCardBackgroundColor(Color.parseColor("#3091F7"));
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#E60023"));
        }
    }

}

