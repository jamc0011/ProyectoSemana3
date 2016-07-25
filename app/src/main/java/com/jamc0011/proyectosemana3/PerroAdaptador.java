package com.jamc0011.proyectosemana3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jamc0011 on 21/07/2016.
 */
public class PerroAdaptador  extends RecyclerView.Adapter<PerroAdaptador.PerroViewHolder>{

    ArrayList<Perros> perros;
    Activity activity;

    public PerroAdaptador(ArrayList<Perros> perros, Activity activity){
        this.perros = perros;
        this.activity = activity;
    }


    //inflar el layout y lo pasara al viewhold para que el obtenga los views
    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perro, parent, false);
        return new PerroViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(PerroViewHolder perroViewHolder, int position) {
        final Perros perro = perros.get(position);
        perroViewHolder.imgFoto.setImageResource(perro.getFoto());
        perroViewHolder.tvNombreCV.setText(perro.getNombre());

        perroViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, perro.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetallePerros.class);
                intent.putExtra("nombre", perro.getNombre());
                activity.startActivity(intent);
            }
        });

        perroViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + perro.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    //cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static class PerroViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;

        public PerroViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
