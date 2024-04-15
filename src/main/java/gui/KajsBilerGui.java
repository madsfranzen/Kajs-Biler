package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.controller.Controller;

import java.util.TreeSet;

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

    private TextField txfSearch = new TextField();

    @Override
    public void start(Stage stage) {

        window = stage;
        window.setTitle("Kajs Biler");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene mainScene = new Scene(pane);

        GridPane loginPane = new GridPane();
        Scene loginScene = new Scene(loginPane);

        window.setMaximized(true); // setting screen to maxsize at startup
        window.setScene(mainScene);
        window.show();

        mainScene.setOnMouseClicked(event -> {
            if (!txfSearch.equals(event.getSource())) {
                txfSearch.getParent().requestFocus();
            }
        });



        // create login pop-up instead --------------

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

    private void initContent(BorderPane pane) {
        HBox topBox = new HBox();
        this.initMainTopPane(topBox);

        GridPane centerPane = new GridPane();
        this.initMainCenterPane(centerPane);

        GridPane leftPane = new GridPane();
        this.initMainLeftPane(leftPane);

        GridPane rightPane = new GridPane();
        this.initmainRightPane(rightPane);

        pane.setTop(topBox);
        pane.setCenter(centerPane);
        pane.setLeft(leftPane);
        pane.setRight(rightPane);
    }

    // region
    // ============================= M A I N - W I N D O W =============================

    // -------------------------------Top--------------------------------

    private void initMainTopPane(HBox hbxButtons) {
        hbxButtons.setPadding(new Insets(10));
        hbxButtons.setSpacing(10);

        Button btnTopSearch = new Button("Find biler");
        Button btnLogin = new Button("Login");

        hbxButtons.getChildren().addAll(btnTopSearch, btnLogin);
    }

    // ------------------------------Center------------------------------

    private void initMainCenterPane(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        pane.add(txfSearch, 0, 0);
        txfSearch.setPromptText("Søg");
        //pane.setAlignment(Pos.CENTER);
    }


    // -------------------------------Left-------------------------------

    private void initMainLeftPane(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        Label lblFilter = new Label("Filter");
        lblFilter.setUnderline(true);
        lblFilter.setStyle("-fx-font: 14 arial;");
        pane.add(lblFilter, 0, 0);

        TreeItem<String> rootItem = new TreeItem<>("Filter");
        TreeItem<String> category1 = new TreeItem<>("Prisgruppe");
        category1.getChildren().addAll(new CheckBoxTreeItem<>("A"), new TreeItem<>("B"), new TreeItem<>("C"), new TreeItem<>("D"));
        TreeItem<String> category2 = new TreeItem<>("Mærke");
        category2.getChildren().addAll(new TreeItem<>("BMW"), new TreeItem<>("VW"));
        CheckBoxTreeItem<String> category3 = new CheckBoxTreeItem<>("Årgang");
        category3.getChildren().addAll(new TreeItem<>("2000"), new TreeItem<>("2010"));
        rootItem.getChildren().addAll(category1, category2, category3);



        TreeItem<String> rootItems = new TreeItem<>("Root");
        TreeItem<String> aItem = new TreeItem<>("A");
        TreeItem<String> a1Item = new CheckBoxTreeItem<>("A_1");
        TreeItem<String> a11Item = new CheckBoxTreeItem<>("A_1_1");
        TreeItem<String> a12Item = new CheckBoxTreeItem<>("A_1_2");
        TreeItem<String> a111Item = new CheckBoxTreeItem<>("A_1_1_1");
        TreeItem<String> a2Item = new CheckBoxTreeItem<>("A_2");
        TreeItem<String> a21Item = new CheckBoxTreeItem<>("A_2_1");
        TreeItem<String> a211Item = new CheckBoxTreeItem<>("A_2_1_1");
        TreeItem<String> a22Item = new CheckBoxTreeItem<>("A_2_2");
        TreeItem<String> bItem = new CheckBoxTreeItem<>("B");
        TreeItem<String> cItem = new CheckBoxTreeItem<>("C");

        aItem.getChildren().addAll(a1Item, a2Item);
        a1Item.getChildren().addAll(a11Item, a12Item);
        a11Item.getChildren().add(a111Item);

        rootItems.getChildren().addAll(aItem, bItem, cItem);

        TreeView<String> treeView = new TreeView<>(rootItems);
        treeView.setShowRoot(true);

        //treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

        pane.add(treeView, 0, 1);
    }

    private Button btnSearch = new Button("Søg");


    // ------------------------------Right-------------------------------

    private void initmainRightPane(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10));

        pane.add(btnSearch, 0, 0);

        Label lblLatestRentals = new Label("Seneste udlejninger:");
        lblLatestRentals.setUnderline(true);
        pane.add(lblLatestRentals, 0, 1);
    }

    // endregion


    // if wrong password ------------------

    private void wrongPassword() {
        // If wrong Username or Password
        //loginPane.add(lblWrongPassword, 0, 2);
        txfUsername.setText("");
        pswPassword.setText("");
    }
}
