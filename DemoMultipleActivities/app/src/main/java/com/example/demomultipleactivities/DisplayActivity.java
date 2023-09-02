package com.example.demomultipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView txt = findViewById(R.id.textView);
        Intent it = getIntent();
        String msg = it.getStringExtra("message");
        txt.setText(msg);

        txt.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Drawable leftDrawable = txt.getCompoundDrawablesRelative()[0];

                if (leftDrawable != null) {
                    Rect bounds = leftDrawable.getBounds();

                    int drawableWidth = bounds.width();
                    int drawableHeight = bounds.height();
                    int touchX = (int) event.getX();
                    int touchY = (int) event.getY();

                    if (touchX >= bounds.left && touchX <= bounds.right &&
                            touchY >= bounds.top && touchY <= bounds.bottom) {
                    }
                }
            }
            return true;
        });

    }
}