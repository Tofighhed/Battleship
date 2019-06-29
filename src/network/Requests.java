package network;

import com.google.gson.JsonElement;
import model.Ground;
import model.Messege;
import model.Middle;
import model.Pos;
import retrofit2.Call;
import retrofit2.http.*;
import sample.GroundController;

import javax.swing.*;

public interface Requests {

//   @GET("category/parents")
//    @GET("status/")
//    @Headers({
//           "HUMAN_ID: hjaksbgk124389212745"
//    })
//    @Headers({
//           "Authorization: token ef665066e1e7161089225252e3c7fc4c3ff3e93f"
//    })
//    Call<Middle> get_category ();
    @POST("api/start/")
    @Headers({"Authorization: token 34c12e4f0142d6047ce6d519036260ff23fdea4c" , "Content-Type: application/json"})
    Call<Messege> start_game();


    @GET("api/status/{game_id}")
    @Headers({"Authorization: token 34c12e4f0142d6047ce6d519036260ff23fdea4c" , "Content-Type: application/json"})
    Call<Messege> get_status (@Path("game_id") int geme_id);

    @POST ("api/init_game/")
    @Headers({"Authorization: token 34c12e4f0142d6047ce6d519036260ff23fdea4c" , "Content-Type: application/json"})
    Call<Messege> init_game (@Body Ground ground);

    @POST ("api/move/")
    @Headers({"Authorization: token 34c12e4f0142d6047ce6d519036260ff23fdea4c" , "Content-Type: application/json"})
    Call<Messege> move(Pos pos);


}
