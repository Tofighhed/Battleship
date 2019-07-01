package model;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Timer;
import java.util.TimerTask;

public class Game {
    public static int game_id;
    public static int count = 0;
    public static void timer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new time(), 0, 2900);

    }

    public static class time extends TimerTask {

        @Override
        public void run() {

            System.out.println("TIMER RUN : " + count);
            Retrofit_Server retrofit_server = new Retrofit_Server();

            retrofit_server.getTService().get_status(Game.game_id).enqueue(new Callback<Messege>() {
                @Override
                public void onResponse(Call<Messege> call, Response<Messege> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Analysis.check = response.body();
                        Analysis.check_status();
                    } else {
                        try {
                            Gson gson = new Gson();
                            Messege messege = gson.fromJson(response.errorBody().string(), Messege.class);
                            Analysis.check = messege;
                            Analysis.check_status();
                        } catch (Exception e) {
                            System.out.println("Error casting server message");
                            System.out.println(e.getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<Messege> call, Throwable throwable) {
                    System.out.println("Server Error " + throwable.getMessage());
                }
            });
            count ++ ;
        }
    }

}
