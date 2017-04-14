package Datensammler.Sensoren;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Säftchen on 14.04.2017.
 */

public class Daten {
    private double[] lastValues;
    private List<double[]> oldValues;
    private String name;
    private String[] einheit;
    private String[] bezeichnung;

    public void setLastValues(double[] lastValues)
    {
        this.oldValues.add(this.lastValues.clone());
        this.lastValues = lastValues;
    }
    public void setName(String name) { this.name = name; }
    //public void setEinheit(String[] einheit) { this.einheit = einheit; }
    //public void setBezeichnung(String[] bezeichnung) { this.bezeichnung = bezeichnung; }

    public String getName() { return this.name; }

    /**
     * Gibt die Ausgabe für den Spezifischen Sensor zurück
     * @return Gibt alle Werte mit der Bezeichnung und ggf. der passenden Einheit zurück.
     */
    public String toString()
    {
        String strReturn = "";
        for (int i = 0; i < lastValues.length; i++)
        {

            if (bezeichnung.length > 1)
                strReturn += bezeichnung[i] + ": ";

            else
                strReturn += bezeichnung[0] + ": ";

            strReturn += lastValues[i];
            if (lastValues.length == einheit.length)
                 strReturn += " " + einheit[i];
            else if (einheit.length == 1)
                strReturn += " " + einheit[0];


            strReturn += "\n";
        }

        return strReturn;
    }

    public Daten()
    {
        this.lastValues = new double[0];
        this.oldValues = new ArrayList<double[]>();
        this.name = "";
        this.einheit = new String[0];
        this.bezeichnung = new String[0];
    }

    /**
     *
     * @param name Der Name des Sensors (z.B. GPS)
     * @param einheit Die Einheit der Werte (z.B. Lux beim Lichtsensor)
     * @param bezeichnung Die Bezeichnung vom Wert (z.B. X oder Y oder Z)
     * @param anzahlWerte Die Anzahl der Werte, die der Sensor liefert (z.B. Licht gibt 1, Accelerometer gibt 3)
     */
    public Daten(String name, String[] einheit, String[] bezeichnung, int anzahlWerte)
    {
        this.name = name;
        this.einheit = einheit;
        this.bezeichnung = bezeichnung;
        this.lastValues = new double[anzahlWerte];
        this.oldValues = new ArrayList<double[]>();
    }
}
