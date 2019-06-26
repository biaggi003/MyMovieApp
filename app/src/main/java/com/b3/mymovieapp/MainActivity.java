package com.b3.mymovieapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
                onClick(movies.get(i));
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
           movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

    public void onClick(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
        intent.putExtra(DetailMovieActivity.extra_name, movie.getName());
        intent.putExtra(DetailMovieActivity.extra_desc, movie.getDescription());
        intent.putExtra(DetailMovieActivity.extra_photo, movie.getPhoto());
        startActivity(intent);
    }
}