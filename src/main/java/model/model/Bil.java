package model.model;

import java.util.ArrayList;

public class Bil implements java.io.Serializable {
    private final String regNr;
    private final String mærke;
    private final String model;
    private final ArrayList<Værkstedsbesøg> værkstedsbesøg = new ArrayList<>();
    private final ArrayList<Udlejning> udlejninger = new ArrayList<>();
    private Boolean status;
    private Prisgruppe prisgruppe;

    public Bil(String regNr, String mærke, String model, Boolean status) {
        this.regNr = regNr;
        this.mærke = mærke;
        this.model = model;
        this.status = status;
    }

    public void createUdlejning(Udlejning udlejning) {
        udlejninger.add(udlejning);
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

    public Prisgruppe getPrisgruppe() {
        return prisgruppe;
    }

    public String getMærke() {
        return mærke;
    }

    public String getModel() {
        return model;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<Værkstedsbesøg> getVærkstedsbesøg() {
        return værkstedsbesøg;
    }

    public ArrayList<Udlejning> getUdlejninger() {
        return udlejninger;
    }
}
