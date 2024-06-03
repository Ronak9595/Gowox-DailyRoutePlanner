package com.myapplication.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RouteAdapter extends ArrayAdapter<Route> {

    public RouteAdapter(Context context, ArrayList<Route> routes) {
        super(context, 0, routes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Route route = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_route, parent, false);
        }

        TextView routeNameTextView = convertView.findViewById(R.id.routeNameTextView);
        assert route != null;
        routeNameTextView.setText(route.getName());

        return convertView;
    }
}
