package com.company;

/**
 * Created by katrinahitchcock on 04/03/16.
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;


public class KioskScene  {

    Scene scene;
    GridPane grid;
    HBox hBoxTop;
    HBox hBoxBottom;

    Image img;
    ImageView imgView;

    Button Btn1;
    Button Btn2;
    Button Btn3;
    Button Btn4;
    Button Btn5;
    Button Btn6;
    Button Btn7;
    Button Btn8;
    Button Btn9;
    Button Btn10;
    Button Btn11;
    Button Btn12;
    Button Btn13;
    Button Btn14;
    Button Btn15;

    Button homeButton;

    public void display(Stage primaryStage) {

        Stage window = new Stage();

        grid = new GridPane();

        hBoxTop = new HBox();
        hBoxBottom = new HBox();

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getStylesheets().add("com/company/style.css");
        layout.setLeft(grid);

        img = new Image("com/company/images/Logo2.jpg");
        imgView = new ImageView();
        imgView.setImage(img);
        imgView.setVisible(true);

        //scene.getStylesheets().add("com/company/style.css");
        //javafx.scene.image.Image image = new javafx.scene.image.Image("com/company/images/Logo2.jpg");


        Button  Btn1 = new Button("coke");
        Button  Btn2 = new Button("coke");
        Button  Btn3 = new Button("coke");
        Button  Btn4 = new Button("coke");
        Button  Btn5 = new Button("coke");
        Button  Btn6 = new Button("coke");
        Button  Btn7 = new Button("coke");
        Button  Btn8 = new Button("coke");
        Button  Btn9 = new Button("coke");
        Button  Btn10 = new Button("coke");
        Button  Btn11 = new Button("coke");
        Button  Btn12 = new Button("coke");
        Button  Btn13 = new Button("coke");
        Button  Btn14 = new Button("coke");
        Button  Btn15 = new Button("coke");

        Button  homeButton = new Button("Back");

        HBox hBoxBottom = new HBox();
        hBoxBottom.getChildren().addAll(homeButton);


        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(imgView);

        grid.add(Btn1, 0, 0);
        grid.add(Btn2, 1, 0);
        grid.add(Btn3, 2, 0);

        grid.add(Btn4, 0, 1);
        grid.add(Btn5, 1, 1);
        grid.add(Btn6, 2, 1);

        grid.add(Btn7, 0, 2);
        grid.add(Btn8, 1, 2);
        grid.add(Btn9, 2, 2);

        grid.add(Btn10, 0, 3);
        grid.add(Btn11, 1, 3);
        grid.add(Btn12, 2, 3);

        grid.add(Btn13, 0, 4);
        grid.add(Btn14, 1, 4);
        grid.add(Btn15, 2, 4);


        //adding logo to layout
        layout.setTop(hBoxTop);

        //setting size of logo
        imgView.setFitHeight(50);
        imgView.setFitWidth(80);


        //adding homeButton to layout
        layout.setBottom(hBoxBottom);


        grid.setHgap(30);
        grid.setVgap(30);

        grid.setPadding(new Insets(40, 20, 20, 20));

        Btn1.setMinHeight(50);
        Btn1.setMinWidth(90);
        Btn1.setMaxWidth(90);

        Btn2.setMinHeight(50);
        Btn2.setMinWidth(90);
        Btn2.setMaxWidth(90);

        Btn3.setMinHeight(50);
        Btn3.setMinWidth(90);
        Btn3.setMaxWidth(90);

        Btn4.setMinHeight(50);
        Btn4.setMinWidth(90);
        Btn4.setMaxWidth(90);

        Btn5.setMinHeight(50);
        Btn5.setMinWidth(90);
        Btn5.setMaxWidth(90);

        Btn6.setMinHeight(50);
        Btn6.setMinWidth(90);
        Btn6.setMaxWidth(90);

        Btn7.setMinHeight(50);
        Btn7.setMinWidth(90);
        Btn7.setMaxWidth(90);

        Btn8.setMinHeight(50);
        Btn8.setMinWidth(90);
        Btn8.setMaxWidth(90);

        Btn9.setMinHeight(50);
        Btn9.setMinWidth(90);
        Btn9.setMaxWidth(90);

        Btn10.setMinHeight(50);
        Btn10.setMinWidth(90);
        Btn10.setMaxWidth(90);

        Btn11.setMinHeight(50);
        Btn11.setMinWidth(90);
        Btn11.setMaxWidth(90);

        Btn12.setMinHeight(50);
        Btn12.setMinWidth(90);
        Btn12.setMaxWidth(90);

        Btn13.setMinHeight(50);
        Btn13.setMinWidth(90);
        Btn13.setMaxWidth(90);

        Btn14.setMinHeight(50);
        Btn14.setMinWidth(90);
        Btn14.setMaxWidth(90);

        Btn15.setMinHeight(50);
        Btn15.setMinWidth(90);
        Btn15.setMaxWidth(90);

        //grid.setGridLinesVisible(true);

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                View view = new View();
                //Stage window2 = new Stage();
                view.start(primaryStage);
            }
        });



        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Kiosk");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
