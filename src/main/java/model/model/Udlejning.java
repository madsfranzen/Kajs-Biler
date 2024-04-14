package model.model;


public class Udlejning implements java.io.Serializable {
    private final int aktuelUdlPeriode;
    private final double depositum;
    private final int kmStart;
    private final int kmSlut;
    private final Bil bil;

    public Udlejning(int aktuelUdlPeriode, double depositum, int kmStart, int kmSlut, Bil bil) {
        this.aktuelUdlPeriode = aktuelUdlPeriode;
        this.depositum = depositum;
        this.kmStart = kmStart;
        this.kmSlut = kmSlut;
        this.bil = bil;
    }
}
