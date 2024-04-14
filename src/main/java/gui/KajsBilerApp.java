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
//
//        Bil bil1 = new Bil("DK123456", "Toyota", "Yaris", true);
//        Bil bil2 = new Bil("AD325432", "Ford", "Mustang", true);
//        Bil bil3 = new Bil("KK412293", "Ford", "Mondeo", true);
//        Bil bil4 = new Bil("FG774342", "Citroen", "Cactus", true);
//        Bil bil5 = new Bil("CC141566", "Nissan", "Skyline", true);
//        Controller.opretBil(bil1);
//        Controller.opretBil(bil2);
//        Controller.opretBil(bil3);
//        Controller.opretBil(bil4);
//        Controller.opretBil(bil5);

//        Prisgruppe prisgruppeA = new Prisgruppe('A', 200, 20, 2.5);
//        Prisgruppe prisgruppeB = new Prisgruppe('B', 250, 25, 3);
//        Prisgruppe prisgruppeC = new Prisgruppe('C', 250, 30, 4.5);
//        Prisgruppe prisgruppeD = new Prisgruppe('D', 450, 35, 5);
//        Storage.opretPrisGruppe(prisgruppeA);
//        Storage.opretPrisGruppe(prisgruppeB);
//        Storage.opretPrisGruppe(prisgruppeC);
//        Storage.opretPrisGruppe(prisgruppeD);

        // Controller.opretLogin("Hanne", "Sommer");


        // INITIALIZE DATABASE
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