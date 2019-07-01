package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;
import model.Buttonmain;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GroundController implements Initializable {
    public static boolean isOnline = true; // online game with server false : 2 player offline
    public static ArrayList<Button> buttonlist = new ArrayList<>();
    public static ArrayList<Buttonmain> a = new ArrayList<>();
    public static ArrayList<Buttonmain> b = new ArrayList<>();
    public static boolean start_game=false;
    public static boolean make_board = false;
    public static Ground ground1 = new Ground();
    public static Ground ground2 = new Ground();
    public static Pos my_pos;
    public static boolean can_move = false;
    public VBox vba1;
    public VBox vba2;
    public VBox vba3;
    public VBox vba4;
    public VBox vba5;
    public VBox vba6;
    public VBox vba7;
    public VBox vba8;
    public VBox vba9;
    public VBox vba10;

    public VBox vbb1;
    public VBox vbb2;
    public VBox vbb3;
    public VBox vbb4;
    public VBox vbb5;
    public VBox vbb6;
    public VBox vbb7;
    public VBox vbb8;
    public VBox vbb9;
    public VBox vbb10;


    VBox[] getvBoxea() {
        return new VBox[]{vba1,
                vba2,
                vba3,
                vba4,
                vba5,
                vba6,
                vba7,
                vba8,
                vba9,
                vba10};
    }

    public VBox[] getvBoxeb() {
        return new VBox[]{vbb1,
                vbb2,
                vbb3,
                vbb4,
                vbb5,
                vbb6,
                vbb7,
                vbb8,
                vbb9,
                vbb10};
    }

    @FXML
    Button start = new Button();
    @FXML
    Button c_board = new Button();
    @FXML
    Button l_game = new Button();


    public void set_vbox() {
        System.out.println("set vbox started");
        String pre_ida = "a";
        String pre_idb = "b";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Buttonmain button = new Buttonmain();
                button.setPrefWidth(30);
                button.setPrefHeight(30);
//                button.setDisable(true);
                button.setId(pre_ida + i + "" + j);
                button.setOnAction(eventEventHandler);
                getvBoxea()[i].getChildren().add(button);
                a.add(button);
//                a[i][j] = button;

                Buttonmain button2 = new Buttonmain();
                button2.setPrefWidth(30);
                button2.setPrefHeight(30);
//                button.setDisable(true);
                button2.setId(pre_idb + i + "" + j);
                button2.setOnAction(eventEventHandler);
                getvBoxeb()[i].getChildren().add(button2);
                b.add(button2);
//                b[i][j] = button2;
            }
        }
    }

    //    Button[] buttons = new Button[100];
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("INITIALIZED >>>>>>>>>>>>>>>>>>");
        set_vbox();
    }


    EventHandler<javafx.event.ActionEvent> eventEventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (isOnline) {
                if (!can_move) {
                    return;
                }
            }
            else {
                if (!make_board)return;
                if (!start_game)return;
                String btn_id = ((Button) event.getSource()).getId();
                System.out.println(btn_id);

                if (btn_id.startsWith("b")) { // our map

                    my_pos = new Pos(btn_id); // server wants valid game id
                    if (isOnline) {
                        Analysis.check_my_movment();
                    } else {
                        if (Offline.nobat % 2 == 0)
                            Analysis.check_hit_offline(my_pos.x, my_pos.y);
                    }

                } else {// self map

                }

            }


        }
    };

    @FXML
    Label label = laabel;

    public static Label laabel = new Label();

    public static void Set_label_(String str) {
        laabel.setText(str);
    }

    @FXML
    public void setStart(javafx.event.ActionEvent event) {

        if (!make_board) {
            System.out.println("create board first");
            return;
        } else {
            if (isOnline) {
                Analysis.check_start_game();
                Game.timer();
            }
            else {
                start_game=true;
                Offline.timee();
            }
        }
    }

    @FXML
    public void create_board(javafx.event.ActionEvent event) {

        if (make_board) {
            return;
        }

        ground1.make_ground();
        if (!isOnline) {
            ground2.make_ground();
        }
        make_board = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int val = ground1.board_array[i][j];
                if (val == 1)
                    a.get(i * 10 + j).setStyle("-fx-background-color:#00ff00");
                    a.get(i * 10 + j).setDisable(true);

            }
        }

    }

    @FXML
    public void leave_game(javafx.event.ActionEvent event) {
        Messege.quite_game();

    }

}
