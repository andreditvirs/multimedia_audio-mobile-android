package com.uwika.multimediaaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    MediaPlayer mp;
    AssetFileDescriptor afd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.tombolPlay);
        mp = new MediaPlayer();

        try{
            afd = this.getAssets().openFd("a.mp3");
            mp.setDataSource(afd.getFileDescriptor());
            mp.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(View v){
        if(mp.isPlaying()){
            mp.pause();
            imageButton.setImageResource(R.drawable.play);
            Toast.makeText(this, "Music is paused!", Toast.LENGTH_LONG).show();
        }else{
            mp.start();
            imageButton.setImageResource(R.drawable.pause);
            Toast.makeText(this, "Music is played!", Toast.LENGTH_LONG).show();
        }
    }
}