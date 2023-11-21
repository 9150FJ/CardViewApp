package com.cifpceuta.cardviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> elementos = new ArrayList<>();
    RecyclerView recyclerView;
    Toolbar toolbar;
    Item_adapter adapter;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elementos.add("Palabra");
        elementos.add("Texto");
        elementos.add("Alfombra");
        elementos.add("teclado");
        elementos.add("Lampara");
        elementos.add("Silla");
        elementos.add("Coche");
        elementos.add("Movil");
        elementos.add("Persona");
        elementos.add("Monitor");
        elementos.add("Mesa");
        elementos.add("Casa");
        elementos.add("Montaña");
        elementos.add("Templo");
        elementos.add("Sol");
        elementos.add("Luna");
        elementos.add("Cabeza");
        elementos.add("Manos");
        elementos.add("Luz");
        elementos.add("Electricidad");
        for (int i=0;i<20;i++){
           // elementos.add("Elemento: "+i);
        }



        adapter = new Item_adapter(elementos);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        //onOptionsItemSelected(menu.getItem(0));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //boolean flag;
        int id=item.getItemId();
        if (id==R.id.opcion1){
            Toast.makeText(this, "Mensaje", Toast.LENGTH_SHORT).show();  //ASCENDENTE
            elementos.sort((o1, o2) -> o2.compareTo(o1));
            adapter.notifyDataSetChanged();
            flag=true;


        }
        else if(id==R.id.opcion2){
            //flag=false;
            //DESCENDENTE
            elementos.sort((o1, o2) -> o1.compareTo(o2));
            adapter.notifyDataSetChanged();
            flag=false;
            //Collections.reverseOrder();

        }
        else if(id==R.id.opcion3){

            if (flag){
                elementos.sort((o1, o2) -> o2.compareTo(o1));

                flag=false;
            }else if(!flag){
                elementos.sort((o1, o2) -> o1.compareTo(o2));

                flag=true;
            }
            adapter.notifyDataSetChanged();



            //ALTERNAR

        }
        return true;
    }
}
