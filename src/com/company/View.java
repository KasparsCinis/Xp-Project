package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Created by Donika on 2/25/2016.
 */
public class View extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 500, 500);


        Button manageBtn = new Button("Manage activity");
        Button reserveBtn = new Button("Make reservation");


        manageBtn.setMinHeight(200);
        manageBtn.setMinWidth(200);
        reserveBtn.setMinHeight(200);
        reserveBtn.setMinWidth(200);




        grid.setGridLinesVisible(true);

        grid.setPadding(new Insets(50, 20, 20, 50));
        //grid.setMargin(new Insets());
        grid.add(manageBtn, 1, 1);
        grid.add(reserveBtn, 4, 1);



        primaryStage.setTitle("Adventure parks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
