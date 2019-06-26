package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.VBox;
import model.Category;
import model.Messege;
//import javafx.scene.control.Button;
import javafx.scene.control.*;
import model.Pos;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GroundController implements Initializable {
    public static ArrayList<Button> buttonlist = new ArrayList<>();
    public static ArrayList<Buttonmain> a = new ArrayList<>();
    public static ArrayList<Buttonmain> b = new ArrayList<>();

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


//    @FXML
//    Buttonmain b00 = new Buttonmain(0, 0);
//    @FXML
//    Button b01=new Button();
//    @FXML
//    Button b02=new Button();
//    @FXML
//    Button b03=new Button();
//    @FXML
//    Button b04=new Button();
//    @FXML
//    Button b05=new Button();
//    @FXML
//    Button b06=new Button();
//    @FXML
//    Button b07=new Button();
//    @FXML
//    Button b08=new Button();
//    @FXML
//    Button b09=new Button();
//    @FXML
//    Button b10=new Button();
//    @FXML
//    Button b11=new Button();
//    @FXML
//    Button b12=new Button();
//    @FXML
//    Button b13=new Button();
//    @FXML
//    Button b14=new Button();
//    @FXML
//    Button b15=new Button();
//    @FXML
//    Button b16=new Button();
//    @FXML
//    Button b17=new Button();
//    @FXML
//    Button b18=new Button();
//    @FXML
//    Button b19=new Button();
//    @FXML
//    Button b20=new Button();
//    @FXML
//    Button b21=new Button();
//    @FXML
//    Button b22=new Button();
//    @FXML
//    Button b23=new Button();
//    @FXML
//    Button b24=new Button();
//    @FXML
//    Button b25=new Button();
//    @FXML
//    Button b26=new Button();
//    @FXML
//    Button b27=new Button();
//    @FXML
//    Button b28=new Button();
//    @FXML
//    Button b29=new Button();
//    @FXML
//    Button b30=new Button();
//    @FXML
//    Button b31=new Button();
//    @FXML
//    Button b32=new Button();
//    @FXML
//    Button b33=new Button();
//    @FXML
//    Button b34=new Button();
//    @FXML
//    Button b35=new Button();
//    @FXML
//    Button b36=new Button();
//    @FXML
//    Button b37=new Button();
//    @FXML
//    Button b38=new Button();
//    @FXML
//    Button b39=new Button();
//    @FXML
//    Button b40=new Button();
//    @FXML
//    Button b41=new Button();
//    @FXML
//    Button b42=new Button();
//    @FXML
//    Button b43=new Button();
//    @FXML
//    Button b44=new Button();
//    @FXML
//    Button b45=new Button();
//    @FXML
//    Button b46=new Button();
//    @FXML
//    Button b47=new Button();
//    @FXML
//    Button b48=new Button();
//    @FXML
//    Button b49=new Button();
//    @FXML
//    Button b50=new Button();
//    @FXML
//    Button b51=new Button();
//    @FXML
//    Button b52=new Button();
//    @FXML
//    Button b53=new Button();
//    @FXML
//    Button b54=new Button();
//    @FXML
//    Button b55=new Button();
//    @FXML
//    Button b56=new Button();
//    @FXML
//    Button b57=new Button();
//    @FXML
//    Button b58=new Button();
//    @FXML
//    Button b59=new Button();
//    @FXML
//    Button b60=new Button();
//    @FXML
//    Button b61=new Button();
//    @FXML
//    Button b62=new Button();
//    @FXML
//    Button b63=new Button();
//    @FXML
//    Button b64=new Button();
//    @FXML
//    Button b65=new Button();
//    @FXML
//    Button b66=new Button();
//    @FXML
//    Button b67=new Button();
//    @FXML
//    Button b68=new Button();
//    @FXML
//    Button b69=new Button();
//    @FXML
//    Button b70=new Button();
//    @FXML
//    Button b71=new Button();
//    @FXML
//    Button b72=new Button();
//    @FXML
//    Button b73=new Button();
//    @FXML
//    Button b74=new Button();
//    @FXML
//    Button b75=new Button();
//    @FXML
//    Button b76=new Button();
//    @FXML
//    Button b77=new Button();
//    @FXML
//    Button b78=new Button();
//    @FXML
//    Button b79=new Button();
//    @FXML
//    Button b80=new Button();
//    @FXML
//    Button b81=new Button();
//    @FXML
//    Button b82=new Button();
//    @FXML
//    Button b83=new Button();
//    @FXML
//    Button b84=new Button();
//    @FXML
//    Button b85=new Button();
//    @FXML
//    Button b86=new Button();
//    @FXML
//    Button b87=new Button();
//    @FXML
//    Button b88=new Button();
//    @FXML
//    Button b89=new Button();
//    @FXML
//    Button b90=new Button();
//    @FXML
//    Button b91=new Button();
//    @FXML
//    Button b92=new Button();
//    @FXML
//    Button b93=new Button();
//    @FXML
//    Button b94=new Button();
//    @FXML
//    Button b95=new Button();
//    @FXML
//    Button b96=new Button();
//    @FXML
//    Button b97=new Button();
//    @FXML
//    Button b98=new Button();
//    @FXML
//    Button b99=new Button();




    public void set_vbox(){
        System.out.println("set vbox started");
        String pre_ida = "a";
        String pre_idb = "b";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Buttonmain button = new Buttonmain();
                button.setPrefWidth(30);
                button.setPrefHeight(30);
                button.setId(pre_ida +  i + ""+ j);
                button.setOnAction(eventEventHandler);
                getvBoxea()[i].getChildren().add(button);
                a.add(button);
//                a[i][j] = button;

                Buttonmain button2 = new Buttonmain();
                button2.setPrefWidth(30);
                button2.setPrefHeight(30);
                button2.setId(pre_idb +  i + ""+ j);
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
//        super.in
//        List<Button> buttonlist = new ArrayList<Button>();
//        List<Button> list = new ArrayList<>();

//        hboxx.getChildren().addAll(buttonlist);



        set_vbox();
    }

//@FXML
// Buttonmain b99=new Buttonmain();





    EventHandler<javafx.event.ActionEvent> eventEventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String btn_id =  ((Button) event.getSource()).getId();
            System.out.println(btn_id);

            if (btn_id.startsWith("a")){ // our map
                Messege.get_status2();
                Buttonmain buttonmain  = a.get(new Pos(btn_id).combine);
                if (buttonmain.can_click){
                    buttonmain.setStyle("-fx-background-color: #ff1145");
                }

            }else {// enemy map

            }


        }
    };


    public void sett() {/*
        System.out.println("ssssss");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                Buttonmain button = new Buttonmain(i, j);
                button.setMaxHeight(50);
                button.setMaxWidth(50);
                button.setOnAction((ActiveEvent) -> {
                    System.out.println("asdadd1d");
                });
                buttonmains[i][j] = button;
                button.change();
                System.out.println(Buttonmain.lists[0][0].getX() + "   " + button.getY());


            }

        }*/
    }





    @FXML
    Button asd = new Button();

    @FXML
    public void get_cat(javafx.event.ActionEvent event) {
        sett();
    }
//    @FXML
// public void sddd(ActionListener aaa){
//
//    }

}
