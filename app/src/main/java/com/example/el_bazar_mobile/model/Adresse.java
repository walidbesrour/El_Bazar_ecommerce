package com.example.el_bazar_mobile.model;

public class Adresse {

     private String Gouvernorat_user ;
    private String ville_user ;
    private String localite_user ;

    public Adresse(String gouvernorat_user, String ville_user, String localite_user) {
        Gouvernorat_user = gouvernorat_user;
        this.ville_user = ville_user;
        this.localite_user = localite_user;
    }

    public String getGouvernorat_user() {
        return Gouvernorat_user;
    }

    public void setGouvernorat_user(String gouvernorat_user) {
        Gouvernorat_user = gouvernorat_user;
    }

    public String getVille_user() {
        return ville_user;
    }

    public void setVille_user(String ville_user) {
        this.ville_user = ville_user;
    }

    public String getLocalite_user() {
        return localite_user;
    }

    public void setLocalite_user(String localite_user) {
        this.localite_user = localite_user;
    }
}
