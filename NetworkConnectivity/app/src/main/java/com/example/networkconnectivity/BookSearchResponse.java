package com.example.networkconnectivity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookSearchResponse {

    @SerializedName("items")
    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }
}
