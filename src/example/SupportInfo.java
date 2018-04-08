package example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SupportInfo implements Serializable
{
    @Id
    @Column (name = "first_name")
    private String first_name;
    @Column (name = "last_name")
    private String last_name;
    @Column (name = "Status")
    private String status;
    @Column (name = "Kommentarer")
    private String kommentar_support;
    @Column (name = "support_id")
    private Integer support_id;
    @Column (name = "forbrukad_tid")
    private Integer forbrukad_tid;
    @Column (name = "Datum")
    private String datum;
    @Column (name = "Kompetenser")
    private String kompetens;


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKommentar_support() {
        return kommentar_support;
    }

    public void setKommentar_support(String kommentar_support) {
        this.kommentar_support = kommentar_support;
    }

    public int getSupport_id() {
        return support_id;
    }

    public void setSupport_id(int support_id) {
        this.support_id = support_id;
    }

    public int getForbrukad_tid() {
        return forbrukad_tid;
    }

    public void setForbrukad_tid(int forbrukad_tid) {
        this.forbrukad_tid = forbrukad_tid;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKompetens() {
        return kompetens;
    }

    public void setKompetens(String kompetens) {
        this.kompetens = kompetens;
    }

//    public VAFAN(int support_id, String kompetens, String kommentar_support, String status, int forbrukad_tid) {
//        this.support_id = support_id;
//        this.kompetens = kompetens;
//        this.kommentar_support = kommentar_support;
//        this.status = status;
//        this.forbrukad_tid = forbrukad_tid;
//    }

    public SupportInfo(){}
}
