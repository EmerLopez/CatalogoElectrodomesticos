package com.ugb.catalogoelectrodomesticos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class catalogo extends AppCompatActivity {
    ListView ListViewContacto;
    List<cproducto> lst;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        ListViewContacto=findViewById(R.id.ListViewContacto);

        CustomAdapter adapter=new CustomAdapter(this, GetData());
        ListViewContacto.setAdapter(adapter);

        ListViewContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cproducto c=lst.get(i);
                Toast.makeText(getBaseContext(),c.nombre,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private List<cproducto> GetData() {
        lst=new ArrayList<>();
        lst.add(new cproducto(1,R.drawable.imgparlantes,"Parlantes Estereo","$150.00"));
        lst.add(new cproducto(2,R.drawable.imghorno,"Horno Tostador","$75.00"));
        lst.add(new cproducto(3,R.drawable.imgtv,"Tv Smart ","$600.00"));
        lst.add(new cproducto(4,R.drawable.imgplancha,"Plancha de Ropa","$80.00"));
        lst.add(new cproducto(5,R.drawable.imgcafetera,"Cafetera","$50.00"));
        lst.add(new cproducto(6,R.drawable.imgmicro,"Microondas","$105.00"));
        lst.add(new cproducto(7,R.drawable.imgrefri,"Refrigeradora","$430.00"));
        lst.add(new cproducto(7,R.drawable.imglavadora,"Lavadora","$500.00"));
        lst.add(new cproducto(7,R.drawable.imglicu,"Licuadora","$70.00"));

        return lst;
    }
    public void Regresar(View view){
        Intent Regresar = new Intent(this, Menu_principal.class);
        startActivity(Regresar);
    }

}