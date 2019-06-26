package model;

import com.google.gson.JsonElement;
import network.Retrofit_Server;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class Category {

    /*{
            "product_count": 114,
            "id": 56,
            "name": "مواد غذایی",
            "description": null,
            "priority": 14,
            "updated_at": "1398-3-14"
        }*/

    public int product_count ;
    public int id;
    public String name;
    public String description;
    public int priority;
    public String updated_at;

//    public static void get_cats (){
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
//
//    }
//    public static void get_cats2 (){
//        Retrofit_Server retrofit_server = new Retrofit_Server();
//        try {
//            Response<Middle> m = retrofit_server.getTService().get_category().execute();
//            System.out.println("SIZE : " + m.body().data.size());
//            System.out.println("First : " + m.body().data.get(0).name );
//            System.out.println("First : " + m.body().data.get(0).id );
//            System.out.println("First : " + m.body().data.get(0).updated_at );
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
