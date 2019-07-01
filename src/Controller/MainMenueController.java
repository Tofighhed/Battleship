package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenueController  implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void Play2(ActionEvent actionEvent) {
        if (Main.main == null ){
            System.out.println("NO MAIN GAME!");
            return;
        }
        try {
            Main.main.open_game_panel(false);
        } catch (IOException e) {
            System.out.println("EXCEPTION FOR GAME WINDOW : " + e.getMessage());
        }
    }

    public void Online_mod(ActionEvent actionEvent) {
        if (Main.main == null ){
            System.out.println("NO MAIN GAME!");
            return;
        }
        try {
            Main.main.open_game_panel(true);
        } catch (IOException e) {
            System.out.println("EXCEPTION FOR GAME WINDOW : " + e.getMessage());
        }
    }

    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
