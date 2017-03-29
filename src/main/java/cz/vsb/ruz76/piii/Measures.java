package cz.vsb.ruz76.piii;

import java.util.ArrayList;

/**
 * Created by ruz76 on 29.3.2017.
 */
public class Measures extends ArrayList {
    public double getAverageTemperature() {
        double sum = 0;
        //TODO
        for (int i=0; i<this.size(); i++) {
            Measure measure = (Measure) this.get(i);
            double temperature = measure.getTemperature();
            sum += temperature;

        }
        return sum / this.size();
    }
}
