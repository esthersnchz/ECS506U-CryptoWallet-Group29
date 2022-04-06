package com.company;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {
    private String date;
    private String ID;
    private String time;
    private String status;
    private String type;
    private HashMap<String, Double> Cryptos = new HashMap<>();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss z");


    public Transaction(String status,String Cryptoname, double amount, String type) {
        this.ID = idBuilder();
        this.type=type;
        this.date = dateFormatter.format(new Date()) ;
        this.time = timeFormatter.format(new Date());
        this.status = status;
        this.Cryptos.put(Cryptoname,amount);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {this.time = time;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, Double> getCryptos() {
        return Cryptos;
    }

    public void setCryptos(String name, double amount) {
        Cryptos.put(name,amount);
    }

    public String idBuilder(){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "");
        for (int i = 0; i < 5; i++)
            sb.append(chars[rnd.nextInt(chars.length)]);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID='" + ID + '\'' +
                ",Type='" + type + '\'' +
                ",Date='" + date + '\'' +
                ", Time='" + time + '\'' +
                ", Status='" + status + '\'' +
                ", Cryptos=" + Cryptos +
                '}';
    }
}
