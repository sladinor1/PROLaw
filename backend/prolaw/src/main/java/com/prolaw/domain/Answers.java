package com.prolaw.domain;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class Answers {

    @Override
    public String toString() {
        return "Answers [dateAns=" + dateAns + ", descripAns=" + descripAns + ", idAns=" + idAns + ", idUserA="
                + idUserA + "]";
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
    public Date getDateAns() {
        return dateAns;
    }
    public void setDateAns(Date dateAns) {
        this.dateAns = dateAns;
    }
    public Answers() {
    }
    public Answers(String idUserA, String descripAns, Date dateAns) {
        this.idUserA = idUserA;
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
    @Column(name = "descripcion_ans")
    private String descripAns;
    @Column(name = "date_ans")
    private Date dateAns;

}
