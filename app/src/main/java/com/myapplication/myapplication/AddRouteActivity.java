package com.myapplication.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddRouteActivity extends AppCompatActivity {

    private EditText routeNameEditText;
    private EditText routeDetailsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);

        routeNameEditText = findViewById(R.id.routeNameEditText);
        routeDetailsEditText = findViewById(R.id.routeDetailsEditText);

        Button saveRouteButton = findViewById(R.id.saveRouteButton);
        saveRouteButton.setOnClickListener(v -> {
            String name = routeNameEditText.getText().toString();
            String details = routeDetailsEditText.getText().toString();

            Route newRoute = new Route(name, details);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("route", newRoute);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
