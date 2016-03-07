package com.company;

/**
 * Created by katrinahitchcock on 04/03/16.
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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

        hBoxTop = new HBox();
        hBoxBottom = new HBox();

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getStylesheets().add("com/company/style.css");



        // grid 1 - kiosk buttons - (left side of window)
        grid = new GridPane();

        layout.setLeft(grid);
        //layout.setRight(table);


        //grid.setGridLinesVisible(true);


        img = new Image("com/company/images/Logo2.jpg");
        imgView = new ImageView();
        imgView.setImage(img);
        imgView.setVisible(true);


        Button  Btn1 = new Button("coffee \n30kr");
        Button  Btn2 = new Button("cappucino \n40kr");
        Button  Btn3 = new Button("expresso \n20kr");
        Button  Btn4 = new Button("coke \n25kr");
        Button  Btn5 = new Button("diet coke \n25kr");
        Button  Btn6 = new Button("water \n20kr");
        Button  Btn7 = new Button("t-shirt \n50kr");
        Button  Btn8 = new Button("sunglasses \n60kr");
        Button  Btn9 = new Button("suncream \n55kr");
        Button  Btn10 = new Button("pizza slice\n30kr");
        Button  Btn11 = new Button("burger \n45kr");
        Button  Btn12 = new Button("chips \n35kr");
        Button  Btn13 = new Button("lollipop \n15kr");
        Button  Btn14 = new Button("choco bar \n25kr");
        Button  Btn15 = new Button("ice cream \n30kr");

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

        //adding homeButton to layout
        layout.setBottom(hBoxBottom);

        //setting size of logo
        imgView.setFitHeight(50);
        imgView.setFitWidth(80);


        grid.setHgap(25);
        grid.setVgap(25);

        grid.setPadding(new Insets(40, 20, 20, 20));

        Btn1.setMinHeight(55);
        Btn1.setMinWidth(100);
        Btn1.setMaxWidth(100);

        Btn2.setMinHeight(55);
        Btn2.setMinWidth(100);
        Btn2.setMaxWidth(100);

        Btn3.setMinHeight(55);
        Btn3.setMinWidth(100);
        Btn3.setMaxWidth(100);

        Btn4.setMinHeight(55);
        Btn4.setMinWidth(95);
        Btn4.setMaxWidth(95);

        Btn5.setMinHeight(55);
        Btn5.setMinWidth(95);
        Btn5.setMaxWidth(95);

        Btn6.setMinHeight(55);
        Btn6.setMinWidth(95);
        Btn6.setMaxWidth(95);

        Btn7.setMinHeight(55);
        Btn7.setMinWidth(95);
        Btn7.setMaxWidth(95);

        Btn8.setMinHeight(55);
        Btn8.setMinWidth(95);
        Btn8.setMaxWidth(95);

        Btn9.setMinHeight(55);
        Btn9.setMinWidth(95);
        Btn9.setMaxWidth(95);

        Btn10.setMinHeight(55);
        Btn10.setMinWidth(95);
        Btn10.setMaxWidth(95);

        Btn11.setMinHeight(55);
        Btn11.setMinWidth(95);
        Btn11.setMaxWidth(95);

        Btn12.setMinHeight(55);
        Btn12.setMinWidth(95);
        Btn12.setMaxWidth(95);

        Btn13.setMinHeight(55);
        Btn13.setMinWidth(95);
        Btn13.setMaxWidth(95);

        Btn14.setMinHeight(55);
        Btn14.setMinWidth(95);
        Btn14.setMaxWidth(95);

        Btn15.setMinHeight(55);
        Btn15.setMinWidth(95);
        Btn15.setMaxWidth(95);



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
