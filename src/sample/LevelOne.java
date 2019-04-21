package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LevelOne {

    Stage stage;
    Scene levelOneScene;

    public LevelOne(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        Image river = new Image("file:riverBanks.jpg");
        ImageView riverBanks = new ImageView(river);
        riverBanks.setFitWidth(500);
        riverBanks.setFitHeight(400);

        Image farmer = new Image("file:farmer.png");
        ImageView farmerImg = new ImageView(farmer);
        farmerImg.setFitWidth(80);
        farmerImg.setFitHeight(130);
        farmerImg.setLayoutX(110);
        farmerImg.setLayoutY(150);

        Image sheep = new Image("file:sheep.png");
        ImageView sheepImg = new ImageView(sheep);
        sheepImg.setFitWidth(70);
        sheepImg.setFitHeight(50);
        sheepImg.setLayoutX(60);
        sheepImg.setLayoutY(230);

        Image wolf = new Image("file:wolf.png");
        ImageView wolfImg = new ImageView(wolf);
        wolfImg.setFitWidth(100);
        wolfImg.setFitHeight(60);
        wolfImg.setLayoutX(160);
        wolfImg.setLayoutY(210);

        Image cabbage = new Image("file:cabbage.png");
        ImageView cabbageImg = new ImageView(cabbage);
        cabbageImg.setFitWidth(40);
        cabbageImg.setFitHeight(40);
        cabbageImg.setLayoutX(260);
        cabbageImg.setLayoutY(220);

        Group root = new Group();

        root.getChildren().add(riverBanks);
        root.getChildren().add(farmerImg);
        root.getChildren().add(sheepImg);
        root.getChildren().add(wolfImg);
        root.getChildren().add(cabbageImg);

        levelOneScene = new Scene(root, 500, 400);

    }

}
