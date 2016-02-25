package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by krist on 25/02/2016.
 */
public class MainAdminScene {
    Stage window = new Stage();
    TableView<Activity> activityTableView;
    public void display(){
        window.setTitle("Adventure something");

       /* TableColumn<Activity, String> activityColumn = new TableColumn<>("Activity");
        activityColumn.setMinWidth(200);
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("activity"));
        activityTableView.setItems(getActivity());
        activityTableView.getColumns().add(activityColumn);*/
        Button newButton = new Button("New");
        Button homeButton = new Button("Home");
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("Logo.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(80);
        iv1.setFitHeight(40);
        layout.setTop(iv1);
        HBox hBox = new HBox();
        hBox.getChildren().add(iv1);
        hBox.setAlignment(Pos.TOP_LEFT);
        layout.setTop(hBox);
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(newButton, homeButton);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.BOTTOM_LEFT);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(hBox1);
        layout.setBottom(gridPane);
        Scene scene = new Scene(layout, 600, 500);
        window.setScene(scene);
        window.show();
    }
   /* public ObservableList<Activity> getActivity(){
        ObservableList<Activity> activities = FXCollections.observableArrayList();
        activities.add(new Activity("Killing yourself"));
        return activities;
    }*/


}
