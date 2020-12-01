package com.example.el_bazar_mobile.model;

public class Nouveau_Produit {


    private String image;
    private String marque;
    private String produit;
    private String prix;

    public Nouveau_Produit() {
        super();
    }

    public Nouveau_Produit(String image, String marque, String produit, String prix) {
        this.image = image;
        this.marque = marque;
        this.produit = produit;
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
