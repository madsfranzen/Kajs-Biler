package model.model;

import java.util.ArrayList;

public class Bil implements java.io.Serializable {
    private final String regNr;
    private final String mærke;
    private final String model;
    private final Boolean status;
    private final ArrayList<Værkstedsbesøg> værkstedsbesøg = new ArrayList<>();
    private final ArrayList<Udlejning> udlejninger = new ArrayList<>();

    public Bil(String regNr, String mærke, String model, Boolean status) {
        this.regNr = regNr;
        this.mærke = mærke;
        this.model = model;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "regNr='" + regNr + '\'' +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", status=" + status +
                ", værkstedsbesøg=" + værkstedsbesøg +
                ", udlejninger=" + udlejninger +
                '}';
    }

    public String getRegNr() {
        return regNr;
    }
}
