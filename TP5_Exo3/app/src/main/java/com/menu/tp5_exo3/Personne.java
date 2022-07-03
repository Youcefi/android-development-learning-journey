package com.menu.tp5_exo3;

public class Personne {

    private String nom;
    private String fonction;

    public Personne(String nom, String fonction) {
        this.nom = nom;
        this.fonction = fonction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", fonction='" + fonction + '\'' +
                '}';
    }
}
