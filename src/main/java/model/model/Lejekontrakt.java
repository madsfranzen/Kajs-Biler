package model.model;

import java.time.LocalDate;

public class Lejekontrakt {
    private final int kontraktNr;
    private LocalDate konDato;

    public Lejekontrakt(int kontraktNr, LocalDate konDato) {
        this.kontraktNr = kontraktNr;
        this.konDato = konDato;
    }
}