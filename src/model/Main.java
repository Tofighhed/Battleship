package model;

import Controller.GroundController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Main main = null;
    public Stage primaryStage = null ;

    // firs start .... [beganning]
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage; // store corent stage [ current Active window]
        Parent root = FXMLLoader.load(getClass().getResource("../View/MainMenue.fxml"));
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        main = this; // set for access
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void open_game_panel(boolean online ) throws IOException {
        GroundController.isOnline = online; // set is online or not ...
        if (primaryStage == null){
            primaryStage = new Stage(); // redundant
        }
        Parent root = FXMLLoader.load(getClass().getResource("../View/Ground.fxml"));
        primaryStage.setScene(new Scene(root, 900, 400));
        primaryStage.show();
    }


}
