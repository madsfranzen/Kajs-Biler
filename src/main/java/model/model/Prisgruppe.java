package model.model;

import java.util.ArrayList;

public class Prisgruppe {
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
}