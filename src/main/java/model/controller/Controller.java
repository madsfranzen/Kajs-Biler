package model.controller;

import model.model.Bil;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Controller {

    //==================================== L O G I N ====================================//

    public static boolean checkLogin(String username, String password) {
        if (username.equals("Mads") && password.equals("1234")) {
            return true;
        } else return false;
    }

    //==================================== B I L E R ====================================//

    /**
     * Loader biler ind i ArrayListen bilerDB fra databasen.
     * Kaldes ved start af programmet.
     */
    public static void loadBilerDB() throws IOException, ClassNotFoundException {
        Storage.loadBilerDB();
    }

    public static void opretBil(Bil bil) throws IOException, ClassNotFoundException {
        Storage.opretBil(bil);
    }

    /**
     * Gemmer alle biler i databasen. Bør kaldes efter en opdatering af biler.
     */
    public static void saveBiler() throws IOException {
        Storage.saveBiler();
    }

    /**
     * Fjerner en bil ved at sammenligne reg.nr.
     */
    public static void removeBil(Bil bil) throws IOException {
        ListIterator li = Storage.getBiler().listIterator();
        int index = 0;
        while (li.hasNext()) {
            Bil bilNext = (Bil) li.next();
            if (bilNext.getRegNr().equals(bil.getRegNr())) {
                Storage.removeBil(bil, index);
                break;
            }
            index++;
        }
    }

    public static ArrayList<Bil> getBiler() {
        return Storage.getBiler();
    }

    public static void printBiler() {
        ListIterator li = Storage.getBiler().listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    //================================================================================//

    public void opretKunde() {

    }

    public void opretPrisgruppe() {

    }
}
