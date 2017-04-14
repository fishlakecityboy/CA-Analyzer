package Datensammler.Sensoren;

import android.hardware.Sensor;

/**
 * Created by Säftchen on 14.04.2017.
 */

public class Sensordaten extends Daten{
    private Sensor sensor;

    public Sensor getSensor() { return this.sensor; }

    /**
     *
     * @param name Der Name des Sensors (z.B. Accelerometer)
     * @param einheit Die Einheit der Werte (z.B. Lux beim Lichtsensor)
     * @param bezeichnung Die Bezeichnung vom Wert (z.B. X oder Y oder Z)
     * @param anzahlWerte Die Anzahl der Werte, die der Sensor liefert (z.B. Licht gibt 1, Accelerometer gibt 3)
     * @param sensor Der Sensor
     */
    public Sensordaten(String name, String[] einheit, String[] bezeichnung, int anzahlWerte, Sensor sensor)
    {
        super(name, einheit, bezeichnung, anzahlWerte);
        this.sensor = sensor;
    }
}
