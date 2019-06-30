package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message2 {

    @SerializedName("message") // old message is list!
    public String message ;
    public int cod;
    public List<String> detail;
    public String status;


}
