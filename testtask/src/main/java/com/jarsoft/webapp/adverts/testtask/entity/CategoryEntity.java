package com.jarsoft.webapp.adverts.testtask.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Create Table CategoryEntity in MySQL Database
@Entity

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCategory;
    private String name;
    private String IdRequest;

    @ManyToMany(mappedBy = "categories")

    List<BannerEntity> banners = new ArrayList<>();

    public CategoryEntity() {
    }


    public CategoryEntity(String name, String idRequest) {
        this.name=name;
        this.IdRequest=idRequest;
    }

    public List<BannerEntity> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerEntity> banners) {
        this.banners = banners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(Long idCategory) {
        IdCategory = idCategory;
    }

    public String getIdRequest() {
        return IdRequest;
    }

    public void setIdRequest(String idRequest) {
        IdRequest = idRequest;
    }
}