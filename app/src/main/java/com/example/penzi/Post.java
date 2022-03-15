package com.example.penzi;


import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Post {

    private Date delivery_time;
    private int id;
    private String message;
    private String sender_number;
    private String shortcode;
    private String status;


    public Date getDelivery_time() {
        return delivery_time;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSender_number() {
        return sender_number;
    }

    public String getShortcode() {
        return shortcode;
    }

    public String getStatus() {
        return status;
    }
}
