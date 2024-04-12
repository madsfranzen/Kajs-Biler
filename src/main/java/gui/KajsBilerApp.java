package gui;

import javafx.application.Application;
import model.controller.Controller;
import model.model.Bil;
import model.model.Udlejning;

import java.io.IOException;

public class KajsBilerApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Bil bil1 = new Bil("DK123456", "Toyota", "Yaris", true);
//        Bil bil2 = new Bil("AD325432", "Ford", "Mustang", true);
//        Bil bil3 = new Bil("KK412293", "Ford", "Mondeo", true);
//        Bil bil4 = new Bil("FG774342", "Citroen", "Cactus", true);
//        Bil bil5 = new Bil("CC141566", "Nissan", "Skyline", true);
//
//        Controller.opretBil(bil1);
//        Controller.opretBil(bil2);
//        Controller.opretBil(bil3);
//        Controller.opretBil(bil4);
//        Controller.opretBil(bil5);


        // INITIALIZE DATABASE
        Controller.loadBilerDB();
        
        Controller.getBiler().get(0).setStatus(false);

        Controller.printBiler();
        Controller.saveBiler();
        Application.launch(KajsBilerGui.class);
    }
}