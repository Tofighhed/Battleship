package model;

// pos : convert String Id to XY; Conbine  is index in Array of bottomns!
public class Pos {
    int game_id;
    public int x;
    public int y;
    public int combine;
    public String side;

    public Pos(String pos) {
        x = Integer.parseInt( pos.charAt(1) + "");
        y = Integer.parseInt( pos.charAt(2) + "");
        combine = x*10 + y ;
        side = pos.charAt(0) + "";
    }
    public Pos(String pos ,int gm_id){
        x = Integer.parseInt( pos.charAt(1) + "");
        y = Integer.parseInt( pos.charAt(2) + "");
        combine = x*10 + y ;
        side = pos.charAt(0) + "";
        game_id = gm_id;
    }
}
