package com.github.ElficTitious.finalreality.gui;

import com.github.ElficTitious.finalreality.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Ismael Correa
 */
public class FinalReality extends Application {

  GameController controller = new GameController();


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");

    //Label label = new Label("This will be a game sometime");
    //label.setAlignment(Pos.CENTER);

    FlowPane pane = new FlowPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(30, 20, 30, 20));
    pane.setHgap(5);
    pane.setVgap(5);
    pane.setMinWidth(400);
    pane.setPrefWidth(400);
    pane.setMaxWidth(400);

    Button buttonThree = new Button("  Goblin \n HP: 100");
    Button buttonFour = new Button("  Orc \n HP: 120");
    buttonThree.setMinSize(80, 80);
    buttonFour.setMinSize(80, 80);
    pane.getChildren().add(buttonThree);
    pane.getChildren().add(buttonFour);

    TextField textField = new TextField();
    textField.setEditable(false);
    textField.setAlignment(Pos.CENTER);
    textField.setMinSize(336, 40);
    pane.getChildren().add(textField);

    Button buttonOne = new Button("  Knight \n HP: 100");
    Button buttontwo = new Button("  Thief \n HP: 120");
    buttonOne.setMinSize(80, 80);
    buttontwo.setMinSize(80, 80);
    pane.getChildren().add(buttonOne);
    pane.getChildren().add(buttontwo);

    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}