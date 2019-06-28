package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Random;

public  class Ground {
public Ground(int gm){
    game_id=gm;
}
public Ground(){}
    public int game_id;
    public int[][]  Board_array=new int[10][10];


    public void make_ground(){

        Random r = new Random();
        boolean even=r.nextBoolean();
        int[][] temp = { {1 , 1 , 1 , 1 , 0 , 0 , 0 ,0 ,0 , 0} , {1,1,1,0,0,0,0,1,1,1},{1,1,0,0,1,1,0,0,1,1},{1,0,0,0,1,0,1,0,0,1} };
        ArrayList<Integer> list_choosed=new ArrayList<>();
        boolean satr=r.nextBoolean();
        int flag=0;
        if (even){flag=0;}else {flag=1;}

        while (list_choosed.size()<temp.length){
            int rand=r.nextInt(temp.length);
            if (list_choosed.contains(rand)){continue;}

            if (satr){
                Board_array[flag]=temp[rand];
                list_choosed.add(rand);

            }
            else {
                int[] vals = temp[rand];
                for (int i = 0; i < 10; i++) {
                    Board_array[i][flag] = vals[i];
                }
                list_choosed.add(rand);
            }

            flag = flag +2;
        }


    }
}
