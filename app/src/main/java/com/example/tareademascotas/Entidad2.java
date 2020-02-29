package com.example.tareademascotas;

import android.os.Parcel;
import android.os.Parcelable;

public class Entidad2 implements Parcelable {

    private int imgFoto;
    private String nombre;
    private String rating;

    public Entidad2(int imgFoto, String nombre, String rating) {
        this.imgFoto = imgFoto;
        this.nombre = nombre;
        this.rating = rating;
    }

    public void setImgFoto(int imgFoto) {
        this.imgFoto = imgFoto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    protected Entidad2(Parcel in) {
    }

    public static final Creator<Entidad2> CREATOR = new Creator<Entidad2>() {
        @Override
        public Entidad2 createFromParcel(Parcel in) {
            return new Entidad2(in);
        }

        @Override
        public Entidad2[] newArray(int size) {
            return new Entidad2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
