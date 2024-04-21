package model.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Prisgruppe implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private final ArrayList<Bil> biler = new ArrayList<>();
    private char gruppe;
    private double prisPrDag;
    private double prisPrTime;
    private double prisPrKm;

    public Prisgruppe(char gruppe, double prisPrDag, double prisPrTime, double prisPrKm) {
        this.gruppe = gruppe;
        this.prisPrDag = prisPrDag;
        this.prisPrTime = prisPrTime;
        this.prisPrKm = prisPrKm;
    }

    public void addBil(Bil bil) {
        if (bil.getPrisgruppe() != null) {
            bil.getPrisgruppe().removeBil(bil);
        }
        biler.add(bil);
    }

    public void removeBil(Bil bil) {
        biler.remove(bil);
    }

    public ArrayList<Bil> getBiler() {
        return biler;
    }

    @Override
    public String toString() {
        return "Prisgruppe{" +
                "gruppe=" + gruppe +
                ", biler=" + biler +
                ", prisPrDag=" + prisPrDag +
                ", prisPrTime=" + prisPrTime +
                ", prisPrKm=" + prisPrKm +
                '}';
    }
}