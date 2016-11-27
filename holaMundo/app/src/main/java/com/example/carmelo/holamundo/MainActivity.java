package com.example.carmelo.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt;
        final Button btn;

        //Obtenemos una referencia a los controles de la interfaz
        txt = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt.setText("hola "+ " Carmelo");
            }
        });





    }
}
