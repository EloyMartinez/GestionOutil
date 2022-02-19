package com.example.gestionoutil.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client", schema = "gestionoutils", catalog = "")
public class MyClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcli", nullable = false, unique = true)
    public Long idcli;
    @Basic
    @Column(name = "nomcli")
    private String nomcli;
    @Basic
    @Column(name = "prenomcli")
    private String prenomcli;
    @Basic
    @Column(name = "datenaissancecli")
    private Date datenaissancecli;
    @Basic
    @Column(name = "adressecli")
    private String adressecli;
    @Basic
    @Column(name = "courrielcli")
    private String courrielcli;
    @Basic
    @Column(name = "telephonecli")
    private String telephonecli;
    @Basic
    @Column(name = "mdpcli")
    private String mdpcli;
    @Basic
    @Column(name = "isadmin")
    private boolean isadmin;

    public MyClientEntity() {
    }

    public MyClientEntity(String nomcli, String prenomcli, Date datenaissancecli, String adressecli, String courrielcli, String telephonecli, String mdpcli) {
        this.nomcli = nomcli;
        this.prenomcli = prenomcli;
        this.datenaissancecli = datenaissancecli;
        this.adressecli = adressecli;
        this.courrielcli = courrielcli;
        this.telephonecli = telephonecli;
        this.mdpcli = mdpcli;

    }

    public Long getIdcli() {
        return idcli;
    }

    public void setIdcli(Long idcli) {
        this.idcli = idcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getPrenomcli() {
        return prenomcli;
    }

    public void setPrenomcli(String prenomcli) {
        this.prenomcli = prenomcli;
    }

    public Date getDatenaissancecli() {
        return datenaissancecli;
    }

    public void setDatenaissancecli(Date datenaissancecli) {
        this.datenaissancecli = datenaissancecli;
    }

    public String getAdressecli() {
        return adressecli;
    }

    public void setAdressecli(String adressecli) {
        this.adressecli = adressecli;
    }

    public String getCourrielcli() {
        return courrielcli;
    }

    public void setCourrielcli(String courrielcli) {
        this.courrielcli = courrielcli;
    }

    public String getTelephonecli() {
        return telephonecli;
    }

    public void setTelephonecli(String telephonecli) {
        this.telephonecli = telephonecli;
    }

    public String getMdpcli() {
        return mdpcli;
    }

    public void setMdpcli(String mdpcli) {
        this.mdpcli = mdpcli;
    }

    public boolean getIsAdmin() {
        return isadmin;
    }

    public void setAdmin(boolean admin) {
        isadmin = admin;
    }

    public void edit(MyClientEntity oldUser){
        if (this.idcli == null) this.idcli = oldUser.idcli;
        if (this.courrielcli == null) this.courrielcli = oldUser.courrielcli;
        if (this.mdpcli == null) this.mdpcli = oldUser.mdpcli;
        if (this.prenomcli == null) this.prenomcli = oldUser.prenomcli;
        if (this.nomcli == null) this.nomcli = oldUser.nomcli;
        if (this.adressecli == null) this.adressecli = oldUser.adressecli;
        if (this.telephonecli == null) this.telephonecli = oldUser.telephonecli;
        if (this.datenaissancecli == null) this.datenaissancecli = oldUser.datenaissancecli;
        if (this.adressecli == null) this.adressecli = oldUser.adressecli;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClientEntity that = (MyClientEntity) o;

        if (idcli != that.idcli) return false;
        if (nomcli != null ? !nomcli.equals(that.nomcli) : that.nomcli != null) return false;
        if (prenomcli != null ? !prenomcli.equals(that.prenomcli) : that.prenomcli != null) return false;
        if (datenaissancecli != null ? !datenaissancecli.equals(that.datenaissancecli) : that.datenaissancecli != null)
            return false;
        if (adressecli != null ? !adressecli.equals(that.adressecli) : that.adressecli != null) return false;
        if (courrielcli != null ? !courrielcli.equals(that.courrielcli) : that.courrielcli != null) return false;
        if (telephonecli != null ? !telephonecli.equals(that.telephonecli) : that.telephonecli != null) return false;
        if (mdpcli != null ? !mdpcli.equals(that.mdpcli) : that.mdpcli != null) return false;
        if (isadmin != that.isadmin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idcli;
        result = 31 * result + (nomcli != null ? nomcli.hashCode() : 0);
        result = 31 * result + (prenomcli != null ? prenomcli.hashCode() : 0);
        result = 31 * result + (datenaissancecli != null ? datenaissancecli.hashCode() : 0);
        result = 31 * result + (adressecli != null ? adressecli.hashCode() : 0);
        result = 31 * result + (courrielcli != null ? courrielcli.hashCode() : 0);
        result = 31 * result + (telephonecli != null ? telephonecli.hashCode() : 0);
        result = 31 * result + (mdpcli != null ? mdpcli.hashCode() : 0);
        result = 31 * result + (isadmin ? 1:0);
        return Math.toIntExact(result);
    }
}
