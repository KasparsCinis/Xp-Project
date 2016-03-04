package com.company;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * Created by Donika on 2/25/2016.
 */
public class View extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    GridPane grid;
    HBox hBox;
    Scene scene;

    Image img;
    ImageView imgView;

    Button manageBtn;
    Button reserveBtn;
    Button kioskBtn;
    ActivityScene m = new ActivityScene();
    ReservationScene reservationScene = new ReservationScene();
    KioskScene kioskScene = new KioskScene();

    @Override
    public void start(Stage primaryStage)
    {

        grid = new GridPane();
        hBox = new HBox();
        scene = new Scene(grid, 800, 600);

        scene.getStylesheets().add("com/company/style.css");

        manageBtn = new Button("Activities");
        manageBtn.setOnAction(event -> {
            m.display(primaryStage);
            primaryStage.setScene(m.window.getScene());
            //primaryStage.close();
        });
        reserveBtn = new Button("Reservations");
        reserveBtn.setOnAction(event -> {
            reservationScene.display(primaryStage);
            primaryStage.setScene(reservationScene.window.getScene());
            //primaryStage.close();
        });

        kioskBtn = new Button("Kiosk");
        kioskBtn.setOnAction(event -> {
            kioskScene.display(primaryStage);
            primaryStage.setScene(kioskScene.window.getScene());
            //primaryStage.close();
        });



        img = new Image("com/company/images/Logo2.jpg");
        imgView = new ImageView();
        imgView.setImage(img);
        imgView.setVisible(true);


        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().addAll(imgView);

        //grid.add(imgView, 0,0);
        grid.add(hBox, 0, 0);

        grid.setColumnSpan(hBox, 3);
        imgView.setFitHeight(200);
        imgView.setFitWidth(350);


        manageBtn.setMinHeight(90);
        manageBtn.setMinWidth(160);
        manageBtn.setMaxWidth(160);

        reserveBtn.setMinHeight(90);
        reserveBtn.setMinWidth(160);
        reserveBtn.setMaxWidth(160);

        kioskBtn.setMinHeight(90);
        kioskBtn.setMinWidth(160);
        kioskBtn.setMaxWidth(160);



        grid.setHgap(10);
        grid.setVgap(50);


        // setId - links to style in css style sheet..
        manageBtn.setId("manageBtnStyle");
        reserveBtn.setId("reserveBtnStyle");
        kioskBtn.setId("kioskBtnStyle");



        //grid.setGridLinesVisible(true);



        grid.add(kioskBtn, 3, 1);
        grid.add(manageBtn, 2, 1);
        grid.add(reserveBtn, 1, 1);
        grid.setAlignment(Pos.CENTER);


        primaryStage.setTitle("Adventure parks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
