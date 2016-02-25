package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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


    @Override
    public void start(Stage primaryStage)
    {
        grid = new GridPane();
        hBox = new HBox();
        scene = new Scene(grid, 800, 600);

        manageBtn = new Button("Manage \nActivity");
        reserveBtn = new Button("Make \nReservation");

        img = new Image("com/Logo2.jpg");
        imgView = new ImageView();
        imgView.setImage(img);
        imgView.setVisible(true);


        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().addAll(imgView);

        grid.add(imgView, 0,0);
        //grid.add(hBox, 0, 0);

        grid.setColumnSpan(imgView, 3);
        imgView.setFitHeight(200);
        imgView.setFitWidth(350);


        manageBtn.setMinHeight(90);
        manageBtn.setMinWidth(200);
        manageBtn.setMaxWidth(200);

        reserveBtn.setMinHeight(90);
        reserveBtn.setMinWidth(200);
        reserveBtn.setMaxWidth(200);

        manageBtn.setFont(Font.font(null, FontWeight.BOLD, 20));
        reserveBtn.setFont(Font.font(null, FontWeight.BOLD, 20));

        grid.setHgap(10);
        grid.setVgap(50);



        //grid.setGridLinesVisible(true);
        //grid.setPadding(new Insets(50, 20, 20, 50));

        grid.add(manageBtn, 1, 1);
        grid.add(reserveBtn, 2, 1);
        grid.setAlignment(Pos.CENTER);


        primaryStage.setTitle("Adventure parks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
