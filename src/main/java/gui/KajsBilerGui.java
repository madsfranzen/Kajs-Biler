package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class KajsBilerGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Kajs Biler");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        scene.setOnMouseClicked(event -> {
            if (!txfSøg.equals(event.getSource())) {
                txfSøg.getParent().requestFocus();
            }
        });
    }

    private TextField txfSøg = new TextField();

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));


    }
}
