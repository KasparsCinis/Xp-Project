package com.company;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Created by St_Muerte on 2/25/16.
 */
public class ActivityInfoWindow {
    TextField nameTextField;
    TextArea descriptionArea;
    TextField ageLimitTextfield;
    TextField priceTextField;
    Stage window;
    MainAdminScene m;
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
    public void start(Stage primaryStage){
       // window = new Stage();
       // window.setTitle("Add Adventure");
        nameTextField = new TextField();
        descriptionArea = new TextArea();
        ageLimitTextfield = new TextField();
        priceTextField = new TextField();
        HBox nameHBox = new HBox();
        HBox descriptionHBox = new HBox();
        HBox priceHBox= new HBox();
        HBox ageLimitHBox= new HBox();
        HBox deleteSaveHBox= new HBox();
        VBox vBox = new VBox();
        //vBox.getChildren().addAll(nameHBox,descriptionHBox,priceHBox,ageLimitHBox,deleteSaveHBox);
        //Scene scene = new Scene(vBox, 300,300);



        VBox labelVBox = new VBox();
        VBox textVBox = new VBox();
        HBox hBox = new HBox();

        Label nameLabel = new Label("Activity name: ");
        nameHBox.getChildren().addAll(nameTextField,nameLabel );
        Label descriptionLabel = new Label("Description: ");
        descriptionArea.setPrefSize(167,100);
        descriptionHBox.getChildren().addAll(descriptionArea,descriptionLabel);
        Label priceLabel = new Label("Price: ");
        priceHBox.getChildren().addAll(priceTextField,priceLabel );
        Label ageLimitLabel = new Label("Age Limit: ");
        ageLimitHBox.getChildren().addAll( ageLimitTextfield,ageLimitLabel);
        Button deleteButton = new Button("Clear");
        Button saveButton = new Button("Save");
        Button backButton = new Button("Back");

        deleteSaveHBox.getChildren().addAll(backButton, saveButton,deleteButton);
        labelVBox.getChildren().addAll(nameLabel, descriptionLabel, ageLimitLabel, priceLabel);
        textVBox.getChildren().addAll(nameTextField, descriptionArea, ageLimitTextfield, priceTextField, deleteSaveHBox);
        descriptionLabel.setPrefHeight(45);
        ageLimitLabel.setTranslateY(70);
        priceLabel.setTranslateY(75);
        //saveButton.setTranslateX(-20);
        deleteSaveHBox.setTranslateY(10);
        saveButton.setTranslateX(0);
        deleteButton.setTranslateX(0);
        hBox.getChildren().addAll(labelVBox, textVBox);
        Scene scene = new Scene(hBox, 300,300);

       // deleteSaveHBox.getChildren().addAll(saveButton, deleteButton);

        backButton.setOnAction(event1 -> {
            m = new MainAdminScene();
            m.display(primaryStage);
            primaryStage.setScene(m.window.getScene());

        });
        deleteButton.setOnAction(event ->{
                    nameTextField.clear();
                    descriptionArea.clear();
                    priceTextField.clear();
                    ageLimitTextfield.clear();
                }
        );
        saveButton.setOnAction(event -> {
            if (validate() && validateType()) {
                m = new MainAdminScene();
                String name = getNameTextField();
                String description = getDescriptionArea();
                int age = getAgeLimitTextfield();
                double price = getPriceTextField();
                ModelClass modelClass = new ModelClass();
                modelClass.writeToDB(name, age, price, description);
                System.out.println("Hi............");

                m.display(primaryStage);
                primaryStage.setScene(m.window.getScene());
            } else if (validate()) {
                System.out.println("wrong type");
            } else {
                System.out.println("fill the fields");
            }
        });

        primaryStage.setTitle("Add adventure");
        primaryStage.setScene(scene);
        primaryStage.show();
       // window.setScene(scene);
       // window.show();
    }
}