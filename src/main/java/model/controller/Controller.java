package model.controller;

import gui.KajsBilerGui;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    public static boolean checkLogin(String username, String password) {
        if (username.equals("Mads") && password.equals("1234")) {
            return true;
        } else return false;
    }

    public void opretKunde() {

    }

    public void opretPrisgruppe() {

    }

}
