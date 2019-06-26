package sample;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ground.fxml"));
//        loader.setResources(this.init(). .getResourceBundle());
//        loader.load();
//        GroundController groundController = loader.getController();
//        groundController.set_vbox();



        Parent root = FXMLLoader.load(getClass().getResource("Ground.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setResizable(false);

//        ((GroundController)root).set_vbox();
        primaryStage.setScene(new Scene(root, 1000, 400));

//        primaryStage.
        primaryStage.show();
//        groundController.set_vbox();
    }


    public static void main(String[] args) {

//        int[][] map = new int[10][10] ;
//
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(map).toString());
//
        launch(args);
    }
}
