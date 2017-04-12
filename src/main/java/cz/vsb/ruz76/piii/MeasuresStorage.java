package cz.vsb.ruz76.piii;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ruz76 on 29.3.2017.
 * Singleton pro pristup ke klekci mereni.
 */
public class MeasuresStorage extends ArrayList {
    private static MeasuresStorage ourInstance = new MeasuresStorage();

    public static MeasuresStorage getInstance() {
        return ourInstance;
    }

    private MeasuresStorage() {
    }

    private double getValue(Measure m, int type) {
        switch (type) {
            case 0:
                return m.getTemperature();
            case 1:
                return m.getPressure();
            case 2:
                return m.getDust();
            default:
                return m.getTemperature();
        }
    }
    /**
     * Vrátí průměrnou teplotu z načtených měření
     *
     * @return průměrnou teplotu
     */

    public double getIDW(Point p, int type) {
        double numerator = 0; //suma nahore
        double denominator = 0; //suma dole
        for (int i=0; i<this.size(); i++) {
            Measure measure = (Measure) ourInstance.get(i);
            double distance = measure.getDistance(p);
            double value = getValue(measure, type);
            double weight = 1 / Math.pow(distance, 2);
            double weightedtemperature = weight * value;
            numerator += weightedtemperature;
            denominator += weight;
        }
        System.out.println("Numerator: " + numerator);
        System.out.println("Denominator: " + denominator);
        return numerator / denominator;
    }

    /**
     * Načte měření ze souboru CSV ve struktuře lon;lat;dust;temperature;pressure
     *
     * @param csvFile soubor s měřeními ve struktuře lon;lat;dust;temperature;pressure
     */

    public void readMeasures(String csvFile) {
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] fields = line.split(cvsSplitBy);
                double x = Double.parseDouble(fields[0]);
                double y = Double.parseDouble(fields[1]);
                Point p = new Point(x, y);
                //System.out.println(p);

                double dust = Double.parseDouble(fields[2]);
                double temperature = Double.parseDouble(fields[3]);
                double pressure = Double.parseDouble(fields[4]);
                Measure measure = new Measure(x, y, dust, temperature, pressure);

                ourInstance.add(measure);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Vygeneruje n náhodných měření v Extentu 12 49 19 51
     *
     * @param count počet bodů
     * @param csvFile soubor s měřeními ve struktuře lon;lat;dust;temperature;pressure
     */

    public void generateMeasures(int count, String csvFile) {
        Random r = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (int i = 0; i < count; i++) {
                double r1 = r.nextDouble();
                double r2 = r.nextDouble();
                double r3 = r.nextDouble();
                double x = 12 + (r1 * 7);
                double y = 49 + (r2 * 2);
                Point p = new Point(x, y);
                Point random_p = new Point(new Extent("Czech Republic"));
                Measure m = new Measure(x, y);
                double dust = 20 + (r3 * 500);
                double temperature = 0 + (r3 * 10);
                double pressure = 910 + (r3 * 50);
                bw.write(x + ";" + y + ";" + dust + ";" + temperature + ";" + pressure + System.lineSeparator());
                //bw.write(x + ";" + y + ";" + dust + ";" + temperature + ";" + pressure + "\N");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
