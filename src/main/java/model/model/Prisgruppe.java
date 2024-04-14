package model.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Prisgruppe implements Serializable {
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

    public char getGruppe() {
        return gruppe;
    }

    public void setGruppe(char gruppe) {
        this.gruppe = gruppe;
    }

    public double getPrisPrDag() {
        return prisPrDag;
    }

    public void setPrisPrDag(double prisPrDag) {
        this.prisPrDag = prisPrDag;
    }

    public double getPrisPrTime() {
        return prisPrTime;
    }

    public void setPrisPrTime(double prisPrTime) {
        this.prisPrTime = prisPrTime;
    }

    public double getPrisPrKm() {
        return prisPrKm;
    }

    public void setPrisPrKm(double prisPrKm) {
        this.prisPrKm = prisPrKm;
    }
    
}