package network;

import com.google.gson.JsonElement;
import model.Ground;
import model.Messege;
import model.Middle;
import retrofit2.Call;
import retrofit2.http.*;

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

    @GET("api/status/{game_id}")
    @Headers({"Authorization: token ef665066e1e7161089225252e3c7fc4c3ff3e93f"})
    Call<Messege> get_status (@Path("game_id") int geme_id);

    @POST ("api/init_game")
    @Headers({"Authorization: token askjgfah2398r472398" , "Content-Type: application/json"})
    Call<JsonElement> init_game (Ground ground);


//https://www.google.com/search?source=hp&ei=QtsLXc7eC4z7kwX32aK4Aw&q=quera&oq=quera&gs_l=psy-ab.3..0l10.3541.5139..5336...0.0..1.406.1880.2-3j2j1......0....1..gws-wiz.....6..35i39j35i39i70i249.mHLqhPD0rqE
}
