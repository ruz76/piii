package cz.vsb.ruz76.piii;

import java.util.Date;
import java.util.Random;

/**
 * Created by ruz76 on 15.2.2017.
 */
public class Cisla {
    public void datum(){
        Date d = new Date();
        System.out.println("Dnes je: " + d);
    }
    public void suma(int max){
        int suma = 0;
        for (int i=0; i < max; i++) {
            suma = suma + i + 1;
        }
        System.out.println(suma);
    }
    public void printRandom(){
        Random r = new Random();
        double cislo = r.nextDouble();
        System.out.println(cislo);
        if (cislo > 0.5) {
            System.out.println("Big");
        } else {
            System.out.println("Small");
        }
    }
    public void generatePoints(int count) {
        Random r = new Random();
        for (int i=0; i < count; i++) {
            double r1 = r.nextDouble();
            double r2 = r.nextDouble();
            double x = 12 + (r1 * 7);
            double y = 49 + (r2 * 2);
            System.out.println("POINT(" + x + " " + y + ")");
        }
    }
}
