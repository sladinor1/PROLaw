package com.prolaw.domain;

import java.util.List;

import javax.persistence.*;





@Entity
@Table(name = "area")
public class Category {

    public Category() {
    }

    public Category(long idCate, String nameCate, String descripCate, String idsSubCate) {
        this.idCate = idCate;
        this.nameCate = nameCate;
        this.descripCate = descripCate;
        this.idsSubCate = idsSubCate;
    }

    public long getIdCate() {
        return idCate;
    }

    public void setIdCate(long idCate) {
        this.idCate = idCate;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public String getDescripCate() {
        return descripCate;
    }

    public void setDescripCate(String descripCate) {
        this.descripCate = descripCate;
    }

    public String getIdsSubCate() {
        return idsSubCate;
    }

    public void setIdsSubCate(String idsSubCate) {
        this.idsSubCate = idsSubCate;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public String toString() {
        return "Category [descripCate=" + descripCate + ", idCate=" + idCate + ", idsSubCate=" + idsSubCate
                + ", nameCate=" + nameCate + "]";
    }

    @Id
    @Column(name = "id_ar")
    private long idCate;
    @Column(name = "nombre_ar")
    private String nameCate;
    @Column(name = "descripcion_ar")
    private String descripCate;
    @Column(name = "subareas")
    private String idsSubCate;

    @OneToMany
    private List<Subcategory> subcategories;


}
