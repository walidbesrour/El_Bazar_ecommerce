package com.example.el_bazar_mobile.model;

public class Produits {

    private String image_produit;
    private String nom_produit;
    private String marque_produit;
    private String prix_produit;
    private String prix_bare_produit;
    private String Quantité ;

    public Produits() {
    }



    public Produits(String image_produit, String marque_produit, String nom_produit, String prix_produit, String prix_bare_produit) {
        this.image_produit = image_produit;
        this.marque_produit = marque_produit;
        this.nom_produit = nom_produit;
        this.prix_produit = prix_produit;
        this.prix_bare_produit = prix_bare_produit;
    }

    public String getImage_produit() {
        return image_produit;
    }

    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }

    public String getMarque_produit() {
        return marque_produit;
    }

    public void setMarque_produit(String marque_produit) {
        this.marque_produit = marque_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(String prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getPrix_bare_produit() {
        return prix_bare_produit;
    }

    public void setPrix_bare_produit(String prix_bare_produit) {
        this.prix_bare_produit = prix_bare_produit;
    }

    public String getQuantité() {
        return Quantité;
    }

    public void setQuantité(String quantité) {
        Quantité = quantité;
    }
}
