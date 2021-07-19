package com.prolaw.domain;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "subarea")
public class Subcategory {
    
    public Subcategory() {
    }

    public Subcategory(long idSubcat, String nameSubcat, String descripSubcat, String idsProcedu) {
        this.idSubcat = idSubcat;
        this.nameSubcat = nameSubcat;
        this.descripSubcat = descripSubcat;
        this.idsProcedu = idsProcedu;
    }

    public long getIdSubcat() {
        return idSubcat;
    }

    public void setIdSubcat(long idSubcat) {
        this.idSubcat = idSubcat;
    }

    public String getNameSubcat() {
        return nameSubcat;
    }

    public void setNameSubcat(String nameSubcat) {
        this.nameSubcat = nameSubcat;
    }

    public String getDescripSubcat() {
        return descripSubcat;
    }

    public void setDescripSubcat(String descripSubcat) {
        this.descripSubcat = descripSubcat;
    }

    public String getIdsProcedu() {
        return idsProcedu;
    }

    public void setIdsProcedu(String idsProcedu) {
        this.idsProcedu = idsProcedu;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return "Subcategory [descripSubcat=" + descripSubcat + ", idSubcat=" + idSubcat + ", idsProcedu=" + idsProcedu
                + ", nameSubcat=" + nameSubcat + "]";
    }

    @Id
    @Column(name = "id_sub")
    private long idSubcat;
    @Column(name = "nombre_sub")
    private String nameSubcat;
    @Column(name = "descripcion_sub")
    private String descripSubcat;
    @Column(name = "tramites")
    private String idsProcedu;

    @OneToMany
    private List<Procedure> procedures;


}
