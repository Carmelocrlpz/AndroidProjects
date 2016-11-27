package com.example.carmelo.apk1carmelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final CheckBox rbut;
        final TextView txt;

        txt = (TextView)findViewById(R.id.texto);
        rbut = (CheckBox)findViewById(R.id.rb);

        rbut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            boolean checked = ((CheckBox) rbut).isChecked();

                if(checked){

                    txt.setText("Bienvenido ");
                }else{
                    txt.setText("Adios");

                }


            }
        });
    }


   /* @Override
    protected void onClick() {
        super.onClick();
        Intent i = getIntent();
        i.getExtras();

    }*/
}
