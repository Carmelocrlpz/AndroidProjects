package com.example.carmelo.apk1carmelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt;
        final TextView txt2;
        final EditText edt;
        final Button btn1;
        final Button btn2;

        txt = (TextView)findViewById(R.id.texto);
        txt2 = (TextView)findViewById(R.id.texto2);
        edt = (EditText)findViewById(R.id.ingresar);
        btn1 = (Button)findViewById(R.id.lanzar);
        btn2 = (Button)findViewById(R.id.cambiar);

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt2.setText("hola " + edt.getText());
            }
        });

       final Intent i = new Intent(getApplicationContext(), Main2Activity.class);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                i.putExtra("Titulo", edt.getText());
                startActivity(i);

            }
        });









    }
}
