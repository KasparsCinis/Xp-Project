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
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
/**
 * Created by krist on 25/02/2016.
 */
public class ActivityScene {
    ArrayList<Activity> activities = new ArrayList<>();
    ActivityInfoWindow activityInfoWindow;
    TextField nameTextField = new TextField();
    TextArea descriptionArea = new TextArea();
    TextField ageLimitTextfield = new TextField();
    TextField priceTextField = new TextField();
    VBox vBox;
    Stage window = new Stage();
    Label notificationLabel = new Label("");

    Button homeButton = new Button("Back");
    Button newButton = new Button("New");
    Label edit = new Label("EDIT: ");

    String intID;
    ModelClass modelClass = new ModelClass();
    TableView<Activity> activityTableView;
    public String getNameTextField() {
        return nameTextField.getText().toString();
    }
    public void setNameTextField(String nameText) {
        nameTextField.setText(nameText);
    }
    public String getDescriptionArea() {
        return descriptionArea.getText().toString();
    }
    public void setDescriptionArea(String description) {
        descriptionArea.setText(description);
    }
    public int getAgeLimitTextfield() {
        if(ageLimitTextfield.getText().toString()!=""){
            return Integer.valueOf(ageLimitTextfield.getText().toString());
        }
        return 0;
    }
    public void setAgeLimitTextfield(int ageLimitTextfield) {
        this.ageLimitTextfield.setText( String.valueOf(ageLimitTextfield));
    }
    public Double getPriceTextField() {
        //check if it's a double first?
        return Double.valueOf(priceTextField.getText().toString());
    }
    public void setPriceTextField(Double priceTextField) {
        this.priceTextField.setText(String.valueOf(priceTextField));
    }
    public void alertMessage(){
        Alert noname = new Alert(Alert.AlertType.ERROR);
        noname.setContentText("Error Message");
        noname.showAndWait();
    }
    public boolean validate()
    {
        boolean result=true;
        if(getNameTextField().equals("")) {
            result = false;
        }
        if(getDescriptionArea().equals("")) {
            result = false;
        }
        if(ageLimitTextfield.getText().toString().equals(""))
        {
            result = false;
        }
        if(priceTextField.getText().toString().equals("")) {
            result = false;
        }
        return result;
    }
    public boolean validateType()
    {
        try{
            Integer.valueOf(ageLimitTextfield.getText().toString()) ;
            Double.valueOf(priceTextField.getText().toString());
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
    public void display(Stage primaryStage){
        vBox = new VBox();
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
        activityTableView.setRowFactory(activityTableView -> {
            TableRow<Activity> row = new TableRow<Activity>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    edit.setText("EDIT: ");
                    Activity rowData = row.getItem();
                    System.out.println(rowData);
                    nameTextField.setText(rowData.getName());
                    ageLimitTextfield.setText(String.valueOf(rowData.getAgeLimit()));
                    priceTextField.setText(String.valueOf(rowData.getPrice()));
                    descriptionArea.setText(rowData.getDescription());


                    intID = rowData.getIdActivity();
                }
            });
            return row;
        });

        newButton.setOnAction(event -> {
            edit.setText("NEW: ");
            clearTextFieldsActivity();
        });
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("com/Logo2.jpg");
        ImageView iv1 = new ImageView();




        edit.setFont(new Font("Serif",30));
        iv1.setImage(image);
        iv1.setFitWidth(80);
        iv1.setFitHeight(50);
        iv1.setVisible(true);
        layout.setTop(iv1);

        HBox imgHBox = new HBox(200);
        imgHBox.getChildren().addAll(iv1);
        imgHBox.setPadding(new Insets(0,0,5,0));

        Button deleteButton2 = new Button("Delete");
        deleteButton2.setOnAction(event ->{
            modelClass.deleteDBActivity(intID);
            activityTableView.setItems(getActivity());

            notificationLabel.setText("Activity deleted successful");
            notificationLabel.setTextFill(Color.web("green"));
            Timeline timeline = new Timeline(new KeyFrame(
            Duration.millis(3000),
            ae ->   notificationLabel.setVisible(false)));
            timeline.play();
            clearTextFieldsActivity();
                }
        );

        HBox activityTableHbox = new HBox(); // Buttons under the tableview "Back,New, Edit"
        //hBox1.setStyle("-fx-background-color: cyan");
        activityTableHbox.getChildren().addAll( homeButton, newButton, deleteButton2);
        activityTableHbox.setSpacing(10);
        activityTableHbox.setAlignment(Pos.BOTTOM_LEFT);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(activityTableHbox);
        HBox hBox2 = new HBox();

        //notification label
        HBox hBox = new HBox();
        hBox.getChildren().addAll(gridPane, notificationLabel);
        notificationLabel.setTranslateX(250);
        notificationLabel.setStyle("-fx-font-size: 20");
        notificationLabel.setVisible(true);

        hBox2.getChildren().addAll(activityTableView);
        layout.setBottom(hBox);
        layout.setCenter(hBox2);
        layout.setTop(imgHBox);

        HBox nameHBox = new HBox();
        HBox descriptionHBox = new HBox();
        HBox priceHBox= new HBox();
        HBox ageLimitHBox= new HBox();
        HBox deleteSaveHBox= new HBox();
        vBox.getChildren().addAll(nameHBox,descriptionHBox,priceHBox,ageLimitHBox,deleteSaveHBox);
        //Scene scene = new Scene(vBox, 300,300);
        Label nameLabel = new Label("Activity name: ");
        Label descriptionLabel = new Label("Description: ");
        descriptionArea.setPrefSize(187,100);
        Label priceLabel = new Label("Price: ");
        Label ageLimitLabel = new Label("Age Limit: ");
        nameLabel.setPrefHeight(115);
        descriptionLabel.setTranslateY(1);
        ageLimitLabel.setTranslateY(45);
        priceLabel.setTranslateY(60);
        VBox labelVbox = new VBox(nameLabel,descriptionLabel,ageLimitLabel,priceLabel);
        VBox textfieldsVbox = new VBox(edit,nameTextField, descriptionArea, ageLimitTextfield, priceTextField,vBox);

        HBox labelandtextField = new HBox(labelVbox, textfieldsVbox);
        labelandtextField.setPadding(new Insets(20, 10, 10, 50));
        labelandtextField.setSpacing(10);

        Button deleteButton = new Button("Clear");
        Button saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);
        deleteButton.setOnAction(event ->{
            clearTextFieldsActivity();
            notificationLabel.setVisible(true);
            notificationLabel.setText("Cleared successful!");
            notificationLabel.setTextFill(Color.web("green"));
            Timeline timeline = new Timeline(new KeyFrame(
            Duration.millis(3000),
            ae ->   notificationLabel.setVisible(false)));
            timeline.play();
            edit.setText("EDIT: ");
                }
        );
        System.out.println(activities.get(0).getName());
        saveButton.setOnAction(event -> {
            if (validate() && validateType()) {

                String name = getNameTextField();
                String description = getDescriptionArea();
                int age = getAgeLimitTextfield();
                double price = getPriceTextField();
                ModelClass modelClass = new ModelClass();
                if (edit.getText().equals("EDIT: ")) {
                    modelClass.updateDBActivity(name, age, price, description, intID);
                    notificationLabel.setText("Activity edit successful!");
                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                }
                if (edit.getText().equals("NEW: ")) {
                    modelClass.writeToDBActivity(name, age, price, description);
                    notificationLabel.setText("Activity add successful!");
                    notificationLabel.setTextFill(Color.web("green"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                }

                System.out.println("Hi............");

                display(primaryStage);
                primaryStage.setScene(window.getScene());
            } else if (validate()) {   //Do we need this else if statement???
                if (edit.getText().equals("EDIT: ")){
                    notificationLabel.setText("Activity edit unsuccessful. Wrong type!");
                    notificationLabel.setTextFill(Color.web("red"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                } else {
                    notificationLabel.setText("Activity add unsuccessful. Wrong type!");
                    notificationLabel.setTextFill(Color.web("red"));
                    Timeline timeline = new Timeline(new KeyFrame(
                            Duration.millis(3000),
                            ae ->   notificationLabel.setVisible(false)));
                    timeline.play();
                }
            } else {
                notificationLabel.setText("Fill the fields");
                notificationLabel.setTextFill(Color.web("red"));
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.millis(3000),
                        ae ->   notificationLabel.setVisible(false)));
                timeline.play();

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
        modelClass = new ModelClass();
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

    public void clearTextFieldsActivity()
    {
        nameTextField.clear();
        descriptionArea.clear();
        priceTextField.clear();
        ageLimitTextfield.clear();
    }
}
