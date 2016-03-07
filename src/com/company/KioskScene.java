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
import javafx.scene.layout.*;

import javafx.stage.Stage;

import java.util.ArrayList;


public class KioskScene  {

    Scene scene;
    GridPane grid, rightGrid;

    HBox hBoxTop;
    HBox hBoxBottom;

    Image img;
    ImageView imgView;

    ModelClass database = new ModelClass();
    ArrayList<kioskItem> kioskItems = new ArrayList<>();
    ArrayList<soldItems> itemList = new ArrayList<>();

    ArrayList<Button> buttonList = new ArrayList<>();

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
        rightGrid = new GridPane();

        layout.setLeft(grid);
        layout.setRight(rightGrid);
        //layout.setRight(table);

        updateRightGrid();
        /*rightGrid.add(new Label("Item amount"), 0, 0);
        rightGrid.add(new Label("                                 "), 1, 0);
        rightGrid.add(new Label("       "), 2, 0);
        rightGrid.add(new Label("   "), 3, 0);
        rightGrid.add(new Label("                                  "), 4, 0);
        //rightGrid.getColumnConstraints().add(new ColumnConstraints(400));

        rightGrid.add(new Label("Coffee"), 0, 1);
        rightGrid.add(new Label("3"), 1, 1);
        rightGrid.add(new Label("30Kr"), 2, 1);
        rightGrid.add(new Button("+"), 3, 1);
        rightGrid.add(new Button("-"), 4, 1);*/

        //rightGrid.add(new Label("                                                                                                                                                      "), 1, 0);
       // rightGrid.add(new Label("aspoldkaspdjfas"), 2, 0);
        //rightGrid.add(new Label("aspoldkaspdjfas"), 3, 0);
       // rightGrid.add(new Label("button+"), 45, 1);
       // rightGrid.setPadding(new Insets(0, 300, 0, 25));
        rightGrid.setStyle("-fx-background-color:rgb(255,181,81);" +
                "fx-border-color: blue;" +
                "-fx-border-insets: 5;" +
                "-fx-border-width: 3;" +
                "-fx-border-style: solid;");

        //grid.setGridLinesVisible(true);


        img = new Image("com/company/images/Logo2.jpg");
        imgView = new ImageView();
        imgView.setImage(img);
        imgView.setVisible(true);

        //Get stuff from database
        kioskItems = database.getDBKioskItems();
        int buttonCounter = 0;
        for (kioskItem k : kioskItems)
        {

            int positionY = buttonCounter / 3;
            int positionX = buttonCounter - positionY * 3;
            Button button = new Button(k.getName());
            buttonList.add(button);
            button.setMinHeight(55);
            button.setMinWidth(100);
            button.setMaxWidth(100);
            button.setOnAction(event -> {
                //receiptList.add(new );
                boolean alreadyInTheList = false;
                for (soldItems s : itemList)
                {
                    if (s.getIdKioskItem() == k.getIdKioskItem())
                    {
                        //Increment the amount
                        alreadyInTheList = true;
                        s.setQuantity(s.getQuantity() + 1);
                    }
                }

                if (alreadyInTheList == false)
                {
                    //Add it to the list
                    itemList.add(new soldItems(k.getName(), k.getIdKioskItem(), 1, k.getPrice()));
                }
               // System.out.println(k.getIdKioskItem());
                updateRightGrid();
            });

            grid.add(button, positionX, positionY);

            buttonCounter += 1;
        }

        Button  homeButton = new Button("Back");

        HBox hBoxBottom = new HBox();
        hBoxBottom.getChildren().addAll(homeButton);

        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(imgView);


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

    private void updateRightGrid()
    {
        //Set all the buttons editable
        for (Button b : buttonList)
        {
            b.setDisable(false);
        }
        rightGrid.getChildren().clear();
        rightGrid.add(new Label("Item amount"), 0, 0);
        rightGrid.add(new Label("                                 "), 1, 0);
        rightGrid.add(new Label("       "), 2, 0);
        rightGrid.add(new Label("   "), 3, 0);
        rightGrid.add(new Label("                                  "), 4, 0);

        int lineY = 1;
        for (soldItems s : itemList)
        {
        rightGrid.add(new Label(s.getName()), 0, lineY);
        rightGrid.add(new Label(Integer.toString(s.getQuantity())), 1, lineY);
        rightGrid.add(new Label(Integer.toString(s.getTotalPrice() * s.getQuantity())), 2, lineY);
        Button buttonPlus = new Button("+");
        buttonPlus.setOnAction(event -> {
            s.setQuantity(s.getQuantity() + 1);
            updateRightGrid();
        });
            /*buttonPlus.setStyle("-fx-background-color:rgb(255,181,81);" +
                    "fx-border-color: blue;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-width: 3;" +
                    "-fx-border-style: solid;");*/
        rightGrid.add(buttonPlus, 3, lineY);
        Button buttonMinus = new Button("-");
        buttonMinus.setOnAction(event -> {
            if (s.getQuantity() > 0)
                s.setQuantity(s.getQuantity() - 1);
            updateRightGrid();
        });
           /* buttonMinus.setStyle("-fx-background-color:rgb(255,181,81);" +
                    "fx-border-color: blue;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-width: 3;" +
                    "-fx-border-style: solid;");*/
        rightGrid.add(buttonMinus, 4, lineY);
        lineY += 1;
    }

        rightGrid.add(new Label("               "), 0, lineY);
        lineY += 1;
        rightGrid.add(new Label("Subtotal:"), 0, lineY);
        //Calculate total price
        int totalPrice =  0;
        for (soldItems s : itemList)
        {
            totalPrice += s.getQuantity() * s.getTotalPrice();
        }
        rightGrid.add(new Label(Integer.toString(totalPrice)), 2, lineY);

        Button payButton = new Button("Pay");
        payButton.setOnAction(event -> {
            updateRightGridPaymentScreen();
        });
        rightGrid.add(payButton, 2, lineY + 1);
        //lineY += 1;
        //rightGrid.getColumnConstraints().add(new ColumnConstraints(400));



    }
    private void updateRightGridPaymentScreen()
    {
        //Set all the buttons uneditable
        for (Button b : buttonList)
        {
            b.setDisable(true);
        }
        rightGrid.getChildren().clear();
        rightGrid.add(new Label("Payment successful:"), 0, 0);
        rightGrid.add(new Label("                                 "), 1, 0);
        rightGrid.add(new Label("       "), 2, 0);
        rightGrid.add(new Label("   "), 3, 0);
        rightGrid.add(new Label("                                  "), 4, 0);

        int lineY = 1;
        for (soldItems s : itemList)
        {
            rightGrid.add(new Label(s.getName()), 0, lineY);
            rightGrid.add(new Label(Integer.toString(s.getQuantity())), 1, lineY);
            rightGrid.add(new Label(Integer.toString(s.getTotalPrice() * s.getQuantity())), 2, lineY);
            lineY += 1;
        }

        rightGrid.add(new Label("               "), 0, lineY);
        lineY += 1;
        rightGrid.add(new Label("Subtotal:"), 0, lineY);
        //Calculate total price
        int totalPrice =  0;
        for (soldItems s : itemList)
        {
            totalPrice += s.getQuantity() * s.getTotalPrice();
        }
        rightGrid.add(new Label(Integer.toString(totalPrice)), 2, lineY);
        Button okButton = new Button("Ok");
        okButton.setOnAction(event -> {
            itemList.clear();
            updateRightGrid();
        });
        rightGrid.add(okButton, 2, lineY+1);
        //lineY += 1;
        //rightGrid.getColumnConstraints().add(new ColumnConstraints(400));

    }
}
