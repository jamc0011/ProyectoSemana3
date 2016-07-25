package com.jamc0011.proyectosemana3;

/**
 * Created by jamc0011 on 22/07/2016.
 */
public class Perros {
    private String nombre;
    private int foto;

    public Perros(int foto, String nombre) {
        this.foto = foto;

        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
