package com.JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//Demonstrate JavaFX events and buttons
public class JavaFXEventDemo extends Application {

    Label response;

    public static void main(String[] args) {

//        Start the JavaFX application by calling launch()
        launch(args);
    }

//    Override the start() method
    public void start(Stage myStage){

//        Give the stage the title
        myStage.setTitle("Use JavaFX Buttons and events");

//        Use a FlowPane for the root node.
//        In this case, vertical and horizontal gaps of 10
        FlowPane rootNode = new FlowPane(10, 10);

//        Center and controls in the scene
        rootNode.setAlignment(Pos.CENTER);

//        Create a scene
        Scene myScene = new Scene(rootNode, 300, 100);

//        Set the scene on the stage
        myStage.setScene(myScene);

//        Create a label
        response = new Label("Push a Button");

//        Create two push buttons
        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");

//        Handle the action events for the Up button
        btnUp.setOnAction(event -> response.setText("You pressed Up"));

//        Handle the action events for the Down button
        btnDown.setOnAction(event -> response.setText("You pressed Down"));

//        Add the label and buttons to the scene graph
        rootNode.getChildren().addAll(btnUp, btnDown, response);

//        Show the stage in its scene
        myStage.show();
    }
}
