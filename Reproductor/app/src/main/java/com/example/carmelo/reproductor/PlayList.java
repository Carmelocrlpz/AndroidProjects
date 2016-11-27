package com.example.carmelo.reproductor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


import java.io.File;
import java.util.ArrayList;

public class PlayList extends AppCompatActivity implements View.OnClickListener {


    ArrayList<File> song;
    MediaPlayer mp;
    SeekBar sb;
    Button btnPause, btnPlay, btnStop, btnNext, btnBack;
    int position;
    Uri u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_list);

        btnPlay = (Button) findViewById(R.id.btnplay);
        btnPause = (Button) findViewById(R.id.btnpause);
        btnStop = (Button) findViewById(R.id.btnstop);
        btnNext = (Button) findViewById(R.id.btnnext);
        btnBack = (Button) findViewById(R.id.btnback);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        song = (ArrayList) b.getParcelableArrayList("songlist");
        position =b.getInt("pos", 0);

        u = Uri.parse(song.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(),u);
        mp.start();






    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.btnplay:
                if (mp.isPlaying()){
                    mp.pause();
                    /*if(mp.stop()) {

                    } else {
                        u = Uri.parse(song.get(position).toString());
                        mp = MediaPlayer.create(getApplicationContext(),u);
                        mp.start();
                    }*/

                } else {
                    mp.start();

                }


                break;


            case R.id.btnpause:
                mp.pause();
                break;
            case R.id.btnstop:
                mp.stop();
                break;
            case R.id.btnnext:
                mp.stop();
                mp.release();
                position = (position+1)%song.size();
                u = Uri.parse(song.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(),u);
                mp.start();
                break;
            case R.id.btnback:
                mp.stop();
                mp.release();
                position = (position-1<0)? song.size()-1: position -1;
                u = Uri.parse(song.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(),u);
                mp.start();
                break;




        }
    }
}
