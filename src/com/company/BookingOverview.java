package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Kuba on 2016-03-01.
 */
public class BookingOverview extends Application{

    ArrayList<String> list= new ArrayList<>();
    ObservableList<Reservation> data = FXCollections.observableArrayList(
            new Reservation(11, "Jlo"),
            new Reservation(12, "Jlo"),
            new Reservation(13, "Jlo"),
            new Reservation(14, "Jlo"),
            new Reservation(15, "Jlo"),
            new Reservation(16, "Jlo"),
            new Reservation(17, "Jlo"),
            new Reservation(18, "Jlo"),
            new Reservation(19, "Jlo"),
            new Reservation(20, "Jlo"),
            new Reservation(21, "Jlo"),
            new Reservation(22, "Jlo")

    );

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane= new GridPane();

        list.add("elo");
        list.add("sks");

        TableView<Reservation> table = new TableView<Reservation>();
       table.setItems(data);

        TableColumn<Reservation, Integer> timeColumn = new TableColumn<Reservation, Integer>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("time"));
        table.getColumns().add(timeColumn);
        for (String s: list){
            TableColumn<Reservation, String> activityColumn= new TableColumn<>(s);
            System.out.println(s.toLowerCase());
            activityColumn.setCellValueFactory(new PropertyValueFactory<Reservation, String>(s.toLowerCase()));
            table.getColumns().add(activityColumn);
        }



        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        gridPane.add(table, 1, 1);
        Scene scene= new Scene(gridPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
