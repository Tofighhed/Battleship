package model;

import com.google.gson.Gson;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {

    public Log(){}
private static ArrayList<Log> log_inf=new ArrayList<>();
    private  int[][]boardarray;

    public int[][] getBoardarray() {
        return boardarray;
    }

    public static void add_log (Log log){
        log_inf.add(log);
        log.save_on_file();
    }

    public static ArrayList<Log> getLog_inf(){
        return log_inf;
    }

    public void setBoardarray(int[][] boardarray) {
        this.boardarray = boardarray;
    }

    private String status;
    private  int  game_id;
    private String result;
    private int code;
    private String[] detail;
    private String rival;
    private String message;
    private String last_hits;
    private String winner;
    private String time;






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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String[] getDetail() {
        return detail;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLast_hits() {
        return last_hits;
    }

    public void setLast_hits(String last_hits) {
        this.last_hits = last_hits;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }


    public void save_on_file (){
        try {
            OutputStream obj = new FileOutputStream("log.txt" , true);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            time =  dateFormat.format(date);
            Gson gson = new Gson();
            String data = gson.toJson(this);
            obj.write(data.getBytes());
            obj.write("\n".getBytes()); //Better View in File
            obj.flush();
            obj.close();
            System.out.println("Writen to file : " + data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
