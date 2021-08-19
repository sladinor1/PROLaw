package com.prolaw.domain;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class Answers {

    public String getNameUser() {
        return nameUser;
    }
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    @Override
    public String toString() {
        return "Answers [dateAns=" + dateAns + ", descripAns=" + descripAns + ", idAns=" + idAns + ", idUserA="
                + idUserA + ", nameUser=" + nameUser + "]";
    }
    public long getIdAns() {
        return idAns;
    }
    public void setIdAns(long idAns) {
        this.idAns = idAns;
    }
    public String getIdUserA() {
        return idUserA;
    }
    public void setIdUserA(String idUserA) {
        this.idUserA = idUserA;
    }
    public String getDescripAns() {
        return descripAns;
    }
    public void setDescripAns(String descripAns) {
        this.descripAns = descripAns;
    }
    public LocalDate getDateAns() {
        return dateAns;
    }
    public void setDateAns(LocalDate dateAns) {
        this.dateAns = dateAns;
    }
    public Answers() {
    }
    public Answers(String idUserA, String nameUser, String descripAns, LocalDate dateAns) {
        this.idUserA = idUserA;
        this.nameUser= nameUser;
        this.descripAns = descripAns;
        this.dateAns = dateAns;
    }
    @Id
    @SequenceGenerator(name ="GRADE_ID_GENERATOR", sequenceName = "public.grade_grade_id_seqs", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADE_ID_GENERATOR")
    @Column(name = "id_ans")
    private long idAns;
    @Column(name = "id_ans_user")
    private String idUserA;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "descripcion_ans")
    private String descripAns;
    @Column(name = "date_ans")
    private LocalDate dateAns;

}
