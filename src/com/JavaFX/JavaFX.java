package com.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFX extends Application{

    public static void main(String[] args) {

        System.out.println("Launching JavaFX application");

//        starting the JavaFX application by calling launch()
        launch(args);
    }

//    override the init() method
    @Override
    public void init() throws Exception {
        System.out.println("Inside the init() method.");
    }

//    override the start() method
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Inside the start() method.");

//        give the stage a title
        primaryStage.setTitle("JavaFX Skeleton");

//        create a root node. In the case a flow layout
//        is used, but several alternatives exists.
        FlowPane rootNode = new FlowPane();

//        create a scene
        Scene myScene = new Scene(rootNode, 300, 200);

//        set the scene on the stage
        primaryStage.setScene(myScene);

//        show the stage and its scene
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Inside the stop() method.");
    }
}
