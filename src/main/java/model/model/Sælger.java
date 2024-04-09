package model.model;

import java.util.ArrayList;

public class Sælger {
    private final ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private final String navn;

    public Sælger(String navn) {
        this.navn = navn;
    }
}


