package Datensammler;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.Set;

import Datensammler.Listener.SensorListener;
import Datensammler.Sensoren.Daten;
import Datensammler.Sensoren.Sensordaten;

/**
 * Created by Säftchen on 14.04.2017.
 * Diese Klasse ist ein Singleton.
 * Diese Klasse ermöglicht das permanente Zugreifen auf festgelegte Sensoren,
 * ohne das Anlegen von Objekten oder das ständige Objektübergeben.
 */

public class Settings {
    private static Settings instance;
    public static Settings getInstance()
    {
        if (instance == null)
            instance = new Settings();

        return instance;
    }

    /**
     * Die Werte der Sensoren:
     * 01 Lichtsensor
     * 02 Schrittzähler
     * 03 Gyroscope
     * 04 Barometer
     * 05 Nährungssensor
     * 06 Magnetisches Feld
     * 07 Accelerometer
     * 08 Beschleunigung
     * 09 Lineare Beschleunigung
     * 10 Gravity
     * 11 Luftfeuchtigkeit
     */
    private Daten[] arrDaten;
    private int anzahlSensoren;
    private SensorListener sensorListener;
    private SensorManager sensorManager;

    /**
     * Diese Methode setzt alle genutzten Manager (derzeit nur den Sensormanager)
     * Initialisiert im Anschluss alle Sensoren
     * @param sensorManager
     */
    public void setManager(SensorManager sensorManager)
    {
        this.sensorManager = sensorManager;
        initSensoren();
    }
    public void setSensorListener(SensorListener sensorListener) { this.sensorListener = sensorListener; }


    /**
     * @return Anzahl der genutzten Sensoren
     */
    public int getAnzahlSensoren() { return this.anzahlSensoren; }
    /**
     * @return Alle Daten
     */
    public Daten[] getArrDaten() { return this.arrDaten; }
    public SensorListener getSensorListener() { return sensorListener; }
    public SensorManager getSensorManager() { return this.sensorManager; }


    /**
     * @param index Die Stelle, die im Array für die Daten ausgelesen werden soll
     * @return Die Daten zum Sensor an Stelle des Index
     */
    public Daten getArrDatenAt(int index) { return this.arrDaten[index]; }

    /**
     * Der Konstruktor
     */
    public Settings()
    {
        this.anzahlSensoren = 11;
    }

    /**
     * Füllen des Daten-Arrays mit Sensoren + Sensorinformationen
     */
    public void initSensoren()
    {
        arrDaten = new Daten[this.anzahlSensoren];

        arrDaten[0] = new Sensordaten("Lichtsensor",             new String[]{ "Lux" },      new String[]{ "Lichteinfall" },  1, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT));
        arrDaten[1] = new Sensordaten("Schrittzähler",           new String[]{ "Schritte" }, new String[]{ "Schrittzähler" }, 1, sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER));
        arrDaten[2] = new Sensordaten("Gyroscope",               new String[]{},             new String[]{ "X", "Y", "Z" },   3, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE));
        arrDaten[3] = new Sensordaten("Barometer",               new String[]{ "hPa" },      new String[]{ "Druck" },         1, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE));
        arrDaten[4] = new Sensordaten("Näherungssensor",         new String[]{ "cm" },       new String[]{ "Annäherung" },    1, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY));
        arrDaten[5] = new Sensordaten("Magnetisches Feld",       new String[]{ "µT" },       new String[]{ "X", "Y", "Z" },   3, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD));
        arrDaten[6] = new Sensordaten("Beschleunigung",          new String[]{ "m/s²"},      new String[]{ "X", "Y", "Z" },   3, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        arrDaten[7] = new Sensordaten("Lineare Beschleunigung",  new String[]{ "m/s²"},      new String[]{ "X", "Y", "Z" },   3, sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION));
        arrDaten[8] = new Sensordaten("Gravitation",             new String[]{ "m/s²"},      new String[]{ "X", "Y", "Z" },   3, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY));
        arrDaten[9] = new Sensordaten("Temperatur",              new String[]{ "°C" },       new String[]{ "Temperatur" },    1, sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE));
        arrDaten[10] = new Sensordaten("Luftfeuchtigkeit",       new String[]{ "%" },        new String[]{ "Feuchtigkeit" },  1, sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY));
    }
}
