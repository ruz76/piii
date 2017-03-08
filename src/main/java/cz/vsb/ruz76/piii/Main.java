package cz.vsb.ruz76.piii;

public class Main {

    /**
     * Spouštěcí metoda pro tesotávní třídy Cisla.
     * @param args
     */
    public static void main(String[] args) {
	    // write your code here
        //System.out.println(args[0]);
        Point p = new Point(10, 15);
        Point p2 = new Point(10, 20);
        System.out.println(p2.getDistance(p));
        /*
        System.out.println(p);
        System.out.println(p.toString("WKT"));
        System.out.println(p.toString("Simple"));
        System.out.println(p.toString("super"));
        System.out.println(p.toString("nevim"));
        */

        Cisla cisla = new Cisla();
        //cisla.datum();
        //cisla.suma(Integer.parseInt(args[0]));
        //cisla.printRandom();
        //cisla.generatePoints(Integer.parseInt(args[0]));
        //cisla.generateGrid(0.5);
        //cisla.generateMeasures(50);
    }
}
