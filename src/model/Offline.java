package model;

import java.util.Random;

public class Offline {
        public static int nobat=0;
        public static int k_self=0;
        public static int k_computer=0;
        public static void play () {
            while (true) {
                if (k_self == 20) {
                    System.out.println("Player Wins");
                } else if (k_computer == 20) {
                    System.out.println("Computer Wins");
                } else if (nobat % 2 == 1) {
                    Random random = new Random();
                    int x = random.nextInt(10);
                    int y = random.nextInt(10);
                    Analysis.check_hit_offline(x, y);
                } else {
                    

                }
            }
        }

}
