package gui;

import javafx.application.Application;
import model.controller.Controller;
import model.model.Bil;
import model.model.Udlejning;

import java.io.IOException;

public class KajsBilerApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // INITIALIZE DATABASE
        initStorage();

        Application.launch(KajsBilerGui.class);
    }

    public static void initStorage() throws IOException,ClassNotFoundException {
        Controller.loadBilerDB();
        Controller.printBiler();
        Controller.saveBiler();
    }
}