package com.prolaw.domain;
import javax.persistence.*;

@Entity
@Table(name = "notificacion")
public class Notification {
    
    @Override
    public String toString() {
        return "Notifications [idNots=" + idNots + ", idUser=" + idUser + ", label=" + label + ", read=" + read + "]";
    }
    public long getIdNots() {
        return idNots;
    }
    public void setIdNots(long idNots) {
        this.idNots = idNots;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public Boolean getRead() {
        return read;
    }
    public void setRead(Boolean read) {
        this.read = read;
    }
    public Notification(String idUser, String label) {
        this.idUser = idUser;
        this.label = label;
        this.read = false;
    }
    @Id
    @SequenceGenerator(name ="GRADES_IDS_GENERATORS", sequenceName = "public.grade_grades_ids_seqs", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRADES_IDS_GENERATORS")
    @Column(name = "id_not")
    private long idNots;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "descripcion_ans")
    private String label;
    @Column(name = "read_ans")
    private Boolean read;
}
