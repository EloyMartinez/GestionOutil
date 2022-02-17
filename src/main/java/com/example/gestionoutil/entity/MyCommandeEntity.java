package com.example.gestionoutil.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "commande", schema = "gestionoutils", catalog = "")
public class MyCommandeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcom")
    private Long idcom;
    @Basic
    @Column(name = "datedecommande")
    private Date datedecommande;
    @Basic
    @Column(name = "prix")
    private Integer prix;
    @Basic
    @Column(name = "moyenpaiement")
    private String moyenpaiement;
    @Basic
    @Column(name = "idcli")
    private Long idcli;

    public MyCommandeEntity() {
    }

    public Long getIdcom() {
        return idcom;
    }

    public void setIdcom(Long idcom) {
        this.idcom = idcom;
    }

    public Date getDatedecommande() {
        return datedecommande;
    }

    public void setDatedecommande(Date datedecommande) {
        this.datedecommande = datedecommande;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getMoyenpaiement() {
        return moyenpaiement;
    }

    public void setMoyenpaiement(String moyenpaiement) {
        this.moyenpaiement = moyenpaiement;
    }

    public Long getIdcli() {
        return idcli;
    }

    public void setIdcli(Long idcli) {
        this.idcli = idcli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyCommandeEntity that = (MyCommandeEntity) o;

        if (idcom != that.idcom) return false;
        if (datedecommande != null ? !datedecommande.equals(that.datedecommande) : that.datedecommande != null)
            return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;
        if (moyenpaiement != null ? !moyenpaiement.equals(that.moyenpaiement) : that.moyenpaiement != null)
            return false;
        if (idcli != null ? !idcli.equals(that.idcli) : that.idcli != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idcom;
        result = 31 * result + (datedecommande != null ? datedecommande.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (moyenpaiement != null ? moyenpaiement.hashCode() : 0);
        result = 31 * result + (idcli != null ? idcli.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
