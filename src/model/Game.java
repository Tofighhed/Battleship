package model;

import sample.*;
import java.util.TimerTask;
import java.util.Timer;

public class Game  {

    public static void timer(){
        Timer timer=new Timer();
        timer.schedule(new time(), 0, 3000);
    }

   public static class time extends TimerTask{

        @Override
        public void run() {
            Analysis.check_status(GroundController.ground1);
        }
    }


}
