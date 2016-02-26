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
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
/**
 * Created by krist on 25/02/2016.
 */
public class MainAdminScene {
    ArrayList<Activity> activities = new ArrayList<>();
    ActivityInfoWindow a;
    TextField nameTextField = new TextField();
    TextArea descriptionArea = new TextArea();
    TextField ageLimitTextfield = new TextField();
    TextField priceTextField = new TextField();
    VBox vBox;
    Stage window = new Stage();

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
        activityTableView.setRowFactory(activityTableView-> {
            TableRow<Activity>row = new TableRow<Activity>();
            row.setOnMouseClicked(event -> {if (event.getClickCount() ==1&&(! row.isEmpty())){
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
        Button homeButton = new Button("Back");
        Button newButton = new Button("New");
        newButton.setOnAction(event -> {
            a = new ActivityInfoWindow();
            a.start(primaryStage);
            //vBox.setVisible(false);
        });
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        javafx.scene.image.Image image = new javafx.scene.image.Image("com/Logo2.jpg");
        ImageView iv1 = new ImageView();
        Label edit = new Label("EDIT: ");
        edit.setFont(new Font("Serif",30));
        iv1.setImage(image);
        iv1.setFitWidth(80);
        iv1.setFitHeight(50);
        layout.setTop(iv1);
        Button deleteButton2 = new Button("Delete");
        deleteButton2.setOnAction(event ->{
                    modelClass.deleteDB(intID);
                    activityTableView.setItems(getActivity());
                }
        );

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll( homeButton, newButton, deleteButton2);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.BOTTOM_LEFT);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(hBox1);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(activityTableView);
        layout.setBottom(gridPane);
        layout.setCenter(hBox2);
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
        VBox textfieldsVbox = new VBox(edit,ageLimitTextfield, descriptionArea, priceTextField,nameTextField,vBox);
        HBox labelandtextField = new HBox(labelVbox, textfieldsVbox);
        Button deleteButton = new Button("Clear");
        Button saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);
        deleteButton.setOnAction(event ->{
                    nameTextField.clear();
                    descriptionArea.clear();
                    priceTextField.clear();
                    ageLimitTextfield.clear();
                }
        );
        System.out.println(activities.get(0).getName());
        saveButton.setOnAction(event -> {
            System.out.println(validate());
            if (validate()) {
                boolean nameb = true;
                boolean descb = true;
                boolean ageb = true;
                boolean priceb = true;
                String name = getNameTextField();
                if (name.equals("")) {
                    nameb = false;
                }
                String description = getDescriptionArea();
                if (description.equals("")) {
                    descb = false;
                }
                getAgeLimitTextfield();
                Integer age = getAgeLimitTextfield();
                if (age == null) {
                    ageb = false;
                }
                Double price = getPriceTextField();
                if (price == null) {
                    priceb = false;
                }
                if (nameb == false || descb == false || ageb == false || priceb == false) {
                    alertMessage();
                }
                System.out.println("Hi............");
            }
        });
        layout.setRight(labelandtextField);
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
}
