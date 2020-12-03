package com.example.el_bazar_mobile.model;

public class Categorie {
    String categorie_principale ;
    String sous_categorie ;

    public Categorie() {
        super();
    }


    public Categorie(String categorie_principale, String sous_categorie) {
        this.categorie_principale = categorie_principale;
        this.sous_categorie = sous_categorie;
    }

    public Categorie(String categorie_principale) {
        this.categorie_principale = categorie_principale;
    }


    public String getCategorie_principale() {
        return categorie_principale;
    }

    public void setCategorie_principale(String categorie_principale) {
        this.categorie_principale = categorie_principale;
    }

    public String getSous_categorie() {
        return sous_categorie;
    }

    public void setSous_categorie(String sous_categorie) {
        this.sous_categorie = sous_categorie;
    }
}
