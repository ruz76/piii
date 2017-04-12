package cz.vsb.ruz76.piii;

public class Main {

    /**
     * Spouštěcí metoda pro testování třídy MeasuresStorage.
     * @param args
     */
    public static void main(String[] args) {

        MeasuresStorage.getInstance().readMeasures("measures.csv");
        System.out.println(MeasuresStorage.getInstance().getAverageTemperature());
        MainWindow mw = new MainWindow();
        mw.setTitle("IDW");
        mw.setSize(250, 177);
        mw.setVisible(true);
    }
}
