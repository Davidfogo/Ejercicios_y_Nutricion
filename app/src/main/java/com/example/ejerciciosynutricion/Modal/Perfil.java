package com.example.ejerciciosynutricion.Modal;

public class Perfil {

    String nom;
    int passos;
    int pes;
    int altura;
    public Perfil(){

    }

    public Perfil(String nom, int passos, int pes, int altura){
        this.nom = nom;
        this.passos = passos;
        this.pes = pes;
        this.altura = altura;
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }


    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getPassos() {
        return passos;
    }

    public void setPassos(int passos) {
        this.passos = passos;
    }
}
