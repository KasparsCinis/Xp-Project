package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.util.ArrayList;

/**
 * Created by krist on 25/02/2016.
 */
public class MainAdminScene {
    Stage window = new Stage();
    TableView<Activity> activityTableView;
    public void display(Stage primaryStage){
        window.setTitle("Adventure something");
        TableColumn<Activity, String> activityColumn2 = new TableColumn<>("ID");
        activityColumn2.setMinWidth(50);
        activityColumn2.setCellValueFactory(new PropertyValueFactory<>("idActivity"));

        TableColumn<Activity, String> activityColumn = new TableColumn<>("Activity");
        activityColumn.setMinWidth(240);
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        activityTableView = new TableView<>();
        activityTableView.setItems(getActivity());
        activityTableView.getColumns().add(activityColumn2);
        activityTableView.getColumns().add(activityColumn);


        Button homeButton = new Button("Home");

        Button newButton = new Button("New");
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("com/Logo2.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(80);
        iv1.setFitHeight(50);
        layout.setTop(iv1);
        HBox hBox = new HBox();
        hBox.getChildren().add(iv1);
        hBox.setAlignment(Pos.TOP_LEFT);
        layout.setTop(hBox);
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll( homeButton, newButton);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.BOTTOM_LEFT);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(hBox1);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(activityTableView);
        layout.setBottom(gridPane);
        layout.setCenter(hBox2);
        Scene scene = new Scene(layout, 600, 500);
        window.setScene(scene);


        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                View view = new View();

                Stage window2 = new Stage();
                view.start(primaryStage);
            }
        });
       // window.show();
    }
   public ObservableList<Activity> getActivity(){
       ModelClass modelClass = new ModelClass();
       ArrayList<Activity> list = new ArrayList<>();
       ObservableList<Activity> activities = FXCollections.observableArrayList();

       list = modelClass.getDBactivities();

       for (Activity a: list)
       {
           activities.add(a);
           System.out.println(a.toString());
       }

       return activities;
    }


}
