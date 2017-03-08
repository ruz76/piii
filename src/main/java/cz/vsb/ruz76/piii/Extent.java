package cz.vsb.ruz76.piii;

/**
 * Created by ruz76 on 1.3.2017.
 */
public class Extent {
    private double minx;
    private double miny;
    private double maxx;
    private double maxy;

    public Extent(String wka) {
        switch (wka) {
            case "Czech Republic":
                minx = 12;
                miny = 49;
                maxx = 19;
                maxy = 51;
                break;
            case "Slovakia":
                minx = 18;
                miny = 47;
                maxx = 22;
                maxy = 49;
                break;
            default:
                minx = -180;
                miny = -90;
                maxx = 180;
                maxy = 90;
                break;
        }
    }

    public Extent(double minx, double miny, double maxx, double maxy) {
        this.minx = minx;
        this.miny = miny;
        this.maxx = maxx;
        this.maxy = maxy;
    }

    public double getMinx() {
        return minx;
    }

    public void setMinx(double minx) {
        this.minx = minx;
    }

    public double getMiny() {
        return miny;
    }

    public void setMiny(double miny) {
        this.miny = miny;
    }

    public double getMaxx() {
        return maxx;
    }

    public void setMaxx(double maxx) {
        this.maxx = maxx;
    }

    public double getMaxy() {
        return maxy;
    }

    public void setMaxy(double maxy) {
        this.maxy = maxy;
    }
}
