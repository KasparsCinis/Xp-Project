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
        HBox nameHBox = new HBox();
        HBox descriptionHBox = new HBox();
        HBox priceHBox= new HBox();
        HBox ageLimitHBox= new HBox();
        HBox deleteSaveHBox= new HBox();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(nameHBox,descriptionHBox,priceHBox,ageLimitHBox,deleteSaveHBox);
        Scene scene = new Scene(vBox, 300,300);

        Label nameLabel = new Label("Activity name: ");
        nameHBox.getChildren().addAll(nameTextField,nameLabel );

        Label descriptionLabel = new Label("Description: ");


        descriptionArea.setPrefSize(167,100);
        descriptionHBox.getChildren().addAll(descriptionArea,descriptionLabel);

        Label priceLabel = new Label("Price: ");
        priceHBox.getChildren().addAll(priceTextField,priceLabel );

        Label ageLimitLabel = new Label("Age Limit: ");
        ageLimitHBox.getChildren().addAll( ageLimitTextfield,ageLimitLabel);

        Button deleteButton = new Button("Delete");
        Button saveButton = new Button("Save");
        deleteSaveHBox.getChildren().addAll(saveButton,deleteButton);

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






        primaryStage.setScene(scene);
        primaryStage.show();



    }

}
