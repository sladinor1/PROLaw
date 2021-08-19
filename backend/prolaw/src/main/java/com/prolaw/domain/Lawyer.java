package com.prolaw.domain;

import javax.persistence.*;

@Entity
@Table( name = "abogado")
public class Lawyer{

    @Id
    @SequenceGenerator(name ="GRADE_GRADEID_GENERATOR", sequenceName = "public.grade_grade_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADE_GRADEID_GENERATOR")
    @Column(name="idLawyer")
    private Long idLaw;
    @Column(name="especialidades")
    private String espeLaw;
    @Column(name="firma")
    private String idFirma;
    //@OneToOne
    //@JoinColumn(name ="idUser")
    @Column(name="idUser")
    private String idUser;
    
    public Lawyer(){

    }

    public Lawyer(String espeLaw, String idFirma, String user) {
        this.espeLaw = espeLaw;
        this.idFirma = idFirma;
        this.idUser = user;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String user) {
        this.idUser = user;
    }

    public Long getIdLaw() {
        return idLaw;
    }

    public void setIdLaw(Long idLaw) {
        this.idLaw = idLaw;
    }

    public String getEspeLaw() {
        return espeLaw;
    }

    public void setEspeLaw(String espeLaw) {
        this.espeLaw = espeLaw;
    }

    public String getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(String idFirma) {
        this.idFirma = idFirma;
    }

    @Override
    public String toString() {
        return "Lawyer [espeLaw=" + espeLaw + ", idFirma=" + idFirma + ", idLaw=" + idLaw + ", user=" + idUser + "]";
    }
}
