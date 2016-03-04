package com.company;

/**
 * Created by katrinahitchcock on 04/03/16.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;




public class KioskScene  {



    Stage window = new Stage();


    public void display(Stage primaryStage) {

        window.setTitle("Kiosk");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getStylesheets().add("com/company/style.css");


        primaryStage.setScene(window.getScene());
        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        display(primaryStage);
        window.show();




       // javafx.scene.image.Image image = new javafx.scene.image.Image("com/company/images/Logo2.jpg");

        //window.getStylesheets().add("com/company/style.css");



    }
}
