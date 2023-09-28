package com.example.sharedpreferencenoteapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Note {
    private static final String PREFS_NAME = "MyNotes";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private String title;
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Save the note to SharedPreferences
    public void save(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TITLE, title);
        editor.putString(KEY_DESCRIPTION, description);
        editor.apply();
    }

    // Load a note from SharedPreferences
    public static Note load(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String title = sharedPreferences.getString(KEY_TITLE, "");
        String description = sharedPreferences.getString(KEY_DESCRIPTION, "");
        return new Note(title, description);
    }
}
