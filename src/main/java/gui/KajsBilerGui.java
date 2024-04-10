package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.controller.Controller;

public class KajsBilerGui extends Application {

    Stage window;
    Scene mainScene, loginScene;
    GridPane mainPane = new GridPane();
    GridPane loginPane = new GridPane();

    // LOGIN TING
    Label lblWrongPassword = new Label("Forkert brugernavn/kodeord");
    private TextField txfUsername = new TextField();
    private PasswordField pswPassword = new PasswordField();
    private TextField txfSøg = new TextField();
    private Button btnLogin = new Button("Login");
    private Controller controller = new Controller();

    @Override
    public void start(Stage stage) {
        window = stage;
        stage.setTitle("Kajs Biler");

        Scene mainScene = new Scene(mainPane);
        Scene loginScene = new Scene(loginPane);

        mainScene.setOnMouseClicked(event -> {
            if (!txfSøg.equals(event.getSource())) {
                txfSøg.getParent().requestFocus();
            }
        });

        this.initContent(mainPane, loginPane);
        stage.setScene(loginScene);
        stage.show();

        btnLogin.setOnAction(event -> {
            if (controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
                window.setScene(mainScene);
            } else {
                loginPane.add(lblWrongPassword, 0, 2);
                txfUsername.setText("");
                pswPassword.setText("");
            }
        });
    }

    // --------------------------- M A I N - W I N D O W ---------------------------------

    private void initContent(GridPane mainPane, GridPane loginPane) {

        mainPane.setGridLinesVisible(true);
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10));

        Label lblHello = new Label("Hello");
        mainPane.add(txfSøg, 0, 0);
        mainPane.add(lblHello, 0, 1);
        mainPane.setAlignment(Pos.CENTER);

        // ----------------------------- L O G I N ----------------------------------------

        loginPane.setGridLinesVisible(false);
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.setPadding(new Insets(10));
        loginPane.setMinWidth(250);
        loginPane.setMinHeight(250);
        loginPane.setAlignment(Pos.CENTER);

        loginPane.add(txfUsername, 0, 0);
        loginPane.add(pswPassword, 0, 1);
        HBox btnBox = new HBox(btnLogin);
        loginPane.add(btnBox, 0, 3);
        btnBox.setAlignment(Pos.CENTER);
    }


    private void btnLoginAction() {
        // Checks for correct username/password and changes scene if correct
        if (controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
            window.setScene(mainScene);
        } else {
            loginPane.add(lblWrongPassword, 0, 2);
            txfUsername.setText("");
            pswPassword.setText("");
        }
    }
}
