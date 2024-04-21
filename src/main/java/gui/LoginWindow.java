package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.controller.Controller;

public class LoginWindow extends Stage {
    public LoginWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene loginScene = new Scene(pane);
        this.setScene(loginScene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfUsername = new TextField();
    private final PasswordField pswPassword = new PasswordField();
    private final Label lblWrongPassword = new Label("Forkert brugernavn/kodeord");
    private final Button btnLogin = new Button("Login");
    private final Button btnCreateProfile = new Button("Opret konto");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));
        pane.setMinWidth(250);
        pane.setMinHeight(250);
        pane.setAlignment(Pos.CENTER);

        pane.add(txfUsername, 0, 0);
        txfUsername.setPromptText("Brugernavn");
        pane.add(pswPassword, 0, 1);
        pswPassword.setPromptText("Adganskode");
        pane.add(lblWrongPassword, 0, 2);
        lblWrongPassword.setVisible(false);

        HBox btnBox = new HBox();
        btnBox.setSpacing(10);
        btnBox.getChildren().addAll(btnLogin, btnCreateProfile);
        pane.add(btnBox, 0, 3);
        btnBox.setAlignment(Pos.CENTER);


        // actions
        btnLogin.setOnAction(event -> {
            if (Controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
                this.hide();
            } else {
                wrongPassword(pane);
            }
        });

        pswPassword.setOnAction(event -> {
            if (Controller.checkLogin(txfUsername.getText(), pswPassword.getText())) {
                this.hide();
            } else {
                wrongPassword(pane);
            }
        });

        btnCreateProfile.setOnAction(event -> {
            this.hide();
            CreateAccountWindow dialog = new CreateAccountWindow("Opret konto");
            dialog.showAndWait();
        });
    }

    // if wrong password ------------------

    private void wrongPassword(GridPane pane) {
        // If wrong Username or Password
        if (!lblWrongPassword.isVisible())
            lblWrongPassword.setVisible(true);
        lblWrongPassword.setTextFill(Color.RED);
        txfUsername.setText("");
        pswPassword.setText("");
    }
}
