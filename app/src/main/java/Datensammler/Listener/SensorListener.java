package Datensammler.Listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t_offline.ca_analyzer.R;

import com.example.t_offline.ca_analyzer.DatensammlerActivity;

import org.w3c.dom.Text;

import Datensammler.Settings;

/**
 * Created by Säftchen on 14.04.2017.
 */

public class SensorListener implements SensorEventListener {
    private DatensammlerActivity activity;
    private int[] iTypes =
            {
                    Sensor.TYPE_LIGHT,
                    Sensor.TYPE_STEP_COUNTER,
                    Sensor.TYPE_GYROSCOPE,
                    Sensor.TYPE_PRESSURE,
                    Sensor.TYPE_PROXIMITY,
                    Sensor.TYPE_MAGNETIC_FIELD,
                    Sensor.TYPE_ACCELEROMETER,
                    Sensor.TYPE_LINEAR_ACCELERATION,
                    Sensor.TYPE_GRAVITY,
                    Sensor.TYPE_AMBIENT_TEMPERATURE,
                    Sensor.TYPE_RELATIVE_HUMIDITY
            };

    public SensorListener(DatensammlerActivity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int iAuswahl = -1;

        Spinner cmbSensoren = (Spinner)activity.findViewById(R.id.cmbSensoren);
        TextView tvAusgabe = (TextView)activity.findViewById(R.id.tvAusgabe);
        try {

            if (event.sensor.getType() == iTypes[0]) {
                Settings.getInstance().getArrDatenAt(0).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(0).getName()))
                    iAuswahl = 0;
            }
            if (event.sensor.getType() == iTypes[1]) {
                Settings.getInstance().getArrDatenAt(1).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(1).getName()))
                    iAuswahl = 1;
            }
            if (event.sensor.getType() == iTypes[2]) {
                Settings.getInstance().getArrDatenAt(2).setLastValues(new double[]{event.values[0], event.values[1], event.values[2]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(2).getName()))
                    iAuswahl = 2;
            }
            if (event.sensor.getType() == iTypes[3]) {
                Settings.getInstance().getArrDatenAt(3).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(3).getName()))
                    iAuswahl = 3;
            }
            if (event.sensor.getType() == iTypes[4]) {
                Settings.getInstance().getArrDatenAt(4).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(4).getName()))
                    iAuswahl = 4;
            }
            if (event.sensor.getType() == iTypes[5]) {
                Settings.getInstance().getArrDatenAt(5).setLastValues(new double[]{event.values[0], event.values[1], event.values[2]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(5).getName()))
                    iAuswahl = 5;
            }
            if (event.sensor.getType() == iTypes[6]) {
                Settings.getInstance().getArrDatenAt(6).setLastValues(new double[]{event.values[0], event.values[1], event.values[2]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(6).getName()))
                    iAuswahl = 6;
            }
            if (event.sensor.getType() == iTypes[7]) {
                Settings.getInstance().getArrDatenAt(7).setLastValues(new double[]{event.values[0], event.values[1], event.values[2]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(7).getName()))
                    iAuswahl = 7;
            }
            if (event.sensor.getType() == iTypes[8]) {
                Settings.getInstance().getArrDatenAt(8).setLastValues(new double[]{event.values[0], event.values[1], event.values[2]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(8).getName()))
                    iAuswahl = 8;
            }
            if (event.sensor.getType() == iTypes[9]) {
                Settings.getInstance().getArrDatenAt(9).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(9).getName()))
                    iAuswahl = 9;
            }
            if (event.sensor.getType() == iTypes[10]) {
                Settings.getInstance().getArrDatenAt(10).setLastValues(new double[]{event.values[0]});
                if (cmbSensoren.getSelectedItem().equals(Settings.getInstance().getArrDatenAt(10).getName()))
                    iAuswahl = 10;
            }
            tvAusgabe.setText(Settings.getInstance().getArrDatenAt(iAuswahl).toString());
        }
        catch (Exception ex) { Log.d("Exception", ex.getMessage()); }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
