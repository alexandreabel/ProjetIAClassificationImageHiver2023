package com.example.testdetectionobject14pomme;

public class Aliment {
    int no_aliment;

    String nom_aliment;

    double prix_aliment;

    public Aliment(int no_aliment, String nom_aliment, double prix_aliment)
    {
        this.no_aliment = no_aliment;
        this.nom_aliment = nom_aliment;
        this.prix_aliment = prix_aliment;
    }

    public String getNomAliment() {
        return nom_aliment;
    }

    public int getNoAliment() {
        return no_aliment;
    }

    public double getPrenom() {
        return prix_aliment;
    }

}