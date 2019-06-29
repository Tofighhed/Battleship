package model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import network.Retrofit_Server;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class Messege {


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String status;
    @SerializedName("game id")
    private int game_id;
    private String result;
    private int code;
    private String[] detail;
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

    public String getDetail(int i) {
        return detail[i];
    }

    public void setDetail(String[] detail) {
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
//    }p
    public static Messege start_game() {
        Retrofit_Server retrofit_server = new Retrofit_Server();

        try {
            Response<Messege> m = retrofit_server.getTService().start_game().execute();
            if (m.code() > 250) {
                String error = m.errorBody().string();
                Gson gson = new Gson();
                return gson.fromJson(error, Messege.class);
            }
            else {Game.game_id=m.body().getGame_id();
                return m.body();}
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "\nBody Is Empty");
        } catch (java.net.UnknownHostException e) {
            System.out.println(e.getMessage() + "\nCannot Connect to Network");
        } catch (IOException N) {
            N.printStackTrace();
        }
        return null;
    }

//    public static Messege st_gm(){
//        Retrofit_Server retrofit_server = new Retrofit_Server();
//        retrofit_server.getTService().start_game().enqueue(new Callback<Messege>() {
//            @Override
//            public void onResponse(Call<Middle> call, Response<Middle> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Middle> call, Throwable throwable) {
//
//            }
//        }
//    }

    ////////////////////////////////////////////////////
    public static Messege get_status() {
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {
            Response<Messege> m = retrofit_server.getTService().get_status(Game.game_id).execute();
            if (m.body() == null) {
                System.out.println("Respons wass NUll ");
                System.out.println(m.message());
            } else {
                return m.body();
            }
//            if (mm.message.length > 0) {
//                System.out.println("message : " + m.body().message[0]);
//                System.out.println("code : " + m.body().code);
//            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "\nBody Is Empty");
        } catch (java.net.UnknownHostException e) {
            System.out.println(e.getMessage() + "\nCannot Connect to Network");
        } catch (IOException N) {
            N.printStackTrace();
        }
        return null;

    }

    public static Messege move(Pos pso) {
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {
            Response<Messege> m = retrofit_server.getTService().move(pso).execute();
            if (m.body() == null) {
                System.out.println("Respons wass NUll ");
                System.out.println(m.message());
                return m.body();
            } else {
                return m.body();
            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "\nBody Is Empty");
        } catch (java.net.UnknownHostException e) {
            System.out.println(e.getMessage() + "\nCannot Connect to Network");
        } catch (IOException N) {
            N.printStackTrace();
        }
        return null;
    }



    public static Messege init_game(Ground ground){
        Retrofit_Server retrofit_server= new Retrofit_Server();
        try {
            Response<Messege> m =retrofit_server.getTService().init_game(ground).execute();
            if (m.body() == null) {
                System.out.println("Respons wass NUll ");
                System.out.println(m.message());
                return m.body();
            } else {
                return m.body();
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "\nBody Is Empty");
        } catch (java.net.UnknownHostException e) {
            System.out.println(e.getMessage() + "\nCannot Connect to Network");
        } catch (IOException N) {
            N.printStackTrace();
        }
        return null;
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


//    public void check_start_game() {
//    "result": "game created",
//        check=Messege.start_game();
//        this=Messege.start_game();
//        if (this.getDetail(0).equalsIgnoreCase("You have an unfinished game.")){
//            System.out.println(this.getDetail(0));
//            return;
//        }
//        if (this.getStatus().equalsIgnoreCase("ok")) {
//            System.out.println("game created");
//        }
//        if (this.getCode() == 400) {
//            System.out.println(this.getDetail(0));
//        }
//    }
//
//    public void check_status() {
//        Messege check = this;
//        if (check.getCode() == 1) {
//            //rival find
//            //send your board
//        }
//        if (check.getCode() == 2) {
//            //messege:waiting for your rival board
//        }
//        if (check.getCode() == 3) {
//            //messege : its your hit
//            //last hit:[n,m]
//        }
//
//        if (check.getCode() == 4) {
//            //messege:waiting for your rival move
//        }
//        if (check.getCode() == 5) {
//            //messege : game is finished
//            //winner playerx
//        }
//        if (check.getCode() == 6) {
//            //messege : cancelld by user
//        }
//    }

}






















