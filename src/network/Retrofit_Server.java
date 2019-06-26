package network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Date;

public class Retrofit_Server {

    private Requests mTService;
    private Retrofit mRetrofitClient;


    /**
     * config Retrofit in initialization
     */
    public Retrofit_Server() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //create new gson object to define custom converter on Date type
        Gson gson = new GsonBuilder().create();

        mRetrofitClient = new Retrofit.Builder()
                .baseUrl(ClientConfigs.REST_API_BASE_URL) // set Base URL , should end with '/'
                .client(httpClient.build()) // add http client
                .addConverterFactory(GsonConverterFactory.create(gson))//add gson converter
                .build();
        mTService = mRetrofitClient.create(Requests.class);
    }



    /**
     * can get Retrofit Service
     *
     * @return
     */
    public Requests getTService() {
        return mTService;
    }

    /**
     * get Retrofit client
     * used in ErrorUtil class
     *
     * @return
     */
    public Retrofit getRetrofitClient() {
        return mRetrofitClient;
    }


}
