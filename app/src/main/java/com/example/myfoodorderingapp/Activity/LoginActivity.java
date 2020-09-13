package com.example.myfoodorderingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myfoodorderingapp.R;

public class LoginActivity extends AppCompatActivity {

    private CardView cardView, cardView1;
    private LinearLayout sign_un_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cardView = findViewById(R.id.cardview);
        cardView1 = findViewById(R.id.cardview1);
        cardView.setBackgroundResource(R.drawable.rounded_corner_stroke_background_edittext);
        cardView1.setBackgroundResource(R.drawable.rounded_corner_stroke_background_edittext);

        sign_un_linear = findViewById(R.id.sign_un_linear);
        sign_un_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this);
                Intent intent =new Intent(LoginActivity.this, SignUpActivity.class) ;
                startActivity(intent, options.toBundle());
            }
        });
    }
}
