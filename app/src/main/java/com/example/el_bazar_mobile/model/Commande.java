package com.example.el_bazar_mobile.model;

public class Commande {

    private String Num_Commande ;
    private int Total ;
    private String Status ;

    public Commande() {
        super();
    }

    public Commande(String num_Commande, int total, String status) {
        Num_Commande = num_Commande;
        Total = total;
        Status = status;
    }

    public String getNum_Commande() {
        return Num_Commande;
    }

    public void setNum_Commande(String num_Commande) {
        Num_Commande = num_Commande;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
