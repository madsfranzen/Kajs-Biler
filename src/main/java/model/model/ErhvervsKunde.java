package model.model;

public class ErhvervsKunde extends Kunde {

    private Firma firma;
    private int konto;

    public ErhvervsKunde(String navn, String adresse, int kørekortnr, int telefonnr, Firma firma) {
        super(navn, adresse, kørekortnr, telefonnr);
        this.firma = firma;
        this.konto = konto;
    }
}
