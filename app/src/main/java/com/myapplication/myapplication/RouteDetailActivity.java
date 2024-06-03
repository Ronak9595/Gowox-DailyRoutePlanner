package com.myapplication.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RouteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);

        Route route = (Route) getIntent().getSerializableExtra("route");

        TextView routeNameTextView = findViewById(R.id.routeNameTextView);
        TextView routeDetailsTextView = findViewById(R.id.routeDetailsTextView);

        assert route != null;
        routeNameTextView.setText(route.getName());
        routeDetailsTextView.setText(route.getDetails());
    }
}
