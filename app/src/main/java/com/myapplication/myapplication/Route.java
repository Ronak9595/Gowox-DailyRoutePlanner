package com.myapplication.myapplication;

import java.io.Serializable;

public class Route implements Serializable {
    private final String name;
    private final String details;

    public Route(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }
}
