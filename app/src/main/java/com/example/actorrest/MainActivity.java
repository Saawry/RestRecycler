package com.example.actorrest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Actor> actorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.actor_recycler);

        recyclerView = findViewById(R.id.actor_recycler);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);

        Call<List<Actor>> call = RetrofitClient.getInstance().getApi().GetActorDetails();
        call.enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {
                if (response.code() == 200) {
                    actorList = response.body();
                    final ActorAdapter adapter = new ActorAdapter(actorList, getApplicationContext());

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ex: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}