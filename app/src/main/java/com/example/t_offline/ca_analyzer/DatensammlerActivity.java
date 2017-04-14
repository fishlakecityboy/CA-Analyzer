package com.example.t_offline.ca_analyzer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Datensammler.Listener.SensorListener;
import Datensammler.Sensoren.Sensordaten;
import Datensammler.Settings;

public class DatensammlerActivity extends AppCompatActivity {

    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(DatensammlerActivity.this, Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 2);
            }
            if (ContextCompat.checkSelfPermission(DatensammlerActivity.this, Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.CHANGE_WIFI_STATE}, 2);
            }
            if (ContextCompat.checkSelfPermission(DatensammlerActivity.this, Manifest.permission.CHANGE_WIFI_MULTICAST_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.CHANGE_WIFI_MULTICAST_STATE}, 2);
            }
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, 1);
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.CHANGE_WIFI_STATE}, 1);
            ActivityCompat.requestPermissions(DatensammlerActivity.this, new String[]{Manifest.permission.CHANGE_WIFI_MULTICAST_STATE}, 1);
        } // asking for permissions

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datensammler);

        Settings.getInstance().setManager((SensorManager) getSystemService(SENSOR_SERVICE));
        Settings.getInstance().setSensorListener(new SensorListener(this));

        adapter = new ArrayAdapter<CharSequence>(this, R.layout.support_simple_spinner_dropdown_item);
        setAdapterItems();
    }

    private void setAdapterItems() {
        SensorManager sensorManager = Settings.getInstance().getSensorManager();

        for (int i = 0; i < Settings.getInstance().getArrDaten().length; i++) {
            if (((Sensordaten) Settings.getInstance().getArrDatenAt(i)).getSensor() != null) {
                sensorManager.registerListener(
                        Settings.getInstance().getSensorListener(),
                        ((Sensordaten) Settings.getInstance().getArrDatenAt(i)).getSensor(),
                        sensorManager.SENSOR_DELAY_NORMAL

                );

                adapter.add(Settings.getInstance().getArrDatenAt(i).getName());

            } // else if ende
        } // for ende
        ((Spinner)findViewById(R.id.cmbSensoren)).setAdapter(this.adapter);
    }
}
