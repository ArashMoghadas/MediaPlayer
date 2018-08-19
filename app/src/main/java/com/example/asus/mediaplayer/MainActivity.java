package com.example.asus.mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mMediaPlayer;
    /*private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        mMediaPlayer.pause();
                    }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        mMediaPlayer.start();
                    }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        releaseMediaPlayer();
                    }
                }
            };*/

    /*private MediaPlayer.OnCompletionListener mOnCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    });*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> name = new ArrayList<>();
        name.add(getString(R.string.singer));

        ListView musicListView = findViewById(R.id.lv_music);

        myAdapter adapter = new myAdapter(this, name);
        musicListView.setAdapter(adapter);

        /* mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE); */
        mMediaPlayer = MediaPlayer.create(this, R.raw.readyforit);

        ImageView play = findViewById(R.id.play_btn);
        play.setOnClickListener(this);

        ImageView pause = findViewById(R.id.pause_btn);
        pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.play_btn:
                    mMediaPlayer.start();
                break;
            case R.id.pause_btn:
                mMediaPlayer.pause();
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if  (mMediaPlayer != null)
            mMediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        }
    }

    /*private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }*/
}

