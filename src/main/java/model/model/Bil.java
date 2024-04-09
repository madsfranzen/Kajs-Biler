package model.model;

import java.util.ArrayList;

public class Bil {
    private final int regNr;
    private final String mærke;
    private final String model;
    private final Boolean status;
    private final ArrayList<Værkstedsbesøg> værkstedsbesøg = new ArrayList<>();
    private final ArrayList<Udlejning> udlejninger = new ArrayList<>();

    public Bil(int regNr, String mærke, String model, Boolean status) {
        this.regNr = regNr;
        this.mærke = mærke;
        this.model = model;
        this.status = status;
    }
}
