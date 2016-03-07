package com.company;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CalendarTable {

    ArrayList<Button> arrayListOfButton = new ArrayList<>();
    ArrayList<Activity> list = new ArrayList<>();
    private TableView table = new TableView();
    String currentDate; // create a getter for current date later to be passed to the reservationi
    ArrayList<ActivitiesInReservation> reservations = new ArrayList<>();//// this array will store all the activities with the beginning and end time

    public ArrayList<ActivitiesInReservation> getReservationsWithStartEnd() {
        return reservationsWithStartEnd;
    }

    ArrayList<ActivitiesInReservation> reservationsWithStartEnd = new ArrayList<>(); // array that will store id start and ending time
    int minH = 23;// for finding the starting and ending hour
    int maxH = 0;// for finding the starting and ending hour
    int index = 0;// for finding the starting and ending hour
    OpenDatePicker openDatePicker = new OpenDatePicker();
    ModelClass modelClass= new ModelClass();

    public void start() {


        Stage stage = new Stage();
        //Scene scene = new Scene();
        stage.setTitle("Table View Sample");
        stage.setWidth(800);
        stage.setHeight(600);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date= new Date();
        currentDate = dateFormat.format(date);

        //ArrayList<Reservation2> reservation2s = new ArrayList<>();

        openDatePicker.setOnAction(event1 -> {

            updateButtons();


        });
        Button backButton = new Button("Back");
        backButton.setOnAction(event1 -> {
            stage.close();
        });
        Button bookButton = new Button("Book");
        ArrayList<Integer> activityIdList = new ArrayList<>();

        for (Activity id:modelClass.getDBactivities())
            activityIdList.add(Integer.valueOf(id.getIdActivity()));
        /*activityIdList.add(5);
        activityIdList.add(3);
        activityIdList.add(73);*/


        bookButton.setOnAction(event1 -> {
            /*HashMap<Integer, ArrayList<Integer>> minMax= new HashMap<>();*/
            System.out.println("gowno");
            while (index < activityIdList.size()) {
                for (ActivitiesInReservation reservation : reservations) {
                    if (activityIdList.get(index) == reservation.getIdActivity()) {
                        if (reservation.getStartTime() < minH)
                            minH = reservation.getStartTime();
                        if (reservation.getStartTime() > maxH)
                            maxH = reservation.getStartTime();


                    }


                }
                if (minH != 23 && maxH != 0)
                    reservationsWithStartEnd.add(new ActivitiesInReservation(activityIdList.get(index), minH, maxH));
                index++;
                minH = 23;
                maxH = 0;


            }

            /** Test */
            ReservationScene reservationScene= new ReservationScene();
            reservationScene.display(stage);

            stage.show();
            reservationScene.display(stage);
            StringBuilder reservationsss= new StringBuilder();
            reservationScene.setActivitiesInReservationArrayList(reservationsWithStartEnd);
            for (ActivitiesInReservation reservation : reservationsWithStartEnd) {
                System.out.println(reservation.getIdActivity() + " from " + reservation.getStartTime() + " to " + reservation.getEndTime());
                String nameOfActivity=modelClass.getDBactivities2(String.valueOf(reservation.getIdActivity())).getName();
                reservationsss.append(nameOfActivity + ": " + reservation.getStartTime() + ":00-" + reservation.getEndTime() + ":00\n");
            }
            reservationScene.setActivitiesAndTime(reservationsss.toString());
            /** Test */


            reservationScene.setDate(currentDate);
            reservationScene.refreshInstructors();
            stage.setScene(reservationScene.window.getScene());

        });
        HBox bookBackCalendarHbox = new HBox();
        bookBackCalendarHbox.getChildren().addAll(openDatePicker, backButton, bookButton);


        ArrayList<String> ArrayIdColumn = new ArrayList<String>();

        ModelClass modelClass = new ModelClass();
        list = modelClass.getDBactivities();

        VBox root = new VBox();


        GridPane gridpane = new GridPane();
        //scroll.setContent(gridpane);
        gridpane.getColumnConstraints().add(new ColumnConstraints(100));
        gridpane.getRowConstraints().add(new RowConstraints(50));
        //Make the table full of buttons!

        for (int i = 10; i <= 22; i++) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Button button = new Button();
                button.setId(i + " " + list.get(i2).getIdActivity());
                arrayListOfButton.add(button);
                button.setPrefWidth(100);
                gridpane.add(button, i2 + 1, i + 1);

                button.setOnAction(event -> {
                    button.setStyle("-fx-base: #00b300");
                    System.out.println(currentDate + " " + button.getId());
                    String[] splited = button.getId().split("\\s+");
                    int startTime = Integer.valueOf(splited[0]);
                    int reservationNumber = Integer.valueOf(splited[1]);
                    ActivitiesInReservation activitiesInReservation = new ActivitiesInReservation(reservationNumber, startTime);
                    reservations.add(activitiesInReservation);


                });
            }
        }

        updateOnStartButtons();
        for (int i = 0; i < list.size(); i++) {
            Label label = new Label();
            //Button button = new Button();

            label.setPrefWidth(100);
            //button.setStyle("-fx-width:150px;");
            label.setText(list.get(i).getName());
            ArrayIdColumn.add(list.get(i).getIdActivity());
            gridpane.add(label, i + 1, 0);
        }
        for (int i = 10; i <= 22; i++) {
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


        /*ArrayList<Reservation2> listRes = modelClass.getDBReservationsOnDay("12/12/2014");

        for (int i = 0; i < listRes.size(); i++) {
            //Add the reservation to the table
            Button button = new Button();
            button.setPrefWidth(100);
            button.setText(Integer.toString(listRes.get(i).getIdInstructor()));
            button.setStyle("-fx-background-color:green;");
            //int time = listRes.get(i).getTime();
            int column = 0;
            //Search for the correct column
            // System.out.println(ArrayIdColumn.get(listRes.get(i).getIdActivity()));
            // System.out.println(listRes.get(i).getIdActivity());
            for (int i2 = 0; i2 < ArrayIdColumn.size(); i2++) {
                if (Integer.toString(listRes.get(i).getIdActivity()).equals(ArrayIdColumn.get(i2)))
                    column = i2 + 1;
            }
            gridpane.add(button, column, 12); // 12 is temporary after not working getTime() method
            //gridpane.add(button, column, time);

            String text = Integer.toString(listRes.get(i).getIdActivity());
            button.setOnAction(event -> {

                System.out.println(text);
            });
        }*/


        gridpane.setPadding(new Insets(200, 0, 0, 0));

        Scene scene = new Scene(gridpane, 300, 300);
        //gridpane.getChildren().addAll(scroll);
        Label label = new Label();
        // GridPane.setConstraints(label, 3, 1); // column=3 row=1
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridpane);
        root.getChildren().addAll(bookBackCalendarHbox, scrollPane);
        scene.setRoot(root);


        stage.setScene(scene);
        stage.show();
        openDatePicker.show();
    }

    private void updateOnStartButtons() {
        ArrayList<ActivitiesInReservation> listOfActivitiesAndTimes= new ArrayList<ActivitiesInReservation>();
            /*listOfActivitiesAndTimes.add(new ActivitiesInReservation(3, 10));
            listOfActivitiesAndTimes.add(new ActivitiesInReservation(5, 15));
            listOfActivitiesAndTimes.add(new ActivitiesInReservation(5, 12));*/
        System.out.println(currentDate);
        listOfActivitiesAndTimes= getStartEndIdFromReservations(currentDate);///this will be here instead of the one on top
        ArrayList<ActivitiesInReservation> ultimateList= new ArrayList<>();
        for(ActivitiesInReservation r:listOfActivitiesAndTimes){
            for (int times=r.getStartTime(); times<=r.getEndTime();times++){
                ultimateList.add(new ActivitiesInReservation(r.getIdActivity(),times));
            }}

        //listOfActivitiesAndTimes= getStartEndIdFromReservations(currentDate);
        // method that will get all the boookings from the database and update the activities calendar (also colors)
        // make all the buttons gray
        for (int i = 0; i < arrayListOfButton.size(); i++) {
            arrayListOfButton.get(i).setStyle("-fx-background-color:gainsboro;");
            for(ActivitiesInReservation r:ultimateList){
                //System.out.println(arrayListOfButton.get(i).getId()+"compaer with"+r.getStartTime()+" "+r.getIdActivity() );
                if(arrayListOfButton.get(i).getId().equals(r.getStartTime()+" "+r.getIdActivity())){
                    arrayListOfButton.get(i).setStyle("-fx-background-color: green");

                }}

        }
    }


    private void updateButtons() {
        ArrayList<ActivitiesInReservation> listOfActivitiesAndTimes= new ArrayList<ActivitiesInReservation>();
            /*listOfActivitiesAndTimes.add(new ActivitiesInReservation(3, 10));
            listOfActivitiesAndTimes.add(new ActivitiesInReservation(5, 15));
            listOfActivitiesAndTimes.add(new ActivitiesInReservation(5, 12));*/
        System.out.println(openDatePicker.getValue());
        currentDate = String.valueOf(openDatePicker.getValue());
        String[] splited = currentDate.split("-");
        currentDate=splited[2]+"/"+splited[1]+"/"+splited[0];
        listOfActivitiesAndTimes= getStartEndIdFromReservations(currentDate);///this will be here instead of the one on top
        listOfActivitiesAndTimes.add(new ActivitiesInReservation(5, 15,20));
        listOfActivitiesAndTimes.add(new ActivitiesInReservation(3, 16,18));
        ArrayList<ActivitiesInReservation> ultimateList= new ArrayList<>();
        for(ActivitiesInReservation r:listOfActivitiesAndTimes){
            for (int times=r.getStartTime(); times<=r.getEndTime();times++){
                ultimateList.add(new ActivitiesInReservation(r.getIdActivity(), times));
            }}
        //listOfActivitiesAndTimes= getStartEndIdFromReservations(currentDate);
        // method that will get all the boookings from the database and update the activities calendar (also colors)
        // make all the buttons gray
        for (int i = 0; i < arrayListOfButton.size(); i++) {
            arrayListOfButton.get(i).setStyle("-fx-background-color:gainsboro;");
            for(ActivitiesInReservation r:ultimateList){


                //System.out.println(arrayListOfButton.get(i).getId()+"compaer with"+r.getStartTime()+" "+r.getIdActivity() );
                if(arrayListOfButton.get(i).getId().equals(r.getStartTime()+" "+r.getIdActivity())){
                    arrayListOfButton.get(i).setStyle("-fx-background-color: green");

                }}

        }
    }

    public ArrayList<ActivitiesInReservation> getStartEndIdFromReservations(String day){
        ModelClass model= new ModelClass();
        ArrayList<ActivitiesInReservation> returnList= new ArrayList<>();
        ArrayList<Reservation2> startEndIdList= model.getDBReservationsOnDay(day);

        for (Reservation2 r:startEndIdList){
            System.out.println(r.getIdActivity());
            returnList.addAll(model.getDBActivitiesInReservation(r.getIdReservation()));

        }
        return returnList;
    }

}