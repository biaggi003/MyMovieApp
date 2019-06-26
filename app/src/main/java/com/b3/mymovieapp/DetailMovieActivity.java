package com.b3.mymovieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    public final static String extra_name = "name";
    public final static String extra_desc = "desc";
    public final static String extra_photo = "photo";

    TextView NameDetail, DescDetail;
    ImageView PhotoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra(extra_name));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        NameDetail = findViewById(R.id.detail_name);
        DescDetail = findViewById(R.id.detail_desc);
        PhotoDetail = findViewById(R.id.detail_photo);

        String data1, data2, data3, data4, data5;
        Intent intent = getIntent();

        data1 = intent.getStringExtra(extra_name);
        data2 = intent.getStringExtra(extra_desc);
        data3 = intent.getStringExtra(extra_photo);

        NameDetail.setText(data1);
        DescDetail.setText(data2);
        Glide.with(this)
                .load(data3)
                .into(PhotoDetail);
    }
}