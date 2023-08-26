package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner programme = findViewById(R.id.programme);

        String[] progList = {"Select Course", "ICE", "Electrical", "ECE", " IT"};
        ArrayAdapter<String> progAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, progList);
        programme.setAdapter(progAdapter);

        Spinner year = findViewById(R.id.year);

        String[] yearList = {"Select Year", "First", "Second", "Third", " Fourth"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, yearList);
        year.setAdapter(yearAdapter);

        Spinner module = findViewById(R.id.module);

        String[] modList = {"Select modules:", "DIS", "Math", "DZO", "ECD"};
        ArrayAdapter<String> modAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modList);
        module.setAdapter(modAdapter);

        Spinner semester = findViewById(R.id.semester);

        String[] semList = {"Select Sem:", "I", "II", "III", "IV"};
        ArrayAdapter<String> semAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, semList);
        semester.setAdapter(semAdapter);


        EditText name = findViewById(R.id.name);
        EditText stdID = findViewById(R.id.stdID);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            String enteredName = name.getText().toString();
            String enteredStudentNumber = stdID.getText().toString();

            String selectedProg = programme.getSelectedItem().toString();
            String selectedYear = year.getSelectedItem().toString();
            String selectedMod = module.getSelectedItem().toString();
            String selectedSem = semester.getSelectedItem().toString();



            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            intent.putExtra("name", enteredName);
            intent.putExtra("stdID", enteredStudentNumber);
            intent.putExtra("programme", selectedProg);
            intent.putExtra("year", selectedYear);
            intent.putExtra("module", selectedMod);
            intent.putExtra("semester", selectedSem);

            startActivity(intent);
        });





    }
}