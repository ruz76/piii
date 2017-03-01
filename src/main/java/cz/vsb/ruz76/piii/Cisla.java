package cz.vsb.ruz76.piii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by ruz76 on 15.2.2017.
 */
public class Cisla {
    private static final String FILENAME = "measures.csv";

    /**
     * Vypíše dnešní datum
     */
    public void datum() {
        Date d = new Date();
        System.out.println("Dnes je: " + d);
    }

    /**
     * Vypíše součet číselné řady od 1 do maximální zadané hodnoty s krokem 1
     *
     * @param max maximální číslo
     */
    public void suma(int max) {
        int suma = 0;
        for (int i = 0; i < max; i++) {
            suma = suma + i + 1;
        }
        System.out.println(suma);
    }

    /**
     * Vygeneruje náhodné číslo. Číslo vypíše.
     * V případě, že je větší než 0.5 vypíše slovo Big.
     * V případě, že je menší než nebo rovno 0.5 vypíše slovo Small.
     */
    public void printRandom() {
        Random r = new Random();
        double cislo = r.nextDouble();
        System.out.println(cislo);
        if (cislo > 0.5) {
            System.out.println("Big");
        } else {
            System.out.println("Small");
        }
    }

    /**
     * Vygeneruje n náhodných bodů v Extentu 12 49 19 51
     *
     * @param count počet bodů
     */
    public void generatePoints(int count) {
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            double r1 = r.nextDouble();
            double r2 = r.nextDouble();
            double x = 12 + (r1 * 7);
            double y = 49 + (r2 * 2);
            System.out.println("POINT(" + x + " " + y + ")");
        }
    }

    /**
     * Vygeneruje n náhodných bodů v Extentu 12 49 19 51
     *
     * @param count počet bodů
     */

    public void generateMeasures(int count) {
        Random r = new Random();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            //bw.write("test");
            for (int i = 0; i < count; i++) {
                double r1 = r.nextDouble();
                double r2 = r.nextDouble();
                double r3 = r.nextDouble();
                double x = 12 + (r1 * 7);
                double y = 49 + (r2 * 2);
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
     * Vygeneruje grid v podobě bodů a polygonů v Extentu 12 48 19 51.
     *
     * @param size velikost buňky gridu
     */

    public void generateGrid(double size) {
        /*Metoda má vygenerovat grid v podobě bodů a polygonů*/
        /*Metoda generuje body do linie, nikoli do gridu a v případě polygonů místo obdélníků vytváří trojúhelníky*/
        /*Oprav dvě logické chyby*/
        for (int i = 0; i < (int) (6 / size); i++) {
            for (int j = 0; j < (int) (3 / size); j++) {
                double x = 12 + i * size;
                double y = 48 + j * size;
                //double y = 48 + i * size;
                System.out.println("POINT(" + x + " " + y + ")");
                System.out.println(getGridRectangle(x, y, size));
                //System.out.println("POLYGON((" + x + " " + y + ", " + x2 + " " + y + ", " + x + " " + y2 + ", " + x + " " + y + "))");
            }
        }
    }

    private String getGridRectangle(double x, double y, double size) {
        double x2 = x + size;
        double y2 = y + size;
        String polygon = "POLYGON((" + x + " " + y + ", " + x2 + " " + y + ", " + x2 + " " + y2 + ", " + x + " " + y2 + ", " + x + " " + y + "))";
        return "POLYGON ...";
    }


}
