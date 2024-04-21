package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.controller.Controller;

import java.io.IOException;

public class CreateAccountWindow extends Stage {

    private final Button btnCreateAcc = new Button("Opret konto");
    private final TextField txfNewUsername = new TextField();
    private final TextField txfNewPassword = new TextField();

    public CreateAccountWindow(String title) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene loginScene = new Scene(pane);
        this.setScene(loginScene);
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));
        pane.setMinWidth(250);
        pane.setMinHeight(250);
        pane.setAlignment(Pos.CENTER);

        Label lblHeading = new Label("Opret Ny Konto");
        Label lblUsername = new Label("Brugernavn:");
        Label lblPassword = new Label("Password:");
        pane.add(lblHeading, 0, 0);
        pane.add(lblUsername, 0, 1);
        pane.add(txfNewUsername, 0, 2);
        txfNewUsername.setEditable(true);
        pane.add(lblPassword, 0, 3);
        pane.add(txfNewPassword, 0, 4);

        Button btnCancel = new Button("Cancel");
        HBox hBoxOpretKonto = new HBox();
        hBoxOpretKonto.setSpacing(10);
        hBoxOpretKonto.getChildren().add(btnCancel);
        hBoxOpretKonto.getChildren().add(btnCreateAcc);
        hBoxOpretKonto.setAlignment(Pos.CENTER);

        pane.add(hBoxOpretKonto, 0, 5);

        btnCancel.setOnAction(event -> this.hide());

        btnCreateAcc.setOnAction(event -> {
            try {
                if (Controller.opretLogin(txfNewUsername.getText().toString().trim(), txfNewPassword.getText().toString().trim())
                ) {
                    //window.setScene(mainScene);
                } else {
                    /*Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Missing input!");
                    alert.setHeaderText("Username already taken!");
                    alert.setContentText("Please select another username!");
                    alert.show();*/
                    lblHeading.setText("Brugernavn eksisterer allerede!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pane.add(btnCreateAcc, 1, 0);
    }
}
