package cz.vsb.ruz76.piii;

public class Main {

    /**
     * Spouštěcí metoda pro tesotávní třídy Cisla.
     * @param args
     */
    public static void main(String[] args) {
	    // write your code here
        //System.out.println(args[0]);
        Cisla cisla = new Cisla();
        //cisla.datum();
        //cisla.suma(Integer.parseInt(args[0]));
        //cisla.printRandom();
        //cisla.generatePoints(Integer.parseInt(args[0]));
        cisla.generateGrid(0.5);
    }
}
