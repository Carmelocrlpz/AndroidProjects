package com.example.carmelo.camara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    File archivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       Button btnLanzar;

        btnLanzar = (Button) findViewById(R.id.btnCamara);

        btnLanzar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

                try {
                    archivo = File.createTempFile("basket",".JPG", directorio);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Uri uriArchivo = FileProvider.getUriForFile(getApplicationContext(), "com.example.androidFileProvider", archivo);



                Intent i = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);

                i.putExtra(MediaStore.EXTRA_OUTPUT,uriArchivo);
                if (i.resolveActivity(getPackageManager())!=null) {
                    startActivityForResult(i,1);
                }


            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        ImageView ig;
        ig = (ImageView) findViewById(R.id.img);
        if (requestCode == 1 && resultCode ==RESULT_OK){
            Bitmap imagen = (Bitmap) data.getExtras().get("data");
            ig.setImageBitmap(imagen);
        }
    }
}
