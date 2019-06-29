package model;

import com.google.gson.Gson;
import network.Retrofit_Server;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.GroundController;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    public static int count = 0;
    public static void timer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new time(), 0, 3000);

    }

    public static class time extends TimerTask {

        @Override
        public void run() {
            System.out.println("TIMER RUN : " + count);
//            Analysis.check_status(GroundController.ground1);
            Retrofit_Server retrofit_server = new Retrofit_Server();

            retrofit_server.getTService().get_status(64).enqueue(new Callback<Messege>() {
                @Override
                public void onResponse(Call<Messege> call, Response<Messege> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Analysis.check = response.body();
                        Analysis.check_status(GroundController.ground1);
                    } else {
                        try {
                            Gson gson = new Gson();
                            Messege messege = gson.fromJson(response.errorBody().string(), Messege.class);
                            Analysis.check = messege;
                            Analysis.check_status(GroundController.ground1);
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
