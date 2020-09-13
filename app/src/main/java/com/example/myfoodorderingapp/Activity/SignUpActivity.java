package com.example.myfoodorderingapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfoodorderingapp.R;

public class SignUpActivity extends AppCompatActivity {

    private ImageButton back_button;
    private LinearLayout login_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initialiseViews();

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });


        login_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void initialiseViews() {
        back_button = findViewById(R.id.back_button);
        login_linear = findViewById(R.id.login_linear);
    }
}
