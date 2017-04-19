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
    }
}
