package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LevelsMenu {

    Stage stage;
    Scene levelsMenuScene;
    LevelOne levelOneScene;


    public LevelsMenu(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        Group root = new Group();

        Label mainMenu = new Label("Main Menu");
        mainMenu.setFont(Font.font("Calibri", 20));
        mainMenu.setLayoutX(100);
        mainMenu.setLayoutY(0);

        Image level1 = new Image("file:levelOne.jpg");
        ImageView image1 = new ImageView(level1);
        Button levelOne = new Button();
        levelOne.setGraphic(image1);

        image1.setFitWidth(100);
        image1.setFitHeight(150);
        levelOne.setLayoutX(10);
        levelOne.setLayoutY(30);

        Image level2 = new Image("file:levelTwo.jpg");
        ImageView image2 = new ImageView(level2);
        Button levelTwo = new Button();
        levelTwo.setGraphic(image2);
        image2.setFitWidth(100);
        image2.setFitHeight(150);
        levelTwo.setLayoutX(170);
        levelTwo.setLayoutY(30);

        root.getChildren().add(mainMenu);
        root.getChildren().add(levelOne);
        root.getChildren().add(levelTwo);


        levelsMenuScene = new Scene(root, 500, 400);

        levelOne.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                stage.setScene(levelOneScene.levelOneScene);
            }

        });
    }


    public void setLevelOneScene(LevelOne levelOneScene) {
        this.levelOneScene = levelOneScene;
    }
}
