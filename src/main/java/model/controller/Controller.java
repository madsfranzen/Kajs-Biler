package model.controller;

import model.model.Bil;
import storage.Storage;

import java.io.IOException;
import java.util.ListIterator;

public class Controller {


    public static boolean checkLogin(String username, String password) {
        if (username.equals("Mads") && password.equals("1234")) {
            return true;
        } else return false;
    }

    // ----------------------------- B I L E R ----------------------------------------


    public static void loadBilerDB() throws IOException, ClassNotFoundException {
        Storage.loadBilerDB();
    }

    public static void opretBil(Bil bil) throws IOException, ClassNotFoundException {
        Storage.opretBil(bil);
    }

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

    public static void printBiler() {
        ListIterator li = Storage.getBiler().listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    // ------------------------------------------------------------------------------

    public void opretKunde() {

    }

    public void opretPrisgruppe() {

    }

    public void readTest() {


    }


}
