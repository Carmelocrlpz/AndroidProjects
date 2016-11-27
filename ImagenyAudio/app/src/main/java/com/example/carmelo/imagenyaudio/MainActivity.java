package com.example.carmelo.imagenyaudio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    ImageView bas;
    Boolean bandera = false;
    MediaPlayer mp;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
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

    }
}




