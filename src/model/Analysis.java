package model;
import sample.GroundController;
public class Analysis {

    public static Messege check;
public static void check_start_game(){
    check=Messege.start_game();
    if (check.getCode() == 400) {
        System.out.println(check.getDetail(0)+"1:");
        return;
    }
    System.out.println(check.getGame_id());
    GroundController.ground1.game_id=check.getGame_id();
        if (check.getResult().equalsIgnoreCase("game created")) {
            System.out.println("game created");
        }

}

public static void check_status(Ground g){
//    check=Messege.get_status();
//    g.game_id=check.getGame_id();
    if (check.getCode()==0){
        System.out.println(check.getMessage()[0]);
    }
    if (check.getCode()==1){
        System.out.println(check.getMessage()[0]);
        //rival find
        //send your board
        Messege.init_game(GroundController.ground1);
    }
    if (check.getCode()==2){
        //messege:waiting for your rival board
        System.out.println(check.getMessage()[0]);
    }
    if (check.getCode()==3){
        //messege : its your hit
        //last hit:[n,m]
        //we should call move method and check enemy hit for our ground
        System.out.println(check.getMessage()[0]);
    }

    if (check.getCode()==4){
        //messege:waiting for your rival move
    }
    if (check.getCode()==5){
        //messege : game is finished
        //winner playerx
    }
    if (check.getCode()==6){
        //messege : cancelld by user
    }
}

public static void check_enemy_movment(int[][] move){

    for (int i = 0; i <i ; i++) {
        for (int j = 0; j <10 ; j++) {
//            if (GroundController.ground1.Board_array[i][j]==)
        }
    }
}
}
