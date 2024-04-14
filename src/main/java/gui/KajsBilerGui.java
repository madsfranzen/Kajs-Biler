package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.controller.Controller;

import java.io.IOException;

public class KajsBilerGui extends Application {

    Stage window;
    Scene mainScene, loginScene, opretKontoScene;
    // LOGIN TING
    private Controller controller = new Controller();
    private TextField txfUsername = new TextField();
    private PasswordField pswPassword = new PasswordField();
    private Label lblWrongPassword = new Label("Forkert brugernavn/kodeord");
    private Button btnLogin = new Button("Login");
    private Button btnCreateProfile = new Button("Opret konto");

    // NY KONTO
    private TextField txfNewUsername = new TextField();
    private TextField txfNewPassword = new TextField();
    private Button btnOpretKontoConfirm = new Button("Opret Konto");

    private TextField txfSøg = new TextField();

    @Override
    public void start(Stage stage) {
        window = stage;
        stage.setTitle("Kajs Biler");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        GridPane mainPane = new GridPane();
        GridPane loginPane = new GridPane();
        GridPane opretKontoPane = new GridPane();
        //this.initContent(loginPane);

        Scene mainScene = new Scene(pane);
        Scene loginScene = new Scene(loginPane);
        Scene opretKontoScene = new Scene(opretKontoPane);

        stage.setScene(loginScene);
        stage.show();


        mainScene.setOnMouseClicked(event -> {
            if (!txfSøg.equals(event.getSource())) {
                txfSøg.getParent().requestFocus();
            }
        });
        btnLogin.setOnAction(event -> {
            if (controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
                window.setScene(mainScene);
            } else {
                wrongPassword();
            }
        });

        pswPassword.setOnAction(event -> {
            if (controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
                window.setScene(mainScene);
            } else {
                wrongPassword();
            }
        });

        btnCreateProfile.setOnAction(event -> {
            stage.setScene(opretKontoScene);
        });
    }

    // ============================= M A I N - W I N D O W =============================

    private void initContent(GridPane mainPane, GridPane loginPane, GridPane opretKontoPane) {
        BorderPane pane = new BorderPane();
        initContent(pane);

        // ================================= L O G I N =================================

        loginPane.setGridLinesVisible(false);
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.setPadding(new Insets(10));
        loginPane.setMinWidth(250);
        loginPane.setMinHeight(250);
        loginPane.setAlignment(Pos.CENTER);

        loginPane.add(txfUsername, 0, 0);
        loginPane.add(pswPassword, 0, 1);
        HBox btnBox = new HBox();
        btnBox.setSpacing(10);
        btnBox.getChildren().addAll(btnLogin, btnCreateProfile);
        loginPane.add(btnBox, 0, 3);
        btnBox.setAlignment(Pos.CENTER);

        // ============================= O P R E T  K O N T O ===============================

        opretKontoPane.setGridLinesVisible(false);
        opretKontoPane.setHgap(10);
        opretKontoPane.setVgap(10);
        opretKontoPane.setPadding(new Insets(10));
        opretKontoPane.setMinWidth(250);
        opretKontoPane.setMinHeight(250);
        opretKontoPane.setAlignment(Pos.CENTER);

        Label lblHeading = new Label("Opret Ny Konto");
        Label lblUsername = new Label("Brugernavn:");
        Label lblPassword = new Label("Password:");
        opretKontoPane.add(lblHeading, 0, 0);
        opretKontoPane.add(lblUsername, 0, 1);
        opretKontoPane.add(txfNewUsername, 0, 2);
        opretKontoPane.add(lblPassword, 0, 3);
        opretKontoPane.add(txfNewPassword, 0, 4);

        Button btnCancel = new Button("Cancel");
        HBox btnBoxOpretKonto = new HBox();
        btnBoxOpretKonto.setSpacing(10);
        btnBoxOpretKonto.getChildren().add(btnCancel);
        btnBoxOpretKonto.getChildren().add(btnOpretKontoConfirm);
        btnBox.setAlignment(Pos.CENTER);

        opretKontoPane.add(btnBoxOpretKonto, 0, 5);

        btnCancel.setOnAction(event -> {
            window.setScene(loginScene);
        });

        btnOpretKontoConfirm.setOnAction(event -> {
            try {
                if (Controller.opretLogin(txfNewUsername.getText().toString().trim(), txfNewPassword.getText().toString().trim())
                ) {
                    window.setScene(mainScene);
                } else lblHeading.setText("Brugernavn eksisterer allerede!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // ====================================================================================

    private void initMainPane(GridPane mainPane) {
        //pane.setCenter(mainPane);
        mainPane.setGridLinesVisible(true);
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10));

        Label lblHello = new Label("Hello");
        mainPane.add(txfSøg, 0, 0);
        mainPane.add(lblHello, 0, 1);
        mainPane.setAlignment(Pos.CENTER);
    }

    private void initContent(BorderPane pane) {
        GridPane mainPane = new GridPane();
        this.initMainCenterPane(mainPane);
        pane.setCenter(mainPane);

    }

    private void initMainCenterPane(GridPane pane) {
        pane.setGridLinesVisible(true);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        Label lblHello = new Label("Hello");
        pane.add(txfSøg, 0, 0);
        pane.add(lblHello, 0, 1);
        pane.setAlignment(Pos.CENTER);
    }

    private void wrongPassword() {
        // If wrong Username or Password
        //loginPane.add(lblWrongPassword, 0, 2);
        txfUsername.setText("");
        pswPassword.setText("");
    }
}
