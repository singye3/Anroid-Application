package com.example.sharedpreferencenoteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteTitleEditText;
    private EditText noteContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitleEditText = findViewById(R.id.titleinput);
        noteContentEditText = findViewById(R.id.descriptioninput);

        // Load an existing note (if any) when editing
        Note existingNote = Note.load(this);
        noteTitleEditText.setText(existingNote.getTitle());
        noteContentEditText.setText(existingNote.getDescription());

        Button saveNoteButton = findViewById(R.id.savebtn);
        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String title = noteTitleEditText.getText().toString();
        String content = noteContentEditText.getText().toString();

        // Save the note to SharedPreferences
        Note newNote = new Note(title, content);
        newNote.save(this);

        setResult(Activity.RESULT_OK);
        finish();
    }
}
