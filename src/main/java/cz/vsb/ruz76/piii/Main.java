package cz.vsb.ruz76.piii;

import javax.swing.*;

public class Main {

    /**
     * Spouštěcí metoda pro testování třídy MeasuresStorage.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        /*UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        MeasuresStorage.getInstance().readMeasures("measures.csv");
        MainWindow mw = new MainWindow();
        mw.setSize(200, 200);
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mw.setVisible(true);
        */
        MeasuresStorage.getInstance().readMeasuresFromDB();
        //MeasuresStorage.getInstance().readMeasures("measures.csv");
        //MeasuresStorage.getInstance().getIDWGrid(13, 49, 0.5, 10, 10);
        MeasuresStorage.getInstance().saveIDWGridToDB(13, 49, 0.5, 10, 10);
    }
}
