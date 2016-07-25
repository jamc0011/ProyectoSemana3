package com.jamc0011.proyectosemana3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Perros> perros;
    private RecyclerView listaPerros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaPerros = (RecyclerView) findViewById(R.id.rvPerros);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        // GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaPerros.setLayoutManager(llm);
        inicializarListaPerros();
        inicializarAdaptador();

    }

    public PerroAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new PerroAdaptador(perros, this);
        listaPerros.setAdapter(adaptador);
    }

    public void inicializarListaPerros(){
        perros= new ArrayList<Perros>();

        perros.add(new Perros(R.drawable.dog_portraits_gardens_08,"Dina"));
        perros.add(new Perros(R.drawable.funny_baby_and_puppy_in_yard_thumb,"Diente"));
        perros.add(new Perros(R.drawable.labrador_retriever_tl1,"Canela"));
        perros.add(new Perros(R.drawable.sad_puppy,"Rayo"));
        perros.add(new Perros(R.drawable.saturday_23rd_july_16_introduction_dog_body_langu_53,"Sultan"));



    }
}