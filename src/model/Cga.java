package model;

import com.google.gson.annotations.SerializedName;

public  class Cga {
    @SerializedName("game_id")
    public int game_id;

    public Cga(int game_id) {
        this.game_id = game_id;
    }
}
