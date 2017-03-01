package cz.vsb.ruz76.piii;

import java.util.Random;

/**
 * Created by ruz76 on 1.3.2017.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double minx, double miny, double maxx, double maxy) {
        Random r = new Random();
        //TODO random in defined extent
        double r1 = r.nextDouble();
        double r2 = r.nextDouble();
        x = minx + (r1 * (maxx - minx));
        y = miny + (r1 * (maxy - miny));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        //TODO test x
        /*if (x < 12 || x > 19) {
            return false;
        } else {
            this.x = x;
            return true;
        }*/
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
