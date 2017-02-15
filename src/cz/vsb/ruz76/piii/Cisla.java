package cz.vsb.ruz76.piii;

import java.util.Date;

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
}
