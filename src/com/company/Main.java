package com.company;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.util.ArrayList;

public class Main extends Application {

    /*  @Test //#1
    public void testDBinsertion()
    {
    ModelClass modelClass = new ModelClass();
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    }

    @Test //#2
    public void testDBupdate()
    {
        ModelClass modelClass = new ModelClass();
<<<<<<< HEAD
        ArrayList<Activity> list = new ArrayList<>();
        list = modelClass.getDBactivities();

=======
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
>>>>>>> origin/master

        modelClass.updateDB("testActivity", 15, 20, "This is an description", list.get(list.size()-1).getIdActivity());
    }

    @Test //#4
    public void testDBdelete()
    {
        ModelClass modelClass = new ModelClass();
<<<<<<< HEAD
        assertNotNull(modelClass.getDBactivities2("4").getName());
        //System.out.println(modelClass.getDBactivities2("2").toString());


=======
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
>>>>>>> origin/master
    }

    @Test //#5
    public void testDBretrieve()
    {
        ModelClass modelClass = new ModelClass();
<<<<<<< HEAD
        ArrayList<Activity> list = new ArrayList<>();
        list = modelClass.getDBactivities();


        modelClass.deleteDB(list.get(list.size() - 1).getIdActivity());
    }
=======
        modelClass.writeToDB("DD", 12, 25, "sdsd");
        assertEquals("DD", modelClass.toString());
    } */

>>>>>>> origin/master

    MainAdminScene m = new MainAdminScene();
    Stage window;
    Scene scene;

    @Before
    public void setUp() throws Exception {
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       /* window = primaryStage;
        Button button = new Button("button");
        button.setOnAction(event -> m.display());
        scene = new Scene(button, 500, 600);
        window.setScene(scene);
        window.show();*/

        View view = new View();

            view.start(primaryStage);


    }

}
