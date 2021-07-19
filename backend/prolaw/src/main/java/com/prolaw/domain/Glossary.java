package com.prolaw.domain;

import javax.persistence.*;

@Entity
@Table( name = "glosario")
public class Glossary {
    
    public Glossary() {
    }

    public Glossary(Long idGlo, String nameGlo, String descripGlo, char initial) {
        this.idGlo = idGlo;
        this.nameGlo = nameGlo;
        this.descripGlo = descripGlo;
        this.initial = initial;
    }

    public Long getIdGlo() {
        return idGlo;
    }

    public void setIdGlo(Long idGlo) {
        this.idGlo = idGlo;
    }

    public String getNameGlo() {
        return nameGlo;
    }

    public void setNameGlo(String nameGlo) {
        this.nameGlo = nameGlo;
    }

    public String getDescripGlo() {
        return descripGlo;
    }

    public void setDescripGlo(String descripGlo) {
        this.descripGlo = descripGlo;
    }

    public char getInitial() {
        return initial;
    }

    public void setInitial(char initial) {
        this.initial = initial;
    }

    @Override
    public String toString() {
        return "Glossary [descripGlo=" + descripGlo + ", idGlo=" + idGlo + ", initial=" + initial + ", nameGlo="
                + nameGlo + "]";
    }
    
    @Id
    @Column(name = "id_glo")
    private Long idGlo;
    @Column(name = "nombre_glo")
    private String nameGlo;
    @Column(name = "descripcion_glo")
    private String descripGlo;
    @Column(name = "inicial_glo")
    private char initial;
    
}
