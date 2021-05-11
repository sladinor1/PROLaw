package com.prolaw.domain;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tramite")
public class Procedure {

    public Procedure() {
    }

    public List<Normativity> getNormativity() {
        return normativity;
    }

    public void setNormativity(List<Normativity> normativity) {
        this.normativity = normativity;
    }

    public long getIdPro() {
        return idPro;
    }

    public void setIdPro(long idPro) {
        this.idPro = idPro;
    }

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public String getDescripPro() {
        return descripPro;
    }

    public void setDescripPro(String descripPro) {
        this.descripPro = descripPro;
    }

    public String getActionPro() {
        return actionPro;
    }

    public void setActionPro(String actionPro) {
        this.actionPro = actionPro;
    }

    public String getPlacePro() {
        return placePro;
    }

    public void setPlacePro(String placePro) {
        this.placePro = placePro;
    }

    public String getIdsNorma() {
        return idsNorma;
    }

    public void setIdsNorma(String idsNorma) {
        this.idsNorma = idsNorma;
    }


    @Override
    public String toString() {
        return "Procedure [actionPro=" + actionPro + ", descripPro=" + descripPro + ", idPro=" + idPro + ", idsNorma="
                + idsNorma + ", namePro=" + namePro + ", placePro=" + placePro + "]";
    }

    public Procedure(long idPro, String namePro, String descripPro, String actionPro, String placePro,
            String idsNorma) {
        this.idPro = idPro;
        this.namePro = namePro;
        this.descripPro = descripPro;
        this.actionPro = actionPro;
        this.placePro = placePro;
        this.idsNorma = idsNorma;
    }

    @Id
    @Column(name = "id_tra")
    private long idPro;
    @Column(name = "nombre_tra")
    private String namePro;
    @Column(name = "descripcion_tra")
    private String descripPro;
    @Column(name = "accionar_tra")
    private String actionPro;
    @Column(name = "lugar_tra")
    private String placePro;
    @Column(name = "normativas")
    private String idsNorma;

    @OneToMany
    private List<Normativity> normativity;


}
