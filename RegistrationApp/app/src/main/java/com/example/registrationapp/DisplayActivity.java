package com.example.registrationapp;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String programme = extras.getString("programme");
            String year = extras.getString("year");
            String module = extras.getString("module");
            String name = extras.getString("name");
            String stdID = extras.getString("stdID");
            String semester = extras.getString("semester");

            TextView enteredNameTextView = findViewById(R.id.displayName);
            TextView enteredStudentNumberTextView = findViewById(R.id.displayStdID);
            TextView selectedCourseTextView = findViewById(R.id.displayProg);
            TextView selectedYearTextView = findViewById(R.id.displayYear);
            TextView selectedModTextView = findViewById(R.id.displayMod);
            TextView selectedSemTextView = findViewById(R.id.displaySem);


            enteredNameTextView.setText("Entered Name: " + name);
            enteredStudentNumberTextView.setText("Entered Student Number: " + stdID);
            selectedCourseTextView.setText("Selected Course: " + programme);
            selectedYearTextView.setText("Selected Year: " + year);
            selectedModTextView.setText("Selected Modules: " + module);
            selectedSemTextView.setText("Selected Semester: " + semester);


        }
    }

}