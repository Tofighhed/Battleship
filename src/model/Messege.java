package model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import retrofit2.Response;
import sample.Cga;
import Controller.GroundController;

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
    @SerializedName("last hits")
    private String last_hits;
    int[][] real_last_hit;

    public int[][] getReal_last_hit() {
        return real_last_hit;
    }

    public void setReal_last_hit(int[][] real_last_hit) {
        this.real_last_hit = real_last_hit;
    }

    private String winner;
    private boolean ship = false;
    private boolean win = false;


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

    public String getLast_hit() {
        return last_hits;
    }

    public void setLast_hit(String last_hit) {
        this.last_hits = last_hit;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean getShip() {
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
            } else {
                Game.game_id = m.body().getGame_id();

                GroundController.ground1.game_id = Game.game_id;
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
//    public static Messege get_status() {
//        Retrofit_Server retrofit_server = new Retrofit_Server();
//        try {
//            Response<Messege> m = retrofit_server.getTService().get_status(Game.game_id).execute();
//            if (m.body() == null) {
//                System.out.println("Respons wass NUll ");
//                System.out.println(m.message());
//            } else {
//                return m.body();
//            }
////            if (mm.message.length > 0) {
////                System.out.println("message : " + m.body().message[0]);
////                System.out.println("code : " + m.body().code);
////            }
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage() + "\nBody Is Empty");
//        } catch (java.net.UnknownHostException e) {
//            System.out.println(e.getMessage() + "\nCannot Connect to Network");
//        } catch (IOException N) {
//            N.printStackTrace();
//        }
//        return null;
//
//    }

    public static Messege move(Pos pso) {
        pso = GroundController.my_pos;
        System.out.println("MOVE API x: " + pso.x + "y: " + pso.y + "game_id: " + pso.game_id);
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {
            Response<Messege> m = retrofit_server.getTService().move(GroundController.my_pos).execute();
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


    public static Messege init_game() {
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {
            Response<Messege> m = retrofit_server.getTService().init_game(GroundController.ground1).execute();
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
        } catch (JsonSyntaxException s) {
            System.out.println("lets do it");
            return null;
        }
        return null;
    }

    public static Message2 quite_game() {
        Cga cga = new Cga(Game.game_id);
        Retrofit_Server retrofit_server = new Retrofit_Server();
        try {

            Response<Message2> m = retrofit_server.getTService().quite_game(cga).execute();
            if (m.body() == null) {
                Gson gson = new Gson();
                Message2 messege = gson.fromJson(m.errorBody().string(), Message2.class);
//                Analysis.check = messege;
                Analysis.check_quit(messege);
                // FIXME: 30/06/2019 ANALYSIS MESSAGE 2
                return messege;
            } else {
                // FIXME: 30/06/2019 ANALYSIS MESSAGE 2

                System.out.println("QUIT RESPONS : " + m.body().message);
                if (m.body().detail != null)
                    System.out.println("QUIT RESPONS : " + m.body().detail.get(0));
//                Analysis.check = m.body();
                return m.body();

            }
        } catch (java.net.UnknownHostException e) {
            System.out.println(e.getMessage() + "\nCannot Connect to Network");
        } catch (NullPointerException n) {
            System.out.println("Nuuuuuuuuuuuuul");

        } catch (IOException e) {
            e.printStackTrace();
        }

    return null;
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
