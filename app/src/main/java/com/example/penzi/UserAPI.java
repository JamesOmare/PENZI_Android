package com.example.penzi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {

    //relative url
    @GET("get_incoming_messages")
    Call<List<Post>> getPosts();
}
