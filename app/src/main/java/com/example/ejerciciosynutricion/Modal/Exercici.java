package com.example.ejerciciosynutricion.Modal;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class Exercici {

    String nom;
    int dificultat;
    double tiempo;
    public String color;
    public String status;
    public  String segundonombre;
   // ImageView icono;
    public Exercici(String color, String nom, /*String status,*/ String segundonombre /*ImageView icono */){
        this.color = color;
        this.nom = nom;
        this.status = status;
        this.segundonombre = segundonombre;
        //this.icono=icono;
    }

   /* public ImageView getIcono() {
        return icono;
    }

    public void setIcono(ImageView icono) {
        this.icono = icono;
    }*/

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDificultat() {
        return dificultat;
    }

    public void setDificultat(int dificultat) {
        this.dificultat = dificultat;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
}


// crear la classe exercici
// Mirar el vídeo https://www.youtube.com/watch?v=WeoryL3XyA4&ab_channel=SimplifiedCoding
// Intentar fer un log dels exercicis de tipus cardio
// Omplir totes les opcions del perfil (modificant la classe perfil)