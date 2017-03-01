package cz.vsb.ruz76.piii;

/**
 * Created by ruz76 on 1.3.2017.
 */
public class Point {
    private double x;
    private double y;

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
