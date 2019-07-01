package model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Offline {

    public static int nobat = 0;
    public static int k_self = 0;
    public static int k_computer = 0;
   public static Timer timer = new Timer();
    public static void timee() {

        if (k_self==20){
            System.out.println("Winner is player");
            timer.cancel();
            return;
        }
        if (k_computer==20){
            System.out.println("Winner is Computer");
            timer.cancel();
            return;
        }
        timer.scheduleAtFixedRate(new time(), 0, 50);
    }

    public static class time extends TimerTask {

        @Override
        public void run() {
            if (Offline.nobat % 2 == 1) {
                System.out.println("computer is moving");
            play_computer();

            }else {

            }
        }
    }

    public static void play_computer() {
        if (k_self == 20) {
            timer.cancel();
            System.out.println("Player Wins");
        } else if (k_computer == 20) {
            System.out.println("Computer Wins");
            timer.cancel();
        } else if (nobat % 2 == 1) {
            Random random = new Random();
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Analysis.check_hit_offline(x, y);
        }
    }
}