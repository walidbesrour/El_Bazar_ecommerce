package com.example.el_bazar_mobile.model;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class ProduitDTO {


    private String username ;
    private String password ;
    private String id_token ;

    public ProduitDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
