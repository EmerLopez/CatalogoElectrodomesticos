package com.ugb.catalogoelectrodomesticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

    }
    public void Abrirlista(View view){
        Intent Abrir = new Intent(this, lista_productos.class);
        startActivity(Abrir);
    }

    public void AbrirCatalogo(View view){
        Intent acatalogo = new Intent(this, catalogo.class);
        startActivity(acatalogo);
    }
}