package com.example.carmelo.imagenaudio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView bas;
    Boolean bandera = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bas = (ImageView) findViewById(R.id.basket);

        bas.setImageResource(R.drawable.bask10);
        bas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if (bandera == false){
                    bas.setImageResource(R.drawable.bask10);
                    bandera = true;
                } else {
                    bas.setImageResource(R.drawable.bask11);
                    bandera = false;
                }
            }
        });

    }
}
