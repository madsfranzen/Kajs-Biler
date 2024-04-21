package gui;

import javafx.application.Application;
import model.controller.Controller;
import model.model.Bil;
import model.model.Login;
import model.model.Prisgruppe;
import model.model.Udlejning;
import storage.Storage;

import java.io.IOException;

public class KajsBilerApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // INITIALIZE DATABASE
        initStorage();

        Application.launch(KajsBilerGui.class);
    }

    public static void initStorage() throws IOException,ClassNotFoundException {
        Controller.loadBilerDB();
        Controller.loadLogins();
        Controller.loadPrisGrupperDB();

        //=================== TESTS ====================//
        System.out.println("Biler:");
        Controller.printBiler();
        System.out.println("----------");
        System.out.println("Prisgrupper:");
        Controller.printPrisGrupper();
        System.out.println("----------");
        System.out.println("Logins:");
        Controller.printLogins();
        System.out.println("----------");

        Application.launch(KajsBilerGui.class);
    }
}