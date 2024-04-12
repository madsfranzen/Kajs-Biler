package storage;

import model.model.Bil;
import model.model.Kunde;
import model.model.Prisgruppe;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Storage {
    private static File bilerTxt = new File("./src/main/resources/biler.rtf");
    private static File kunderTxt = new File("./src/main/resources/kunder.rtf");
    private static ArrayList<Kunde> kunderDB = new ArrayList<>();
    private static ArrayList<Bil> bilerDB = new ArrayList<>();
    private static ArrayList<Prisgruppe> prisgrupper = new ArrayList<>();

    public Storage() throws IOException {
    }

    // ----------------------------- B I L E R ----------------------------------------


    public static void loadBilerDB() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(bilerTxt);
        ObjectInputStream ois = new ObjectInputStream(fis);
        bilerDB = (ArrayList<Bil>) ois.readObject();
        ois.close();
    }

    public static void opretBil(Bil bil) throws IOException {
        FileOutputStream fos = new FileOutputStream(bilerTxt);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        bilerDB.add(bil);
        oos.writeObject(bilerDB);
        oos.flush();
        oos.close();
    }

    public static void removeBil(Bil bil, int index) throws IOException {
        FileOutputStream fos = new FileOutputStream(bilerTxt);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        bilerDB.remove(index);
        oos.writeObject(bilerDB);
        oos.flush();
        oos.close();
    }

    public static ArrayList getBiler() {
        return bilerDB;
    }

    // ----------------------------- K U N D E R ------------------------------------

    public static void loadKunderDB() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(kunderTxt);
        ObjectInputStream ois = new ObjectInputStream(fis);
        kunderDB = (ArrayList<Kunde>) ois.readObject();
        ois.close();
    }

    public static ArrayList<Kunde> getKunder() {
        return kunderDB;
    }


    public void opretKunde(Kunde kunde) throws IOException {
        FileOutputStream fos = new FileOutputStream(kunderTxt);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        kunderDB.add(kunde);
        oos.writeObject(kunderDB);
        oos.flush();
        oos.close();
    }
}