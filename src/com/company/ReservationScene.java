package com.company;

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

/**
 * Created by Donika on 3/1/2016.
 */
public class ReservationScene {

    ArrayList<Reservation2> activities = new ArrayList<>();

    public ArrayList<ActivitiesInReservation> getActivitiesInReservationArrayList() {
        return activitiesInReservationArrayList;
    }

    ArrayList<ActivitiesInReservation> activitiesInReservationArrayList= new ArrayList<>();
    public void setActivitiesInReservationArrayList(ArrayList<ActivitiesInReservation> activitiesInReservationArrayList) {
        this.activitiesInReservationArrayList = activitiesInReservationArrayList;
    }


    ObservableList<String> instructorsList =
            FXCollections.observableArrayList(

            );


    //ActivityInfoWindow a;
    Button date = new Button();
    ComboBox instructors;

    public void setActivitiesAndTime(String activitiesAndTime) {
        this.activitiesAndTime.setText(activitiesAndTime);
    }

    TextArea activitiesAndTime = new TextArea();
    TextField customerName = new TextField();
    TextField phoneNumber = new TextField();
    TextField numberOfPeople = new TextField();
    TextArea commentArea = new TextArea();
    VBox vBox;
    HBox imgHBox;
    Stage window = new Stage();

    Button homeButton;
    Button newButton;
    Button deleteButton; //clear textFields button
    Button saveButton;
    Button deleteButton2;
    ArrayList<Instructor> instructorList = new ArrayList<>();

    Label editLabel = new Label("EDIT: ");
    Label notificationLabel = new Label();

    String intID;
    int resId;

    ModelClass modelClass = new ModelClass();
    TableView<Reservation2> activityTableView;


    public String getDate() {
        return date.getText().toString();
    }
    public int getNrOfPeople(){return Integer.valueOf(numberOfPeople.getText().toString());}
    public String getInstructor() {return instructors.getValue().toString();}
    public void setDate(String nameText) {
        date.setText(nameText);
    }
    public String getCommentArea() {
        return commentArea.getText().toString();
    }
    public void setCommentArea(String description) {
        commentArea.setText(description);
    }


    public String getCustomerName() {
        if(customerName.getText().toString()!=""){
            return customerName.getText().toString();
        }
        return null;
    }
    public void setCustomerName(String customerName) {
        this.customerName.setText( String.valueOf(customerName));
    }
    public int getPhoneNumber() {
        //check if it's a int first?
        return Integer.valueOf(phoneNumber.getText().toString());
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.setText(String.valueOf(phoneNumber));
    }

    public boolean validate()
    {
        boolean result=true;
        if(getDate().toString().equals("")) {
            result = false;
        }
//        if(getInstructor().equals(""))
//        {
//            result = false;
//        }
        if(getCommentArea().equals("")) {
            result = false;
        }
        if(customerName.getText().toString().equals(""))
        {
            result = false;
        }
        if(phoneNumber.getText().toString().equals("")) {
            result = false;
        }
        return result;
    }
    //    public boolean validateType()
//    {
//        try{
//            Integer.valueOf(customerName.getText().toString()) ;
//            Double.valueOf(phoneNumber.getText().toString());
//        }catch (NumberFormatException nfe){
//            return false;
//        }
//        return true;
//    }
    public void display(Stage primaryStage){
        vBox = new VBox();


        window.setTitle("Adventure reservation");
        TableColumn<Reservation2, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(50);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        TableColumn<Reservation2, String> activityColumn = new TableColumn<>("Activity");
        activityColumn.setMinWidth(100);
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("idActivity"));
        TableColumn<Reservation2, String> customerColumn = new TableColumn<>("Customer");
        customerColumn.setMinWidth(100);
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        TableColumn<Reservation2, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setMinWidth(100);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("customerMobilePhone"));
        // activityColumn.setCellValueFactory(new PropertyValueFactory<>("cName"));
        TableColumn<Reservation2, String> nrOfPeopleColumn = new TableColumn<>("No of ppl");
        nrOfPeopleColumn.setMinWidth(20);
        nrOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPeople"));
        TableColumn<ActivitiesInReservation, String> time = new TableColumn<>("No of ppl");
        nrOfPeopleColumn.setMinWidth(20);
        nrOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPeople"));
        activityTableView = new TableView<>();

        activityTableView.setItems(getReservationsList());

        activityTableView.getColumns().add(timeColumn);
        activityTableView.getColumns().add(activityColumn);
        activityTableView.getColumns().add(customerColumn);
        activityTableView.getColumns().add(nrOfPeopleColumn);
        activityTableView.getColumns().add(phoneColumn);

        activityTableView.setRowFactory(activityTableView-> {
            TableRow<Reservation2> row = new TableRow<Reservation2>();
            row.setOnMouseClicked(event -> {if (event.getClickCount() ==1&&(! row.isEmpty())){
                editLabel.setText("EDIT: ");
                Reservation2 rowData = row.getItem();
                System.out.println(rowData);
                date.setText(row.getText());
                customerName.setText(String.valueOf(rowData.getCustomerName()));
                phoneNumber.setText(String.valueOf(rowData.getCustomerMobilePhone()));
                numberOfPeople.setText(String.valueOf(rowData.getNumberOfPeople()));
                commentArea.setText(rowData.getComment());


                resId = rowData.getIdReservation();
            }
            });
            return row;
        });









        //instructorsList.addAll(modelClass.getDBInstructors().get(0).getName());

        instructors = new ComboBox(instructorsList);
        instructors.setPromptText("click for instructors");


        homeButton = new Button("Back");
        newButton = new Button("New");
        newButton.setOnAction(event -> {
            editLabel.setText("NEW: ");
            clearTextFieldsReservation();

            // a = new ActivityInfoWindow();
            //a.start(primaryStage);
            //vBox.setVisible(false);
        });
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("com/company/images/Logo2.jpg");
        javafx.scene.image.Image calendarImg = new javafx.scene.image.Image("com/company/images/cal.jpg");

        layout.getStylesheets().add("com/company/style.css");


        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();

        iv2.setId("calendarIconStyle");

        iv1.setImage(image);
        iv1.setFitWidth(80);
        iv1.setFitHeight(50);
        iv1.setVisible(true);
        layout.setTop(iv1);

        iv2.setImage(calendarImg);
        iv2.setFitWidth(80);
        iv2.setFitHeight(50);
        layout.setTop(iv2);
        iv2.setVisible(true);



        imgHBox = new HBox(200);
        imgHBox.getChildren().addAll(iv1, iv2);
        imgHBox.setPadding(new Insets(0,0,5,0));
        GridPane gridPane;

        //notification label

        iv2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
               CalendarTable calendarTable= new CalendarTable();
               calendarTable.start();
                primaryStage.close();

                //iv2.setImage(null);
            }
        });

        deleteButton2 = new Button("Delete");
        deleteButton2.setOnAction(event ->{
                    modelClass.deleteDBReservation(resId);
                    modelClass.deleteActivityReserv(resId);
                    clearTextFieldsReservation();
                    notificationLabel.setText("Reservation successfully deleted");
                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();

                }
        );

        gridPane = new GridPane();
        HBox homeNewDeleteBtnHBox = new HBox();
        gridPane.getChildren().add(homeNewDeleteBtnHBox);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(gridPane, notificationLabel);

        notificationLabel.setTranslateX(250);
        notificationLabel.setStyle("-fx-font-size: 20");
        notificationLabel.setVisible(true);


        homeNewDeleteBtnHBox.getChildren().addAll( homeButton, newButton, deleteButton2);
        homeNewDeleteBtnHBox.setSpacing(10);
        homeNewDeleteBtnHBox.setAlignment(Pos.BOTTOM_LEFT);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(activityTableView);
        layout.setBottom(hBox);
        layout.setCenter(hBox2);
        layout.setTop(imgHBox);





        editLabel.setFont(new Font("Serif",30));

//        HBox nameHBox = new HBox();
//        HBox descriptionHBox = new HBox();
//        HBox priceHBox= new HBox();
//        HBox ageLimitHBox= new HBox();
        HBox deleteSaveHBox= new HBox();
        vBox.getChildren().addAll(deleteSaveHBox); //nameHBox,descriptionHBox,priceHBox,ageLimitHBox,
        //Scene scene = new Scene(vBox, 300,300);


        Label dateLabel = new Label("Date: ");
        Label instructorLabel = new Label("Instructor: ");
        Label actAndTimeLabel = new Label("Activity & time: ");
        Label cNameLabel = new Label("Customer name: ");
        Label phoneLabel = new Label("Phone number: ");
        Label nrOfPeopleLabel = new Label("Number of people: ");
        Label commentLabel = new Label("Comment: ");

        instructors.setPrefSize(187,100);
        instructors.setPrefSize(187,100);
        activitiesAndTime.setPrefSize(187,100);
        commentArea.setPrefSize(187,100);
        dateLabel.setPrefHeight(65);
        instructorLabel.setTranslateY(-13);
        actAndTimeLabel.setTranslateY(-3);
        cNameLabel.setTranslateY(80);
        phoneLabel.setTranslateY(90);
        nrOfPeopleLabel.setTranslateY(100);
        commentLabel.setTranslateY(110);
        VBox labelVbox = new VBox(dateLabel,instructorLabel,actAndTimeLabel,cNameLabel,phoneLabel,nrOfPeopleLabel,commentLabel);
        VBox textfieldsVbox = new VBox(editLabel, date,instructors, activitiesAndTime, customerName, phoneNumber, numberOfPeople,commentArea, vBox); ////////*******

        HBox labelandtextField = new HBox(labelVbox, textfieldsVbox);
        labelandtextField.setPadding(new Insets(20, 10, 10, 50));
        labelandtextField.setSpacing(10);

        deleteButton = new Button("Clear");
        saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);
        deleteButton.setOnAction(event ->{

                    clearTextFieldsReservation();
                    notificationLabel.setVisible(true);
                    notificationLabel.setText("Cleared successful!");
                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                    editLabel.setText("EDIT: ");
                }
        );
        instructors.setMinSize(200, 10);
        instructors.setMaxSize(200, 30);
        date.setMinWidth(200);
        date.setText("click for calendar");
        date.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CalendarTable calendarTable= new CalendarTable();
                calendarTable.start();
                //primaryStage.hide();
                System.out.println("Calendar opens");
            }
        });
        //System.out.println(activities.get(0).getName());
        saveButton.setOnAction(event -> {
            if (validate()) {
                String date = getDate();
                String instructor = getInstructor();
                List activity = getActivity();
                String cName = getCustomerName();
                int phone = getPhoneNumber();
                int nrPeople = getNrOfPeople();
                String comment = getCommentArea();
                //int time = 11;
                int idOfInstructor=0;
                for (Instructor a : instructorList)
                {
                    if(a.getName().equals(instructor)){
                        idOfInstructor=a.getIdInstructor();
                    }
                }
                ModelClass modelClass = new ModelClass();
                if (editLabel.getText().equals("NEW: "))
                {
                    modelClass.writeToDBReservation(activitiesInReservationArrayList, idOfInstructor, getDate(), getCustomerName(), String.valueOf(getPhoneNumber()), getNrOfPeople(), String.valueOf(getCommentArea()));
                }else if (editLabel.getText().equals("EDIT: "))
                {
                    modelClass.updateDBReservation(activitiesInReservationArrayList, idOfInstructor, resId, getDate(), getCustomerName(), String.valueOf(getPhoneNumber()), getNrOfPeople(), String.valueOf(getCommentArea()));
                }                System.out.println("Hi............");

                display(primaryStage);
                primaryStage.setScene(window.getScene());

                if (editLabel.getText().equals("EDIT: ")) {
                    // modelClass.updateDBreservations();
                    notificationLabel.setText("Reservation edit successful!");

                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(2000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                }

                if (editLabel.getText().equals("NEW: ")) {
                    //  modelClass.writeToDBReservation(1,1,1,"","","",1,"");
                    notificationLabel.setText("Activity added successful!");
                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(5000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                }
            }
            else if (validate()) {
                System.out.println("wrong type");
            } else {
                System.out.println("fill the fields");
            }

        });


        layout.setRight(labelandtextField);
        Scene scene = new Scene(layout, 800, 600);
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
        //ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = new ArrayList<>();
        ObservableList<Activity> activities2 = FXCollections.observableArrayList();
        list = modelClass.getDBactivities();
        for (Activity a: list)
        {
            //activities.add(a);
            activities2.add(a);
            System.out.println(a.toString());
        }
        return activities2;
    }

    public ObservableList<Reservation2> getReservationsList(){
        //ModelClass modelClass = new ModelClass();
        List<Reservation2> list = modelClass.getDBReservations();

        ObservableList<Reservation2> reservationObservableList = FXCollections.observableArrayList(list);


        for (Reservation2 r: list)
        {
            //activities.add(r);
            reservationObservableList.add(r);
            System.out.println(r.toString());
        }
        return reservationObservableList;
    }

    public ObservableList<ActivitiesInReservation> getActivitiesInReservation(){
        //ModelClass modelClass = new ModelClass();
        List<ActivitiesInReservation> list = new ArrayList<>();
        ObservableList<ActivitiesInReservation> activities2 = FXCollections.observableArrayList();
        list = modelClass.getDBActivitiesInReservation(0);
        for (ActivitiesInReservation a: list)
        {
            //activities.add(a);
            activities2.add(a);
            System.out.println(a.toString());
        }
        return activities2;
    }


    public void clearTextFieldsReservation()
    {
        date.setText("click for calendar");
        activitiesAndTime.clear();
        //instructor.clear();
        customerName.clear();
        phoneNumber.clear();
        numberOfPeople.clear();
        commentArea.clear();
    }
    public void refreshInstructors(){
        ArrayList<Integer> idsOfActivities= new ArrayList<>();
        for (ActivitiesInReservation kk: activitiesInReservationArrayList){
            idsOfActivities.add(kk.getIdActivity());

        }
        instructorList= modelClass.getDBInstructorsByActivity(idsOfActivities);
        for (Instructor a : instructorList)
        {
            instructorsList.addAll(a.getName());
        }
    }
}