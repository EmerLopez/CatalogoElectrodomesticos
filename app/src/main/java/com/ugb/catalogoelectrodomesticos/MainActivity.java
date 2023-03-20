package com.ugb.catalogoelectrodomesticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BD db_agenda;
    String accion="nuevo";
    String id="";
    Button btn;
    TextView temp;
    FloatingActionButton fab;
    Button idbtncamara;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idbtncamara = findViewById(R.id.idbtncamara);
        imageView2 = findViewById(R.id.imageView2);
        btn = findViewById(R.id.btnGuardar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar_agenda();
            }
        });
        fab = findViewById(R.id.fabRegresarListaProductos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresarListaAmigos();
            }
        });
        idbtncamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();

            }
        });
        mostrar_datos_amigos();


    }
    void mostrar_datos_amigos(){
        Bundle parametros = getIntent().getExtras();
        accion = parametros.getString("accion");
        if(accion.equals("modificar")){
            String amigos[] = parametros.getStringArray("amigos");
            id = amigos[0];

            temp = findViewById(R.id.txtCodigo);
            temp.setText(amigos[1]);

            temp = findViewById(R.id.txtDescripcion);
            temp.setText(amigos[2]);

            temp = findViewById(R.id.txtMarca);
            temp.setText(amigos[3]);

            temp = findViewById(R.id.txtGarantia);
            temp.setText(amigos[4]);
        }
    }
    void guardar_agenda(){
        try {
            temp = (TextView) findViewById(R.id.txtCodigo);
            String nombre = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtDescripcion);
            String direccion = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtMarca);
            String telefono = temp.getText().toString();

            temp = (TextView) findViewById(R.id.txtGarantia);
            String email = temp.getText().toString();

            db_agenda = new BD(MainActivity.this, "",null,1);
            String result = db_agenda.administrar_agenda(id, nombre, direccion, telefono, email, accion);
            String msg = result;
            if( result.equals("ok") ){
                msg = "Registro guardado con exito";
                regresarListaAmigos();
            }
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, "Error en guardar agenda: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    void regresarListaAmigos(){
        Intent iListaAmigos = new Intent(MainActivity.this, lista_productos.class);
        startActivity(iListaAmigos);
    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null){
        startActivityForResult(intent,1);
        //}
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageView2.setImageBitmap(imgBitmap);


        }
    }
}