package model.controller;

import model.model.Bil;
import model.model.Login;
import storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Controller {

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

    public static void loadPrisGrupperDB() throws IOException, ClassNotFoundException {
        Storage.loadPrisgrupperDB();
    }

    // virker ikke TODO
    public static void printPrisGrupper() {
        ListIterator li = Storage.getPrisgruppeB().listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    //=============================== L O G I N S ==============================//

    public static boolean checkLogin(String username, String password) {

        for (Login login : Storage.getLoginsDB()) {
            if (username.equals(login.getUsername().toString()) && password.equals(login.getPassword().toString())) {
                return true;
            }
        }
        return false;
    }

    public static void opretLogin(String username, String password) throws IOException {
        Login login = new Login(username, password);
        Storage.opretLogin(login);
    }

    public static void loadLogins() throws IOException, ClassNotFoundException {
        Storage.loadLogins();
    }
}
