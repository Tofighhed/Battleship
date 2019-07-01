package model;

import Controller.GroundController;
import javafx.application.Platform;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Offline {
    public static int nobat = 0;
    public static int k_self = 0;
    public static int k_computer = 0;
   public static Timer timer = new Timer();
    public static void timee() {
        String message = "";
        if (k_self==20){
            message = "Winner is player";
            GroundController.set_lable(message);
            System.out.println(message);
            timer.cancel();
            return;
        }
        if (k_computer==20){
            message = "Winner is Computer";
            GroundController.set_lable(message);
            System.out.println(message);
            timer.cancel();
            return;
        }
        timer.scheduleAtFixedRate(new time(), 0, 50);
    }

    public static class time extends TimerTask {

        @Override
        public void run() {
            Platform.runLater(() -> {
                if (Offline.nobat % 2 == 1) {
                    String message = "computer is moving";
                    System.out.println(message);
                    GroundController.set_lable(message);
                    play_computer();

                }else {
                    GroundController.set_lable("you should move");
                }
            });
        }
    }

    public static void play_computer() {
        if (k_self == 20) {
            timer.cancel();
            System.out.println("Player Wins");
            GroundController.set_lable("Player Wins");
        } else if (k_computer == 20) {
            System.out.println("Computer Wins");
            GroundController.set_lable("Computer Wins");
            timer.cancel();
        } else if (nobat % 2 == 1) {
            Random random = new Random();
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Analysis.check_hit_offline(x, y);
        }
    }
}