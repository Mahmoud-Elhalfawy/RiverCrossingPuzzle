package sample;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LevelOne {

    Stage stage;
    Scene levelOneScene;
    FarmerImage Farmer;
    BoatImage Boat;
    ImageView farmerview;
    ImageView BoatView;
    Group root;
    public LevelOne(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        Image river = new Image("file:riverBanks.jpg");
        ImageView riverBanks = new ImageView(river);
        riverBanks.setFitWidth(1400);
        riverBanks.setFitHeight(800);

       /* Image farmer = new Image("file:farmer.png");
        ImageView farmerImg = new ImageView(farmer);
        farmerImg.setFitWidth(80);
        farmerImg.setFitHeight(130);
        farmerImg.setLayoutX(110);
        farmerImg.setLayoutY(150);*/

        /*Image sheep = new Image("file:leftsheep.png");
        ImageView sheepImg = new ImageView(sheep);
        sheepImg.setFitWidth(70);
        sheepImg.setFitHeight(50);
        sheepImg.setLayoutX(60);
        sheepImg.setLayoutY(230);*/

       /* Image wolf = new Image("file:leftwolf.png");
        ImageView wolfImg = new ImageView(wolf);
        wolfImg.setFitWidth(100);
        wolfImg.setFitHeight(60);
        wolfImg.setLayoutX(160);
        wolfImg.setLayoutY(210);*/

      /*  Image cabbage = new Image("file:leftcabbage.png");
        ImageView cabbageImg = new ImageView(cabbage);
        cabbageImg.setFitWidth(40);
        cabbageImg.setFitHeight(40);
        cabbageImg.setLayoutX(260);
        cabbageImg.setLayoutY(220);*/

        root = new Group();
        levelOneScene = new Scene(root, 1400, 800);
       Canvas canvas= new Canvas(1400,800);
        root.getChildren().add(riverBanks);
        GraphicsContext gc = canvas.getGraphicsContext2D();

     Farmer = new FarmerImage(new Image("file:paintleftfarmer_burned.png"),new Image("file:paintrighttfarmer_burned.png"));
        farmerview=new ImageView(Farmer.LeftImage);
        farmerview.setLayoutX(Farmer.getLeftPositionX());
        farmerview.setLayoutY(Farmer.getLeftPositionY());
       // Farmer.render(gc);
        Farmer.render2(gc);
        SheepImage Sheep = new SheepImage(new Image("file:leftpaintsheep_burned.png"),new Image("file:rightpaintsheep_burned.png"));
        Sheep.render(gc);
        Sheep.render2(gc);
        WolfImage Wolf = new WolfImage(new Image("file:leftwolfpaint_burned.png") , new Image("file:rightwolfpaint_burned.png"));
        Wolf.render(gc);
        Wolf.render2(gc);
        CabbageImage Cabbage = new CabbageImage(new Image("file:leftcabbage1.png"),new Image("file:leftcabbage1.png"));
        Cabbage.render(gc);
        Cabbage.render2(gc);
 Boat = new BoatImage(new Image("file:raft.png"),new Image("file:raft.png"));
        BoatView = new ImageView(Boat.LeftImage);
        BoatView.setLayoutX(Boat.getLeftPositionX());
        BoatView.setLayoutY(Boat.getLeftPositionY());

        Boat.render(gc);
        Boat.render2(gc);

        stage.setScene(levelOneScene);
stage.show();
        root.getChildren().add(canvas);
        root.getChildren().add(farmerview);
     //  root.getChildren().add(riverBanks);
     //   root.getChildren().add(farmerImg);
      //  root.getChildren().add(sheepImg);
        //root.getChildren().add(wolfImg);
    //    root.getChildren().add(cabbageImg);



    }

public  void Move()

    {

        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(Farmer.getLeftPositionX());
        moveTo.setY(Farmer.getLeftPositionY());
        LineTo lineTo = new LineTo();
        lineTo.setX(Boat.getLeftPositionX());
        lineTo.setY(Boat.getLeftPositionY());
        path.getElements().add(moveTo);
        path.getElements().add(lineTo);
        path.setOpacity(0.0D);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(4.0D));
        pathTransition.setDelay(Duration.seconds(0.0D));
        pathTransition.setPath(path);

        pathTransition.setNode(Farmer);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(-1);
        pathTransition.setAutoReverse(true);
        ParallelTransition parallelTransition = new ParallelTransition(new Animation[]{pathTransition});
        parallelTransition.play();
        root.getChildren().add(path);

    }


   /* public void Move (){

        farmerview.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              Dragboard db= farmerview.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(farmerview.getImage());
                //content.putString(source.getText());
                db.setContent(content);

                event.consume();

            }
        });
        BoatView.setOnDragOver(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                System.out.println("henaaaaa");

                if (event.getGestureSource() != BoatView)
                    event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });

        BoatView.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {


                if (event.getGestureSource() != BoatView)
                    BoatView.setStyle("-fx-background-color: GREEN");



                event.consume();
            }
        });
        BoatView.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                BoatView.setStyle("-fx-background-color: GREEN");

                event.consume();
            }
        });
        BoatView.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    BoatView.setImage(db.getImage());
                    success = true;
                }

                event.setDropCompleted(success);

                event.consume();
            }
        });
        farmerview.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {

                if (event.getTransferMode() == TransferMode.MOVE) {
                    LineTo Lineto = new LineTo(Farmer.getLeftPositionX(),Farmer.getLeftPositionY());

                    // create moveto
                    MoveTo moveto = new MoveTo(Boat.getLeftPositionX(), Boat.getLeftPositionY());

                    // create a Path
                    Path path = new Path(moveto, Lineto);
                    PathTransition transition = new PathTransition();
                    transition.setNode(farmerview);
                    transition.setPath(path);
                }

                event.consume();
            }
        }); */

    }


