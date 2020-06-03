package com.yxjme.flycoroundview;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.flyco.roundview.RoundFrameLayout;
import com.flyco.roundview.RoundViewDelegate;

public class MainActivity extends AppCompatActivity {


    RoundFrameLayout roundFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundFrameLayout=findViewById(R.id.mRoundFrameLayout);
        RoundViewDelegate delegate = roundFrameLayout.getDelegate();
        delegate.setBackgroundColor(Color.RED);
        delegate.setBackgroundPressColor(Color.BLUE);
        delegate.setCornerRadius(20);

        roundFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
