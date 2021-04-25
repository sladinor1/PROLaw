package com.prolaw.domain;

import javax.persistence.*;

@Entity
@Table( name = "Abogado")
public class Lawyer extends User{

    
    @Id
    private String idLaw;
    @Column(name="especialidades")
    private String espeLaw;
    @Column(name="firma")
    private String idFirma;
    
    public Lawyer(String idUser, String typeIdUser, String nameUser, String lastNameUser, String celUser,
    String emailUser, String passUser, String idCity, Provider provider, String rol, String idLaw,
    String espeLaw, String idFirma) {
        super(idUser, typeIdUser, nameUser, lastNameUser, celUser, emailUser, passUser, idCity, provider, rol);
        this.idLaw = idLaw;
        this.espeLaw = espeLaw;
        this.idFirma = idFirma;
    }
    
    

    public String getIdLaw() {
        return idLaw;
    }

    public void setIdLaw(String idLaw) {
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
        return "Lawyer [espeLaw=" + espeLaw + ", idFirma=" + idFirma + ", idLaw=" + idLaw + "]";
    }
}
