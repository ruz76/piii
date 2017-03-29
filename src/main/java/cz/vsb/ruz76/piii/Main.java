package cz.vsb.ruz76.piii;

public class Main {

    /**
     * Spouštěcí metoda pro tesotávní třídy IDW.
     * @param args
     */
    public static void main(String[] args) {
	    // write your code here
        //System.out.println(args[0]);
        /*Point p = new Point(-10, 20);
        Point p2 = new Point(10, 20);
        System.out.println(p2.getDistance(p));

        Point p3 = new Point(0, 0);
        Point p4 = new Point(10, 10);
        System.out.println(p3.getDistance(p4));
        */

        /*
        System.out.println(p);
        System.out.println(p.toString("WKT"));
        System.out.println(p.toString("Simple"));
        System.out.println(p.toString("super"));
        System.out.println(p.toString("nevim"));
        //
        */

        IDW idw = new IDW();
        idw.readMeasures();
        //System.out.println(idw.getAverageTemperature());
        System.out.println(MeasuresStorage.getInstance().getAverageTemperature());
        //cisla.datum();
        //cisla.suma(Integer.parseInt(args[0]));
        //cisla.printRandom();
        //cisla.generatePoints(Integer.parseInt(args[0]));
        //cisla.generateGrid(0.5);
        //cisla.generateMeasures(50);
    }
}
