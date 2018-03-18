package com.JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application{

    double angel = 0.0;
    double scaleFactor = 0.4;
    double blurVal = 1.0;

//    create initial effects and transforms
    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

//    create push buttons
    Button btnRotate = new Button("Rotate");
    Button btnBlur = new Button("Blur off");
    Button btnScale = new Button("Scale");

    Label reflect = new Label("Reflection adds visual sparkle");

    public static void main(String[] args) {

//        start the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Effects and Transforms Demo");

        FlowPane rootNode = new FlowPane(20, 20);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 120);

        primaryStage.setScene(myScene);

//        Set actions for the buttons
        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);

//        set the reflection effect on the reflection label
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

//        handle the action events for the Rotate button
        btnRotate.setOnAction((ae) -> {

//            each time a button is pressed , it is rotated for 30 degrees
            angel += 15.0;
            rotate.setAngle(angel);
            rotate.setPivotX(btnRotate.getWidth()/2);
            rotate.setPivotY(btnRotate.getHeight()/2);
        });

//        handle the action events for the Scale button
        btnScale.setOnAction((ae) -> {
//            each time button is pressed, the button's scale is changed
            scaleFactor += 0.1;
            if (scaleFactor > 2.0) scaleFactor = 0.4;

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });

//        handle the action events for the Blur button
        btnBlur.setOnAction((ae) -> {

//            each time the button is pressed, its blur status is changed
            if (blurVal == 10.0) {
                blurVal = 1.0;
                btnBlur.setEffect(null);
                btnBlur.setText("Blur off");
            } else {
                blurVal++;
                btnBlur.setEffect(blur);
                btnBlur.setText("Blur on");
            }
            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        });

        rootNode.getChildren().addAll(btnRotate, btnScale, btnBlur, reflect);

        primaryStage.show();
    }
}
