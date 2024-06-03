package com.myapplication.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {

    private ArrayList<Route> routeList;
    private RouteAdapter routeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        routeList = new ArrayList<>();
        routeAdapter = new RouteAdapter(this, routeList);
        ListView listViewRoutes = findViewById(R.id.listViewRoutes);
        listViewRoutes.setAdapter(routeAdapter);

        Button addRouteButton = findViewById(R.id.addRouteButton);
        addRouteButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddRouteActivity.class);
            startActivityForResult(intent, 1);
        });

        listViewRoutes.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, RouteDetailActivity.class);
            intent.putExtra("route", routeList.get(position));
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Route newRoute = (Route) data.getSerializableExtra("route");
            routeList.add(newRoute);
            routeAdapter.notifyDataSetChanged();
        }
    }
}
