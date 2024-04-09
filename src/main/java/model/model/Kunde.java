package model.model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String adresse;
    private int kørekortnr;
    private int telefonnr;
    private ArrayList<Lejekontrakt> lejekontrakter = new ArrayList<>();

    public Kunde(String navn, String adresse, int kørekortnr, int telefonnr) {
        this.navn = navn;
        this.adresse = adresse;
        this.kørekortnr = kørekortnr;
        this.telefonnr = telefonnr;
    }
}
