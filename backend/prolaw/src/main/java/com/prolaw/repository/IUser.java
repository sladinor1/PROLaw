package com.prolaw.repository; 


import java.util.*;
import javax.imageio.ImageIO;


//@Entity
//@Table( name = "USUARIO", schema = "public")
public interface IUser {

    /*
    @Id
    @Column( name = "ID_USUARIO" )
    private Integer id;

    @Column( name = "NOMBRE_USUARIO" )
    private String nameUser;
    @Column( name = "APELLIDO_USUARIO" )
    private String lastnameUser;
    @Column( name = "TELEFONO_USUARIO" )
    private String numberUser;
    @Column( name = "EMAIL_USUARIO" )
    private String emailUser;
    @Column( name = "CONTRASEÑA_USUARIO" )
    private String passwordUser;

    private ImageIO photoUser;
*/
    void register(String user);
};