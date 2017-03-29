package cz.vsb.ruz76.piii;

import java.util.ArrayList;

/**
 * Created by ruz76 on 29.3.2017.
 * Singleton pro pristup ke klekci mereni.
 */
public class MeasuresStorage extends ArrayList {
    //TODO
    private static MeasuresStorage ourInstance = new MeasuresStorage();

    public static MeasuresStorage getInstance() {
        return ourInstance;
    }

    private MeasuresStorage() {
    }

    public double getAverageTemperature() {
        double sum = 0;
        for (int i=0; i<this.size(); i++) {
            Measure measure = (Measure) ourInstance.get(i);
            double temperature = measure.getTemperature();
            sum += temperature;

        }
        return sum / ourInstance.size();
    }

}
