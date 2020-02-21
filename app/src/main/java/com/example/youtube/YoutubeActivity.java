package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static android.content.ContentValues.TAG;

public class YoutubeActivity extends YouTubeBaseActivity
                             implements YouTubePlayer.OnInitializedListener {
static final String GOOGLE_API_KEY="AIzaSyDtwlrM3JCTfw_NOwwFI1QaLvFJjwHmKxc" ;
static final String YOUTUBE_VIDEO_ID1="r59xYe3Vyks";
    static final String YOUTUBE_VIDEO_ID2="u7YwxRz_eE4";
    static final String YOUTUBE_VIDEO_ID3="81znEpRT0_s";
    static final String YOUTUBE_VIDEO_ID4="iZSeO8rI_Ig";
static final String YOUTUBE_PLAYLIST="PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al";

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: "+provider.getClass().toString());
        Toast.makeText(this,"Initialized Youtube player successfully",Toast.LENGTH_LONG).show();
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID1);
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID2);
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID3);
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID4);
        }



    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        final int REQUEST_CODE=1;

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();

        }else
        {
            String errorMessage =String.format("There was an error initializing the Youtubrplayer(%1$s)",youTubeInitializationResult.toString());
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        }



    }


    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this,"Playing",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this,"Paused",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(YoutubeActivity.this,"Stopped",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBuffering(boolean b) {
      if(b){
          Toast.makeText(YoutubeActivity.this,"Buffering",Toast.LENGTH_LONG).show();
      }
else{
          Toast.makeText(YoutubeActivity.this,"Not Bufferening",Toast.LENGTH_LONG).show();
      }
        }

        @Override
        public void onSeekTo(int i) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //  setContentView(R.layout.activity_youtube);
      //  ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.activity_youtube);

        ConstraintLayout layout=(ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(layout);

//        Button button1=new Button(this);
//        button1.setText("Added Button");
//        button1.setLayoutParams(new ConstraintLayout.LayoutParams(300,800));
//        layout.addView(button1);


        YouTubePlayerView playerView=new YouTubePlayerView(this);

      playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
      layout.addView(playerView);
playerView.initialize(GOOGLE_API_KEY,this);

    }
}
