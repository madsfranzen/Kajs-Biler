package storage;

import model.model.Kunde;
import model.model.Prisgruppe;

import java.util.ArrayList;

public class Storage {
    ArrayList<Kunde> kunder = new ArrayList<>();
    ArrayList<Prisgruppe> prisgrupper = new ArrayList<>();

    public void addKunde(Kunde kunde) {
        kunder.add(kunde);
    }

    public void addPrisgruppe(Prisgruppe prisgruppe) {
        prisgrupper.add(prisgruppe);
    }
}
