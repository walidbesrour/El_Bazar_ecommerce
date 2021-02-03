package com.example.el_bazar_mobile.model;

import com.google.gson.annotations.SerializedName;

public class SlidesDTO {
    @SerializedName("id")
    private Long id_DTO;

    @SerializedName("nom")
    private String nom_DTO;

    @SerializedName("image")
    private String image_DTO;

    @SerializedName("imageContentType")
    private String imageContentType_DTO;

    @SerializedName("type")
    private String type_DTO;

    @SerializedName("lien")
    private String lien_DTO;

    @SerializedName("imageUrl")
    private String imageUrl_DTO;

    public Long getId_DTO() {
        return id_DTO;
    }

    public void setId_DTO(Long id_DTO) {
        this.id_DTO = id_DTO;
    }

    public String getNom_DTO() {
        return nom_DTO;
    }

    public void setNom_DTO(String nom_DTO) {
        this.nom_DTO = nom_DTO;
    }

    public String getImage_DTO() {
        return image_DTO;
    }

    public void setImage_DTO(String image_DTO) {
        this.image_DTO = image_DTO;
    }

    public String getImageContentType_DTO() {
        return imageContentType_DTO;
    }

    public void setImageContentType_DTO(String imageContentType_DTO) {
        this.imageContentType_DTO = imageContentType_DTO;
    }

    public String getType_DTO() {
        return type_DTO;
    }

    public void setType_DTO(String type_DTO) {
        this.type_DTO = type_DTO;
    }

    public String getLien_DTO() {
        return lien_DTO;
    }

    public void setLien_DTO(String lien_DTO) {
        this.lien_DTO = lien_DTO;
    }

    public String getImageUrl_DTO() {
        return imageUrl_DTO;
    }

    public void setImageUrl_DTO(String imageUrl_DTO) {
        this.imageUrl_DTO = imageUrl_DTO;
    }
}
