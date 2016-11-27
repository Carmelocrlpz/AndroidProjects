package com.example.carmelo.reproductor;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
   //private static final String SD_PATH = new String("/sdcard/");
    /*private List<String> song = new ArrayList<String>();
    private MediaPlayer mp = new MediaPlayer();*/

    ListView Lista;
    MediaPlayer mp;
    String [] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* mp = MediaPlayer.create(getApplicationContext(), R.raw.disturbed);
        final String[] music =new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, music);

        Lista = (ListView)findViewById(R.id.lista);

        Lista.setAdapter(adaptador);*/

        Lista = (ListView)findViewById(R.id.lista);

        final ArrayList<File> song = findSongs(Environment.getExternalStorageDirectory());
        items = new String[ song.size() ];
        for (int i = 0; i< song.size(); i++){
            //toast(song.get(i).getName());
            items[i] = song.get(i).getName().toString().replace(".mp3"," ").replace(".wav"," ");
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView,items);
        Lista.setAdapter(adaptador);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                startActivity(new Intent(getApplicationContext(),PlayList.class).putExtra("pos",position).putExtra("songlist",song));
            }
        });
    }

        public ArrayList<File> findSongs(File root) {
            ArrayList<File> al = new ArrayList<File>();
            File[] files= root.listFiles();
            for(File singleFile : files) {
                if(singleFile.isDirectory() && !singleFile.isHidden()){
                    al.addAll(findSongs(singleFile));
                }
                else{
                    if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                        al.add(singleFile);
                    }
                }
            }
            return al;
        }


        public void toast(String text){
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        }
    }









/*
* ImageView bas;
    Boolean bandera = false;
    MediaPlayer mp;


private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        bas = (ImageView) findViewById(R.id.basket);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.disturbed);
        // MediaPlayer mp = new MediaPlayer(this, R.raw.Disturbed);


        bas.setImageResource(R.drawable.bask10);
        bas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (bandera == false) {
                    bas.setImageResource(R.drawable.bask10);
                    bandera = true;
                    mp.start();
                } else {
                    bas.setImageResource(R.drawable.bask11);
                    bandera = false;
                    mp.pause();
                }
            }
        });

    }*/