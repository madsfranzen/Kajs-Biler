package model.model;

import java.time.LocalDate;

public class Værkstedsbesøg {
    private final String hændelse;
    private final int kmTal;
    private final LocalDate dato;

    public Værkstedsbesøg(String hændelse, int kmTal, LocalDate dato) {
        this.hændelse = hændelse;
        this.kmTal = kmTal;
        this.dato = dato;
    }
}
