package cz.vsb.ruz76.piii;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println(args[0]);
        Cisla cisla = new Cisla();
        cisla.datum();
        cisla.suma(Integer.parseInt(args[0]));
    }
}
