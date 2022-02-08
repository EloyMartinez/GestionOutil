package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin", schema = "gestionoutils", catalog = "")
public class MyAdminEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idad")
    private int idad;
    @Basic
    @Column(name = "courrieladmin")
    private String courrieladmin;
    @Basic
    @Column(name = "nomad")
    private String nomad;
    @Basic
    @Column(name = "prenomad")
    private String prenomad;
    @Basic
    @Column(name = "mdpadmin")
    private String mdpadmin;
    @Basic
    @Column(name = "ida")
    private Integer ida;

    public int getIdad() {
        return idad;
    }

    public void setIdad(int idad) {
        this.idad = idad;
    }

    public String getCourrieladmin() {
        return courrieladmin;
    }

    public void setCourrieladmin(String courrieladmin) {
        this.courrieladmin = courrieladmin;
    }

    public String getNomad() {
        return nomad;
    }

    public void setNomad(String nomad) {
        this.nomad = nomad;
    }

    public String getPrenomad() {
        return prenomad;
    }

    public void setPrenomad(String prenomad) {
        this.prenomad = prenomad;
    }

    public String getMotDepasse() {
        return mdpadmin;
    }

    public Integer getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyAdminEntity that = (MyAdminEntity) o;

        if (idad != that.idad) return false;
        if (nomad != null ? !nomad.equals(that.nomad) : that.nomad != null) return false;
        if (prenomad != null ? !prenomad.equals(that.prenomad) : that.prenomad != null) return false;
        if (ida != null ? !ida.equals(that.ida) : that.ida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idad;
        result = 31 * result + (nomad != null ? nomad.hashCode() : 0);
        result = 31 * result + (prenomad != null ? prenomad.hashCode() : 0);
        result = 31 * result + (ida != null ? ida.hashCode() : 0);
        return result;
    }
}
