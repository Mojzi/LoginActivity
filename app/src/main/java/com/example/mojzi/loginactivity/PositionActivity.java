package com.example.mojzi.loginactivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mojzi on 04.07.17.
 * Shows GPS Position
 */

public class PositionActivity extends AppCompatActivity {
    private LocationManager locationManager;

    private Location userLocation;
    private TextView locationTV;
    private LocationListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);
        Button refreshButton = (Button) findViewById(R.id.refreshPositionButton);
        locationTV = (TextView) findViewById(R.id.positoinTextView);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                userLocation = location;
                if(userLocation != null) {
                    locationTV.setText(userLocation.toString());
                } else {
                    locationTV.setText(R.string.text_view_invalid_position);
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        refreshPosition();

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshPosition();
            }
        });
    }


    void refreshPosition() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            String locationProvider = LocationManager.GPS_PROVIDER;
            locationManager.requestLocationUpdates(locationProvider, 0, 0, listener);
            userLocation = locationManager.getLastKnownLocation(locationProvider);
            if(userLocation != null) {
                locationTV.setText(userLocation.toString());
            } else {
                locationTV.setText(R.string.text_view_invalid_position);
            }
            locationManager.removeUpdates(listener);
        }
    }


}
