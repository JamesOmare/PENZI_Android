package com.example.penzi;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8010/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserAPI userAPI = retrofit.create(UserAPI.class);

        Call<List<Post>> call = userAPI.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " +response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts){
                    String content = "";
                    content += "delivery_time: " + post.getDelivery_time() + "\n";
                    content += "id: " + post.getId() + "\n";
                    content += "message: " + post.getMessage() + "\n";
                    content += "sender_number: " + post.getSender_number() + "\n";
                    content += "shortcode: " + post.getShortcode() + "\n";
                    content += "status: " + post.getStatus() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }
}