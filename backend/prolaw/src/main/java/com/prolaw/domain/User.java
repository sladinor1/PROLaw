package com.prolaw.domain;

import javax.persistence.*;

/* Atributos
id usuario long
nombre usuario
apellido usuario
telefono usuario
email usuario
contraeña usuario
foto usuario
*/

@Entity
@Table(name="USUARIO")
public class User {
    //Primary Key
    @Id
    private Long idUser;

    private String nameUser;
    private String lastNameUser;
    private String celUser;
    private String emailUser;
    private String passUser;
    //private ImageIO photoUser;
    
    protected User() {
    }

    public User(Long idUser ,String nameUser, String lastNameUser, String celUser, String emailUser, String passUser) {
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
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

    @Override
    public String toString() {
        return "User [celUser=" + celUser + ", emailUser=" + emailUser + ", idUser=" + idUser + ", identificationUser="
                 + ", lastNameUser=" + lastNameUser + ", nameUser=" + nameUser + ", passUser="
                + passUser + "]";
    }
    
    

    

};