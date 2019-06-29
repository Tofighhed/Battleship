package model;

import com.google.gson.Gson;
import sample.GroundController;

public class Analysis {

    public static Messege check;

    public static void check_start_game() {
        check = Messege.start_game();
        if (check.getCode() == 400) {
            System.out.println(check.getDetail(0) + "1:");
            return;
        }
        System.out.println(check.getGame_id());
//    GroundController.ground1.game_id=check.getGame_id();
        if (check.getResult().equalsIgnoreCase("game created")) {
            System.out.println("game created");
        }

    }

    public static void check_status() {
        if (check.getCode() == 0) {
            System.out.println(check.getMessage()[0]);
        }
        if (check.getCode() == 1) {
            System.out.println(check.getMessage()[0]);
            Gson gson = new Gson();
            System.out.println(gson.toJson(GroundController.ground1));

            Messege.init_game();
        }
        if (check.getCode() == 2) {
            //messege:waiting for your rival board
            System.out.println(check.getMessage()[0]);
        }
        if (check.getCode() == 3) {
            System.out.println(check.getMessage()[0]);
            Analysis.fix_last_hit();
            if (check.real_last_hit.length == 0) {
                return;
            } else {
                check_enemy_movment(check.real_last_hit);
            }
            GroundController.can_move=true;
            //last hit:[n,m]
            //we should call move method and check enemy hit for our ground

        }

        if (check.getCode() == 4) {
            GroundController.can_move=false;
            //messege:waiting for your rival move
            System.out.println(check.getMessage()[0]);
        }
        if (check.getCode() == 5) {
            //messege : game is finished
            //winner playerx
        }
        if (check.getCode() == 6) {
            //messege : cancelld by user
        }
    }

    public static void check_enemy_movment(int[][] move) {
        for (int i = 0; i < move.length; i++) {
            for (int j = 0; j < 1; j++) {
                int first = move[i][j];
                int second = move[i][j + 1];
                if (GroundController.ground1.board_array[first][second] == 1) {
                    GroundController.a.get(first * 10 + second).setStyle("-fx-background-color: #ff1145");
                }
                if (GroundController.ground1.board_array[first][second] == 0) {
                    GroundController.a.get(first * 10 + second).setStyle("-fx-background-color: #19B5FE");
                }
            }
        }
    }

    public static void fix_last_hit() {
        check.real_last_hit = new Gson().fromJson(check.getLast_hit(), int[][].class);
    }

    public static void check_my_movment(){

        check=Messege.move(GroundController.my_pos);

        if (check.getShip()){
            int first = GroundController.my_pos.x;
            int second = GroundController.my_pos.y;
            GroundController.b.get(first*10 + second).setStyle("-fx-background-color:#ff1145 ");
            GroundController.can_move=true;
        }else {
            int first = GroundController.my_pos.x;
            int second = GroundController.my_pos.y;
            GroundController.b.get(first*10 + second).setStyle("-fx-background-color:#19B5FE ");
            GroundController.can_move=false;
        }
        if (check.getShip() && check.isWin()){
            int first = GroundController.my_pos.x;
            int second = GroundController.my_pos.y;
            GroundController.b.get(first*10 + second).setStyle("-fx-background-color:#ff1145 ");
            GroundController.can_move=false;
        }

    }


}

