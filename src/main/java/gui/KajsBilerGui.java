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

public class KajsBilerGui extends Application {

    Stage window;
    Scene mainScene, loginScene;
    // LOGIN TING
    private Controller controller = new Controller();
    private TextField txfUsername = new TextField();
    private PasswordField pswPassword = new PasswordField();
    private Label lblWrongPassword = new Label("Forkert brugernavn/kodeord");
    private Button btnLogin = new Button("Login");
    private Button btnCreateProfile = new Button("Opret konto");

    private TextField txfSøg = new TextField();

    @Override
    public void start(Stage stage) {
        window = stage;
        stage.setTitle("Kajs Biler");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        GridPane mainPane = new GridPane();
        GridPane loginPane = new GridPane();
        //this.initContent(loginPane);

        Scene mainScene = new Scene(pane);
        Scene loginScene = new Scene(loginPane);

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
    }

    // ============================= M A I N - W I N D O W =============================

    private void initContent(GridPane loginPane) {
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
    }

    private void initMainPane(GridPane mainPane) {
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
