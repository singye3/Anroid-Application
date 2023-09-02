package com.example.menu;

import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.IOException;
import java.util.List;

public class Map {
    MainActivity main;

    Map(MainActivity main){
        this.main = main;
    }
    public void showAddressInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(main);
        builder.setTitle("Enter Address");

        final EditText input = new EditText(main);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String address = input.getText().toString();
                if (!address.isEmpty()) {
                    retrieveLocation(address);
                } else {
                    showToast("Enter an address");
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    private void retrieveLocation(String address) {
        Geocoder geocoder = new Geocoder(main);
        try {
            List<Address> addresses = geocoder.getFromLocationName(address, 1);
            if (!addresses.isEmpty()) {
                double latitude = addresses.get(0).getLatitude();
                double longitude = addresses.get(0).getLongitude();

                showCoordinatesDialog(latitude, longitude);


                // Open Google Maps in the same activity
//                    Uri locationUri = Uri.parse("geo:" + latitude + "," + longitude);
//                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
//                    mapIntent.setPackage("com.google.android.apps.maps");
//                    startActivity(mapIntent);
            } else {
                showToast("Location not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showCoordinatesDialog(double latitude, double longitude) {
        AlertDialog.Builder builder = new AlertDialog.Builder(main);
        builder.setTitle("Coordinates");

        String coordinates = "Latitude: " + latitude + "\nLongitude: " + longitude;
        builder.setMessage(coordinates);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private void showToast(String message) {
        Toast.makeText(main, message, Toast.LENGTH_SHORT).show();
    }
}
