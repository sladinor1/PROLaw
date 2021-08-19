package com.prolaw.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.*;


@Entity
@Table(name="usuario")
public class User {
    
    //Primary Key
    @Id
    private String idUser;
    @Column(name = "typeIdUser")
    private String typeIdUser;
    @Column(name = "nameUser")
    private String nameUser;
    @Column(name = "lastNameUser")
    private String lastNameUser;
    @Column(name = "celUser")
    private String celUser;
    @Column(name =  "emailUser")
    private String emailUser;
    @Column(name = "passUser")
    private String passUser;
    @Column(name = "idCity")
    private String idCity;

    @Enumerated(EnumType.STRING)
    @Column(name="auth_provider")
    private Provider provider;

    //U -> Usuario  ; A -> Administrador ; L -> Abogado
    @Column(name="rol")
    private String rol;
   
    public User(String idUser, String typeIdUser, String nameUser, String lastNameUser, String celUser,
            String emailUser, String passUser, String idCity, Provider provider, String rol) {
        this.idUser = idUser;
        this.typeIdUser = typeIdUser;
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.celUser = celUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
        this.idCity = idCity;
        this.provider = provider;
        this.rol = rol;
    }

    

    public User() {
    }

    

    public User(String idUser , String nameUser, String lastNameUser, String celUser, String emailUser, String passUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.celUser = celUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
    }

    public User( String nameUser, String lastNameUser, String celUser, String emailUser, String passUser) {
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.celUser = celUser;
        this.emailUser = emailUser;
        this.passUser = passUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getCelUser() {
        return celUser;
    }

    public void setCelUser(String celUser) {
        this.celUser = celUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public Provider getProvider() {        return provider;    }

    public void setProvider(Provider provider) {        this.provider = provider;    }

    public String getTypeIdUser() {        return typeIdUser;    }

    public void setTypeIdUser(String typeIdUser) {        this.typeIdUser = typeIdUser;    }

    public String getIdCity() {        return idCity;    }

    public void setIdCity(String idCity) {        this.idCity = idCity;    }

    public String getRol() {
        return rol;
    }



    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "User [celUser=" + celUser + ", emailUser=" + emailUser + ", idCity=" + idCity + ", idUser=" + idUser
                + ", lastNameUser=" + lastNameUser + ", nameUser=" + nameUser + ", passUser=" + passUser + ", provider="
                + provider + ", rol=" + rol + ", typeIdUser=" + typeIdUser + "]";
    }


};