package com.company;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Donika on 3/1/2016.
 */
public class ReservationScene {

    ArrayList<Activity> activities = new ArrayList<>();
    ActivityInfoWindow a;
    TextField date = new TextField();
    TextField activitiesAndTime = new TextField();
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


    Label editLabel;

    String intID;
    ModelClass modelClass = new ModelClass();
    TableView<Activity> activityTableView;
    public String getDate() {
        return date.getText().toString();
    }
    public void setDate(String nameText) {
        date.setText(nameText);
    }
    public String getCommentArea() {
        return commentArea.getText().toString();
    }
    public void setCommentArea(String description) {
        commentArea.setText(description);
    }


    public int getCustomerName() {
        if(customerName.getText().toString()!=""){
            return Integer.valueOf(customerName.getText().toString());
        }
        return 0;
    }
    public void setCustomerName(int customerName) {
        this.customerName.setText( String.valueOf(customerName));
    }
    public Double getPhoneNumber() {
        //check if it's a double first?
        return Double.valueOf(phoneNumber.getText().toString());
    }
    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber.setText(String.valueOf(phoneNumber));
    }
    public void alertMessage(){
        Alert noname = new Alert(Alert.AlertType.ERROR);
        noname.setContentText("Error Message");
        noname.showAndWait();
    }
    public boolean validate()
    {
        boolean result=true;
        if(getDate().equals("")) {
            result = false;
        }
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
    public boolean validateType()
    {
        try{
            Integer.valueOf(customerName.getText().toString()) ;
            Double.valueOf(phoneNumber.getText().toString());
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    public void display(Stage primaryStage){
        vBox = new VBox();


        window.setTitle("Adventure reservation");
        TableColumn<Activity, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(50);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        TableColumn<Activity, String> activityColumn = new TableColumn<>("Activity");
        activityColumn.setMinWidth(100);
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Activity, String> customerColumn = new TableColumn<>("Customer");
        customerColumn.setMinWidth(100);
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Activity, String> nrOfPeopleColumn = new TableColumn<>("No of ppl");
        nrOfPeopleColumn.setMinWidth(20);
        nrOfPeopleColumn.setCellValueFactory(new PropertyValueFactory<>("nrOfPeople"));
        activityTableView = new TableView<>();
        activityTableView.setItems(getActivity());
        activityTableView.getColumns().add(timeColumn);
        activityTableView.getColumns().add(activityColumn);
        activityTableView.getColumns().add(customerColumn);
        activityTableView.getColumns().add(nrOfPeopleColumn);

        activityTableView.setRowFactory(activityTableView-> {
            TableRow<Activity>row = new TableRow<Activity>();
            row.setOnMouseClicked(event -> {if (event.getClickCount() ==1&&(! row.isEmpty())){
                editLabel.setText("EDIT");
                Activity rowData = row.getItem();
                System.out.println(rowData);
                date.setText(rowData.getName());
                customerName.setText(String.valueOf(rowData.getAgeLimit()));
                phoneNumber.setText(String.valueOf(rowData.getPrice()));
                commentArea.setText(rowData.getDescription());


                intID = rowData.getIdActivity();
            }
            });
            return row;
        });
        homeButton = new Button("Back");
        newButton = new Button("New");
        newButton.setOnAction(event -> {
            editLabel.setText("NEW: ");
            date.clear();
            commentArea.clear();
            phoneNumber.clear();
            customerName.clear();

            // a = new ActivityInfoWindow();
            //a.start(primaryStage);
            //vBox.setVisible(false);
        });
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("com/Logo2.jpg");
        javafx.scene.image.Image calendarImg = new javafx.scene.image.Image("com/cal.jpg");

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

        iv2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Img was clicked");

                //iv2.setImage(null);
            }
        });

        deleteButton2 = new Button("Delete");
        deleteButton2.setOnAction(event ->{
                    modelClass.deleteDBActivity(intID);
                    activityTableView.setItems(getActivity());
                }
        );

        HBox homeNewDeleteBtnHBox = new HBox();
        homeNewDeleteBtnHBox.getChildren().addAll( homeButton, newButton, deleteButton2);
        homeNewDeleteBtnHBox.setSpacing(10);
        homeNewDeleteBtnHBox.setAlignment(Pos.BOTTOM_LEFT);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(homeNewDeleteBtnHBox);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(activityTableView);
        layout.setBottom(gridPane);
        layout.setCenter(hBox2);
        layout.setTop(imgHBox);

        editLabel = new Label("EDIT: ");
        editLabel.setFont(new Font("Serif",30));

//        HBox nameHBox = new HBox();
//        HBox descriptionHBox = new HBox();
//        HBox priceHBox= new HBox();
//        HBox ageLimitHBox= new HBox();
        HBox deleteSaveHBox= new HBox();
        vBox.getChildren().addAll(deleteSaveHBox); //nameHBox,descriptionHBox,priceHBox,ageLimitHBox,
        //Scene scene = new Scene(vBox, 300,300);
        Label dateLabel = new Label("Date: ");
        Label actAndTimeLabel = new Label("Activity & time: ");

        Label cNameLabel = new Label("Customer name: ");
        Label phoneLabel = new Label("Phone number: ");
        Label nrOfPeopleLabel = new Label("Number of people: ");
        Label commentLabel = new Label("Comment: ");
        commentArea.setPrefSize(187,100);
        dateLabel.setPrefHeight(115);
        actAndTimeLabel.setTranslateY(-35);
        cNameLabel.setTranslateY(-25);
        phoneLabel.setTranslateY(-15);
        nrOfPeopleLabel.setTranslateY(-5);
        commentLabel.setTranslateY(3);
        VBox labelVbox = new VBox(dateLabel,actAndTimeLabel,cNameLabel,phoneLabel,nrOfPeopleLabel,commentLabel);
        VBox textfieldsVbox = new VBox(editLabel, date, activitiesAndTime, customerName, phoneNumber, numberOfPeople,commentArea, vBox);

        HBox labelandtextField = new HBox(labelVbox, textfieldsVbox);
        labelandtextField.setPadding(new Insets(20, 10, 10, 50));
        labelandtextField.setSpacing(10);

        deleteButton = new Button("Clear");
        saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);
        deleteButton.setOnAction(event ->{
                    date.clear();
                    commentArea.clear();
                    phoneNumber.clear();
                    customerName.clear();
                }
        );
        System.out.println(activities.get(0).getName());
        saveButton.setOnAction(event -> {
            if (validate() && validateType()) {

                String name = getDate();
                String description = getCommentArea();
                int age = getCustomerName();
                double price = getPhoneNumber();
                ModelClass modelClass = new ModelClass();
                modelClass.updateDBActivity(name, age, price, description, intID);
                System.out.println("Hi............");

                display(primaryStage);
                primaryStage.setScene(window.getScene());
            } else if (validate()) {
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
        ModelClass modelClass = new ModelClass();
        ArrayList<Activity> list = new ArrayList<>();
        ObservableList<Activity> activities2 = FXCollections.observableArrayList();
        list = modelClass.getDBactivities();
        for (Activity a: list)
        {
            activities.add(a);
            activities2.add(a);
            System.out.println(a.toString());
        }
        return activities2;
    }

    public Label changeLabel(Label newLabel){
        editLabel = newLabel;
        editLabel.setVisible(true);
        return editLabel;

    }
}
