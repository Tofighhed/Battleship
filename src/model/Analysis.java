package model;

public class Analysis {
    public static Messege check;
public static void check_start_game(){
    check=Messege.start_game();
    if (check.getCode() == 400) {
        System.out.println(check.getDetail(0));
        return;
    }

    System.out.println(check.getCode());
    System.out.println(check.getGame_id());
        if (check.getResult().equalsIgnoreCase("game created")) {
            System.out.println("game created");
        }

}
public static void check_status(Ground g){
    check=Messege.get_status();
    if (check.getCode()==1){
        g.game_id=check.getGame_id();

        //rival find
        //send your board
//        Messege.init_game();
    }
    if (check.getCode()==2){
        //messege:waiting for your rival board
    }
    if (check.getCode()==3){
        //messege : its your hit
        //last hit:[n,m]
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
}
