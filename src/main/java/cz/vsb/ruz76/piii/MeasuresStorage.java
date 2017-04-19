package cz.vsb.ruz76.piii;

import java.io.*;
import java.sql.*;
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

    /*
    * Prints IDW value in grid
    * */

    public void saveIDWGridToDB(double x, double y, double delta, double rows, double cols)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://geoserver2.vsb.cz:3306/test","test", "gis");
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE IF NOT EXISTS ruz76grid (x float, y float, temperature float)");
            s.execute("DELETE FROM ruz76grid");
            for (int i = 0; i< rows; i++) {
                for (int j = 0; j< cols; j++) {
                    double curx = x + (j * delta);
                    double cury = y + (i * delta);
                    double idw = getIDW(new Point(curx, cury), 0);
                    s.execute("INSERT INTO ruz76grid (x, y, temperature) VALUES (" + curx + ", " + cury + ", " + idw + ")");
                }
            }
            /*
            Ověření, že byl grid zapsán.
            ResultSet rs = s.executeQuery("SELECT * FROM ruz76grid");
            while (rs.next()) {
                System.out.println(rs.getFloat("x"));
                System.out.println(rs.getFloat("y"));
                System.out.println(rs.getFloat("temperature"));
            }
            */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
    * Prints IDW value in grid
    * */

    public void getIDWGrid(double x, double y, double delta, double rows, double cols)
    {
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< cols; j++) {
                double idw = getIDW(new Point(x + (j * delta), y + (i * delta)), 0);
                System.out.println(idw);
            }
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
        //System.out.println("Numerator: " + numerator);
        //System.out.println("Denominator: " + denominator);
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

    /**
     * Přečte měření z SQL databáze pomocí JDBC
     */

    public void readMeasuresFromDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://geoserver2.vsb.cz:3306/test","test", "gis");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM measures");
            while (rs.next()) {
                double x = (double) rs.getFloat("x");
                double y = (double) rs.getFloat("y");
                double dust = (double) rs.getFloat("dust");
                double temperature = (double) rs.getFloat("temperature");
                double pressure = (double) rs.getFloat("pressure");
                Measure measure = new Measure(x, y, dust, temperature, pressure);
                ourInstance.add(measure);
                //TODO Sestavení kolekce měření
                /*System.out.println(rs.getFloat("x"));
                System.out.println(rs.getFloat("y"));
                System.out.println(rs.getFloat("dust"));
                */
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
