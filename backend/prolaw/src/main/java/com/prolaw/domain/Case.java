package com.prolaw.domain;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "caso")
public class Case {
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Case() {
    }

    public Case(long idCase, String topicCas, String descripCas) {
        this.idCase = idCase;
        this.topicCas = topicCas;
        this.descripCas = descripCas;
    }

    public String getIdsAns() {
        return idsAns;
    }

    public void setIdsAns(String idsAns) {
        this.idsAns = idsAns;
    }

    public Case(String idUserC,String name , String topicCas, String descripCas, String dateAns) {
        this.idUserC = idUserC;
        this.nameUser = name;
        this.topicCas = topicCas;
        this.descripCas = descripCas;
        this.dateAns = dateAns;
        this.idsAns = "0";
    }

    public long getIdCase() {
        return idCase;
    }

    public void setIdCase(long idCase) {
        this.idCase = idCase;
    }

    public String getIdUserC() {
        return idUserC;
    }

    public void setIdUserC(String idUserC) {
        this.idUserC = idUserC;
    }

    public String getTopicCas() {
        return topicCas;
    }

    public void setTopicCas(String topicCas) {
        this.topicCas = topicCas;
    }

    public String getDescripCas() {
        return descripCas;
    }

    public void setDescripCas(String descripCas) {
        this.descripCas = descripCas;
    }


    public String getDateAns() {
        return dateAns;
    }

    public void setDateAns(String dateAns) {
        this.dateAns = dateAns;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Case [dateAns=" + dateAns + ", descripCas=" + descripCas + ", idCase=" + idCase + ", idUserC=" + idUserC
                + ", idsAns=" + idsAns + ", nameUser=" + nameUser + ", topicCas=" + topicCas + "]";
    }

    @Id
    @SequenceGenerator(name ="GRADE_IDS_GENERATOR", sequenceName = "public.grade_grade_ids_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADE_IDS_GENERATOR")
    @Column(name = "id_case")
    private long idCase;
    @Column(name = "id_cas_user")
    private String idUserC;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "topic_cas")
    private String topicCas;
    @Column(name = "descripcion_cas")
    private String descripCas;
    @Column(name = "date_ans")
    private String dateAns;
    @Column(name = "idAns")
    private String idsAns;
    @OneToMany
    private List<Answers> answers;
    
}
