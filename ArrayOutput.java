package com.example.Eric_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;


public class ArrayOutput extends AppCompatActivity {
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_output);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("points");
        ArrayList<PointF> pointFS = (ArrayList<PointF>) bundle.getSerializable("points");
        root = findViewById(R.id.root1);

        for (int i = 0; i < pointFS.size(); i++) {
            int j = i+1;
            TextView pointview = new TextView(this);
            pointview.setTextSize(18);
            pointview.setText(j + ". " + pointFS.get(i).toString());
            root.addView(pointview);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
