package com.example.myfoodorderingapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodorderingapp.Model.HomeRecyclerModel;
import com.example.myfoodorderingapp.R;

import java.util.ArrayList;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private ArrayList<HomeRecyclerModel> itemList;
    private Context context;
    private CardView cardView;


    public HomeRecyclerAdapter(Context context, ArrayList<HomeRecyclerModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        applyCategoryCardViewBackgroundColor(position);
        viewHolder.title.setText(itemList.get(position).getTitle());
        viewHolder.imageview.setImageResource(itemList.get(position).getImage());
        viewHolder.options.setText("+"+itemList.get(position).getOptions()+" options");

//        viewHolder.imageview.invalidate();
//        BitmapDrawable drawable = (BitmapDrawable) viewHolder.imageview.getDrawable();
//        Bitmap bitmap = drawable.getBitmap();
//        int color = getDominantColor(bitmap);
//        int darkColor = manipulateColor(color, 0.9f);
//        cardView.setCardBackgroundColor(darkColor);

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cardview_layout, parent, false);
        cardView = v.findViewById(R.id.cardView);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, options;
        private ImageView imageview;
        private Button buy_now_button;

        public ViewHolder(final View itemView) {
            super(itemView);
            options = itemView.findViewById(R.id.options);
            imageview = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title);

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