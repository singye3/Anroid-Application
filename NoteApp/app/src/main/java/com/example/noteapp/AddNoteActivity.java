package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteTitleEditText;
    private EditText noteContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitleEditText = findViewById(R.id.titleinput);
        noteContentEditText = findViewById(R.id.descriptioninput);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("noteToEdit")) {
            TextView title = findViewById(R.id.titletextview);
            title.setText("Edit the Note");
            Note noteToEdit = intent.getParcelableExtra("noteToEdit");

            noteTitleEditText.setText(noteToEdit.getTitle());
            noteContentEditText.setText(noteToEdit.getDescription());
        }

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

        int position = getIntent().getIntExtra("position", -1);

        if (position != -1) {
            // If position is valid, update the existing note in the ArrayList
            Note noteToEdit = getIntent().getParcelableExtra("noteToEdit");
            noteToEdit.setTitle(title);
            noteToEdit.setDescription(content);

            // Update the notes ArrayList and send it back to MainActivity
            ArrayList<Note> notes = getIntent().getParcelableArrayListExtra("notes");
            notes.set(position, noteToEdit);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("editedNotePosition", position);
            resultIntent.putParcelableArrayListExtra("updatedNotes", notes);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        } else {
            Note newNote = new Note(title, content);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("newNote", newNote);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
    }


}
