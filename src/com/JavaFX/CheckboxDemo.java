package com.JavaFX;

// Demonstrate Check Boxes

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckboxDemo extends Application{

    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;

    Label response;
    Label selected;

    String computers;

    public static void main(String[] args) {

//        Start the JavaFX application by calling launch()
        launch(args);
    }

//    override start() method
    public void start(Stage myStage) throws Exception {

//        Give the stage a title
        myStage.setTitle("Demonstrate Check Boxes");

//        Use the vertical FlowPane for the root node.
//        In this case, vertical and horizontal gaps of 10
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);

//        Center the controls in the scene
        rootNode.setAlignment(Pos.CENTER);

//        Create a scene
        Scene myScene = new Scene(rootNode, 330, 200);

//        Set the Scene on the stage
        myStage.setScene(myScene);

        Label heading = new Label("What computers do you own?");

//        Create a label that will report the state change of a check box
        response = new Label("");

//        Create a label that will report all selected check boxes
        selected = new Label("");

//        Create the check boxes
        cbSmartphone = new CheckBox("Smartphone");
        cbTablet = new CheckBox("Tablet");
        cbNotebook = new CheckBox("Notebook");
        cbDesktop = new CheckBox("Desktop");

//        Handle action events for the check boxes
        cbSmartphone.setOnAction(event -> {
            if (cbSmartphone.isSelected())
                response.setText("Smartphone was just selected");
            else if (cbSmartphone.isIndeterminate())
                response.setText("Smartphone is indeterminate");
            else
                response.setText("Smartphone was just cleared");

            showAll();
            }
        );

        cbSmartphone.setAllowIndeterminate(true);

        cbTablet.setOnAction(event -> {
            if (cbTablet.isSelected())
                response.setText("Tablet was just selected");
            else
                response.setText("Tablet was just cleared");

            showAll();
        });

        cbNotebook.setOnAction(event -> {
            if (cbNotebook.isSelected())
                response.setText("Notebook was just selected");
            else
                response.setText("Notebook was just cleared");

            showAll();
        });

        cbDesktop.setOnAction(event -> {
            if (cbDesktop.isSelected())
                response.setText("Desktop was just selected");
            else
                response.setText("Desktop was just cleared");

            showAll();
        });

//        Add controls to the scene graph
        rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet, cbNotebook, cbDesktop, response, selected);

//        Show the stage and its scene
        myStage.show();

        showAll();
    }

//    Update and show the selections
    private void showAll() {
        computers = "";
        if (cbSmartphone.isSelected()) computers = "Smartphone ";
        if (cbTablet.isSelected()) computers += "Tablet ";
        if (cbNotebook.isSelected()) computers += "Notebook ";
        if (cbDesktop.isSelected()) computers += "Desktop ";

        selected.setText("Computers selected: " + computers);
    }
}
