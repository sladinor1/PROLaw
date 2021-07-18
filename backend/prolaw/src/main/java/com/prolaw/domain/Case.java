package com.prolaw.domain;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "caso")
public class Case {
    public Case() {
    }

    public Case(long idCase, String idUserC, String topicCas, String descripCas, String subcatCas, Date dateAns,
            String idsAns) {
        this.idCase = idCase;
        this.idUserC = idUserC;
        this.topicCas = topicCas;
        this.descripCas = descripCas;
        this.subcatCas = subcatCas;
        this.dateAns = dateAns;
        this.idsAns = idsAns;
    }

    public String getIdsAns() {
        return idsAns;
    }

    public void setIdsAns(String idsAns) {
        this.idsAns = idsAns;
    }

    public Case(String idUserC, String topicCas, String descripCas, String subcatCas, Date dateAns) {
        this.idUserC = idUserC;
        this.topicCas = topicCas;
        this.descripCas = descripCas;
        this.subcatCas = subcatCas;
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

    public String getSubcatCas() {
        return subcatCas;
    }

    public void setSubcatCas(String subcatCas) {
        this.subcatCas = subcatCas;
    }

    public Date getDateAns() {
        return dateAns;
    }

    public void setDateAns(Date dateAns) {
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
        return "Case [answers=" + answers + ", dateAns=" + dateAns + ", descripCas=" + descripCas + ", idCase=" + idCase
                + ", idUserC=" + idUserC + ", idsAns=" + idsAns + ", subcatCas=" + subcatCas + ", topicCas=" + topicCas
                + "]";
    }

    @Id
    @SequenceGenerator(name ="GRADE_IDS_GENERATOR", sequenceName = "public.grade_grade_ids_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADE_IDS_GENERATOR")
    @Column(name = "id_case")
    private long idCase;
    @Column(name = "id_cas_user")
    private String idUserC;
    @Column(name = "topic_cas")
    private String topicCas;
    @Column(name = "descripcion_cas")
    private String descripCas;
    @Column(name = "subar_cas")
    private String subcatCas;
    @Column(name = "date_ans")
    private Date dateAns;
    @Column(name = "idAns")
    private String idsAns;
    @OneToMany
    private List<Answers> answers;
    
}
