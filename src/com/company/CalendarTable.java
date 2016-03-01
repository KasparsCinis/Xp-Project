package com.company;

import com.company.Activity;
import com.company.ModelClass;
import com.company.Reservation;
import com.company.Reservation2;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CalendarTable extends Application {

    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Scene scene = new Scene();
        stage.setTitle("Table View Sample");
        stage.setWidth(1000);
        stage.setHeight(400);


        ArrayList<String> ArrayIdColumn = new ArrayList<String>();

        ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = modelClass.getDBactivities();

        VBox root = new VBox();


        GridPane gridpane = new GridPane();
        //scroll.setContent(gridpane);
        gridpane.getColumnConstraints().add(new ColumnConstraints(100));
        gridpane.getRowConstraints().add(new RowConstraints(50));
        //Make the table full of buttons!
        for (int i = 0; i <= 24; i++)
        {
            for (int i2 = 0; i2 < list.size(); i2 ++)
            {
                Button button = new Button();
                button.setPrefWidth(100);
                gridpane.add(button, i2 + 1, i+1);

                button.setOnAction(event -> {
                    System.out.println("yes?");
                });
            }
        }


        for (int i = 0; i < list.size(); i ++)
        {
            Label label = new Label();
            //Button button = new Button();

            label.setPrefWidth(100);
            //button.setStyle("-fx-width:150px;");
            label.setText(list.get(i).getName());
            ArrayIdColumn.add(list.get(i).getIdActivity());
            gridpane.add(label, i+1, 0);
        }
        for (int i = 0; i <= 24; i ++)
        {
            Label button = new Label();
            button.setStyle("fx-border-color: blue;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 3;\n"
                + "-fx-border-style: solid;\n"
                + "-fx-left: 15px;\n");
            button.setPadding(new Insets(0, 0, 0, 40));
            button.setPrefWidth(100);
            button.setText(Integer.toString(i));
            gridpane.add(button, 0, i + 1);
        }


        ArrayList<Reservation2> listRes = modelClass.getDBReservationsOnDay("12/12/2014");

        for (int i = 0; i < listRes.size(); i ++)
        {
            //Add the reservation to the table
            Button button = new Button();
            button.setPrefWidth(100);
            button.setText(Integer.toString(listRes.get(i).getIdInstructor()));
            button.setStyle("-fx-background-color:green;");
            int time = listRes.get(i).getTime();
            int column = 0;
            //Search for the correct column
           // System.out.println(ArrayIdColumn.get(listRes.get(i).getIdActivity()));
           // System.out.println(listRes.get(i).getIdActivity());
            for (int i2 = 0; i2 < ArrayIdColumn.size(); i2++)
            {
                if (Integer.toString(listRes.get(i).getIdActivity()).equals(ArrayIdColumn.get(i2)))
                    column = i2 +1;
            }
            gridpane.add(button, column, time);

            String text = Integer.toString(listRes.get(i).getIdActivity());
            button.setOnAction(event -> {

                System.out.println(text);
            });
        }


        Scene scene = new Scene(gridpane, 300, 300);
        //gridpane.getChildren().addAll(scroll);
        Label label = new Label();
       // GridPane.setConstraints(label, 3, 1); // column=3 row=1
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridpane);
        root.getChildren().addAll(scrollPane);
        scene.setRoot(root);


        stage.setScene(scene);
        stage.show();
    }
}