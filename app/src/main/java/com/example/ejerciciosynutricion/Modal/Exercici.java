package com.example.ejerciciosynutricion.Modal;

import android.media.Image;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class Exercici  implements Serializable {

    String Nombre;
    String dificultad;
    String tiempo;
    public String color;
    public String status;
    public  String segundonombre;
    String tipo;

    public Exercici(){

    }

    public Exercici(String color, String nom, String segundonombre){
        this.color = color;
        this.Nombre = nom;
        this.status = status;
        this.segundonombre = segundonombre;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


// crear la classe exercici
// Mirar el vídeo https://www.youtube.com/watch?v=WeoryL3XyA4&ab_channel=SimplifiedCoding
// Intentar fer un log dels exercicis de tipus cardio
// Omplir totes les opcions del perfil (modificant la classe perfil)