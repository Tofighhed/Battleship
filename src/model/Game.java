package model;

import Controller.GroundController;
import com.google.gson.Gson;
import javafx.application.Platform;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
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
            Platform.runLater(() -> {// on JAVA FX THREAD
                Retrofit_Server retrofit_server = new Retrofit_Server();
                retrofit_server.getTService().get_status(Game.game_id).enqueue(new Callback<Messege>() {

                    @Override
                    public void onResponse(Call<Messege> call, Response<Messege> response) {
                        Log log=new Log();
                        Messege messege1=new Messege();

//                        Log.log_inf.add(log);
                        Platform.runLater(() -> { // Run JAVA FX THREAD
                            if (response.isSuccessful() && response.body() != null) {
                                log.setGame_id(Game.game_id);
                                Analysis.check = response.body();
                                Analysis.check_status(log);
                            } else {
                                try {
                                    Gson gson = new Gson();
                                    Messege messege = gson.fromJson(response.errorBody().string(), Messege.class);
                                    Messege.messegeArrayList.add(messege);
                                    Analysis.check = messege;
                                    Analysis.check_status(log);
                                } catch (Exception e) {
                                    System.out.println("Error casting server message");
                                    System.out.println(e.getMessage());
                                    GroundController.set_lable("Error casting server message");
                                }
                            }
                            Log.add_log(log);
                        });

                    }

                    @Override
                    public void onFailure(Call<Messege> call, Throwable throwable) {
                        System.out.println("Server Error " + throwable.getMessage());
                        Platform.runLater(() -> { // Run JAVA FX THREAD
                            GroundController.set_lable("Server Error");
                        });
                    }
                });
                count++;
            });
        }
    }

}
