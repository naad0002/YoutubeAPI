package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnjava=(Button)findViewById(R.id.button1);
        Button btnmovie=(Button)findViewById(R.id.button2);
        Button btntv=(Button)findViewById(R.id.button3);
        Button btnsong=(Button)findViewById(R.id.button4);

        btnjava.setOnClickListener(this);
        btnmovie.setOnClickListener(this);
        btntv.setOnClickListener(this);
        btnsong.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent=null;

        switch(v.getId()){

            case R.id.button1:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID1);
break;
            case R.id.button2:
                intent=YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID2);
                break;
            case R.id.button3:
                intent=YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID3);
                break;
            case R.id.button4:
                intent=YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID4);
                break;
        }

if(intent!=null){
    startActivity(intent);
}

    }
}
