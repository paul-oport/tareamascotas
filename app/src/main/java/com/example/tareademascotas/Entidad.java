package com.example.tareademascotas;

import java.io.Serializable;

public class Entidad implements Comparable<Entidad>  {

    private int imgFoto;
    private String nombre;
    private String rating;

    public Entidad(int imgFoto, String nombre, String rating) {
        this.imgFoto = imgFoto;
        this.nombre = nombre;
        this.rating = rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRating() {
        return rating;
    }


     public int compareTo(Entidad otraEntidad) {

        if (Integer.parseInt(this.rating)>Integer.parseInt(otraEntidad.getRating())){
            return -1;
        }
        else if (Integer.parseInt(this.rating)<Integer.parseInt(otraEntidad.getRating())){
            return 1;
        }
       else return 0;

    }
}