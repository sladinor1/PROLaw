package com.prolaw.domain;

import javax.persistence.*;

@Entity
@Table( name = "normatividad")
public class Normativity {

    public Long getIdNor() {
        return idNor;
    }
    public void setIdNor(Long idNor) {
        this.idNor = idNor;
    }
    public String getNameNor() {
        return nameNor;
    }
    public void setNameNor(String nameNor) {
        this.nameNor = nameNor;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    @Override
    public String toString() {
        return "Normativity [idNor=" + idNor + ", link=" + link + ", nameNor=" + nameNor + "]";
    }
    public Normativity(Long idNor, String nameNor, String link) {
        this.idNor = idNor;
        this.nameNor = nameNor;
        this.link = link;
    }

    public Normativity() {
    }
    @Id
    @Column(name = "id_nor")
    private Long idNor;
    @Column(name = "nombre_nor")
    private String nameNor;
    @Column(name = "link")
    private String link;

    
    
}
