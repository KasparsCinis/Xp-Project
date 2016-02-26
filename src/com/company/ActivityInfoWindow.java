package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by St_Muerte on 2/25/16.
 */
public class ActivityInfoWindow extends Application{

    TextField nameTextField = new TextField();
    TextArea descriptionArea = new TextArea();
    TextField ageLimitTextfield = new TextField();
    TextField priceTextField = new TextField();


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


    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox deleteSaveHBox= new HBox();
        HBox hBox = new HBox();
        //vBox.getChildren().addAll(nameHBox,descriptionHBox,priceHBox,ageLimitHBox,deleteSaveHBox);
        //Scene scene = new Scene(vBox, 300,300);

        VBox labelVBox = new VBox();
        VBox textVBox = new VBox();


        Label nameLabel = new Label("Activity name: ");
        Label descriptionLabel = new Label("Description: ");
        descriptionArea.setPrefSize(167,100);

        Label priceLabel = new Label("Price: ");
        Label ageLimitLabel = new Label("Age Limit: ");

        Button deleteButton = new Button("Delete");
        Button saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);

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

        deleteButton.setOnAction(event ->{
                    nameTextField.clear();
                    descriptionArea.clear();
                    priceTextField.clear();
                    ageLimitTextfield.clear();
                }

        );
        saveButton.setOnAction(event -> {
            System.out.println(validate());
            if (validate()) {
                boolean nameb = true;
                boolean descb = true;
                boolean ageb = true;
                boolean priceb = true;


                System.out.println("Hi............");
            }

        });



        primaryStage.setScene(scene);
        primaryStage.show();



    }

}
