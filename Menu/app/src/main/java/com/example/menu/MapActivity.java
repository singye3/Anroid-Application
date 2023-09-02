package com.example.menu;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private EditText addressEditText;
    private TextView coordinatesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//        addressEditText = findViewById(R.id.addressEditText);
//        coordinatesTextView = findViewById(R.id.coordinatesTextView);
//
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_map, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.retrieve_location) {
//            retrieveLocation();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void retrieveLocation() {
//        String address = addressEditText.getText().toString();
//        if (!address.isEmpty()) {
//            Geocoder geocoder = new Geocoder(this);
//            try {
//                List<Address> addresses = geocoder.getFromLocationName(address, 1);
//                if (!addresses.isEmpty()) {
//                    double latitude = addresses.get(0).getLatitude();
//                    double longitude = addresses.get(0).getLongitude();
//
//                    coordinatesTextView.setText("Coordinates \nLatitude: " + latitude + "\nLongitude: " + longitude);
//
//                    // Open Google Maps in the same activity
////                    Uri locationUri = Uri.parse("geo:" + latitude + "," + longitude);
////                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
////                    mapIntent.setPackage("com.google.android.apps.maps");
////                    startActivity(mapIntent);
//                } else {
//                    showToast("Location not found");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            showToast("Enter an address");
//        }
//    }
//
//    private void showToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }
}
