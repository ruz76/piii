package cz.vsb.ruz76.piii;

/**
 * Created by ruz76 on 1.3.2017.
 */
public class Measure extends Point{
    private double dust;
    private double temperature;
    private double pressure;

    public Measure(double x, double y) {
        super(x, y);
    }

    public Measure(double x, double y, double dust, double temperature, double pressure) {
        super(x, y);
        this.dust = dust;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public double getDust() {
        return dust;
    }

    public void setDust(double dust) {
        this.dust = dust;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}

/*
public class Measure {
    private double dust;
    private double temperature;
    private double pressure;
    private Point point;
    private Polygon polygon;
}
*/
