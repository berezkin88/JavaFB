package com.JavaFX;

import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application{

    private Label response;

    public static void main(String[] args) {

//        start the JavaFX application by calling launch()
        launch(args);
    }

//    override the start() method
    public void start(Stage myStage) {

//        give the stage title
        myStage.setTitle("ListView Demo");

//        use a FlowPane for the root node
//        in this case, vertical and horizontal gaps of 10
        FlowPane rootNode = new FlowPane(10, 10);

//        center the controls in the scene
        rootNode.setAlignment(Pos.CENTER);

//        create a scene
        Scene myScene = new Scene(rootNode, 200, 120);

//        set the scene on the stage
        myStage.setScene(myScene);

//        create a label
        response = new Label("Select computer type");

//        create an ObservableList of entries for the list view
        ObservableList<String> computerTypes = FXCollections.observableArrayList("Smartphone", "Tablet", "Notebook", "Desktop");

//        create the list view
        ListView<String> lvComputers = new ListView<>(computerTypes);

//        set the preferred height and width
        lvComputers.setPrefSize(100, 70);

//        get the list view selection model
        MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();

//        use a change listener to respond to a change of selection within a list view
        lvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {

//                display the selection
            response.setText("Computer selected is " + newValue);
        });

//        add the label and the list view to the scene graph
        rootNode.getChildren().addAll(lvComputers, response);

//        show the stage and its scene
        myStage.show();
    }
}
