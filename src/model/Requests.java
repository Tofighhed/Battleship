package model;

import retrofit2.Call;
import retrofit2.http.*;

public interface Requests {
//    ef665066e1e7161089225252e3c7fc4c3ff3e93f
//    static final String TOKEN = "ef665066e1e7161089225252e3c7fc4c3ff3e93f"; // WIFI MORFI
    static final String TOKEN = "34c12e4f0142d6047ce6d519036260ff23fdea4c"; // TOFIGH AD
    @POST("api/start/")
    @Headers({"Authorization: token " + TOKEN , "Content-Type: application/json"})
    Call<Messege> start_game();
    

    @GET("api/status/{game_id}")
    @Headers({"Authorization: token " + TOKEN })
    Call<Messege> get_status (@Path("game_id") int geme_id);

    @POST ("api/init_game/")
    @Headers({"Authorization: token " + TOKEN , "Content-Type: application/json"})
    Call<Messege> init_game (@Body Ground ground);

    @POST ("api/move/")
    @Headers({"Authorization: token " + TOKEN  , "Content-Type: application/json"})
    Call<Messege> move(@Body Pos pos);

    @POST ("api/quit/")
    @Headers({"Authorization: token " + TOKEN  , "Content-Type: application/json"})
    Call<Message2> quite_game (@Body Cga cga); // ONLY GAME ID IS NEEDED



}
