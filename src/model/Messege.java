package model;

import network.Retrofit_Server;
import retrofit2.Response;

import java.io.IOException;

public class Messege {


    private String status;
    private int game_id;
    private int code;
    private String detail;
    private String rival;
    private String[] message;
    private String[] last_hit[];
    private String winner;
    private Boolean ship;
    private boolean win;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public String[][] getLast_hit() {
        return last_hit;
    }

    public void setLast_hit(String[][] last_hit) {
        this.last_hit = last_hit;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Boolean getShip() {
        return ship;
    }

    public void setShip(Boolean ship) {
        this.ship = ship;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }


//    public static void get_messege (){
//        Retrofit_Server retrofit_server=new Retrofit_Server();
//        retrofit_server.getTService().get_status(44).enqueue(new Callback<Middle>(){
//
//            @Override
//            public void onResponse(Call<Middle> call, Response<Middle> response) {
//                // tozih ...
//                //                    response.errorBody()
//                if (response.isSuccessful()){
//                    System.out.println("SIZE : " + response.body().messeges.size());
//                    System.out.println("First : " + response.body().messeges.get(0).code );
//                    System.out.println(response.body());
//                }else {
//                    System.out.println("UN Successs fool!");
//                }
//
//                }
//
//            @Override
//            public void onFailure(Call<Middle> call, Throwable throwable) {
//                System.out.println("EXCEPTION : " + throwable.getMessage());
//            }
//        });
//
//
//
//
//
//    }

    public static void get_status2() {
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {
            Response<Messege> m = retrofit_server.getTService().get_status(42).execute();
//            System.out.println("SIZE : " + m.body().messeges.size());
            if (m.body() == null) {
                System.out.println("Respons wass NUll ");
                System.out.println(m.message());
                return;
            }
            Messege mm = m.body();
            if (mm.message.length > 0)
                System.out.println("message : " + m.body().message[0]);
            System.out.println("code : " + m.body().code);
//            System.out.println("First : " + m.body().messeges.get(0).message);

        } catch (IOException N) {
            N.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "4as5d4");
        }

    }
//        Retrofit_Server retrofit_server = new Retrofit_Server();
//        retrofit_server.getTService().get_category().enqueue(new Callback<Middle>() {
//            @Override
//            public void onResponse(Call<Middle> call, Response<Middle> response) {
//                if (response.isSuccessful()){
////                    response.body() // what we want ....
//                    System.out.println("SIZE : " + response.body().data.size());
//                    System.out.println("First : " + response.body().data.get(0).name );
//                    System.out.println("First : " + response.body().data.get(0).id );
//                    System.out.println("First : " + response.body().data.get(0).updated_at );
//
//                    System.out.println(response.body());
//                }else {
//                    // tozih ...
////                    response.errorBody()
//                    System.out.println("UN Successs fool!");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Middle> call, Throwable throwable) {
//                System.out.println("EXCEPTION : " + throwable.getMessage());
//            }
//        });

}






















