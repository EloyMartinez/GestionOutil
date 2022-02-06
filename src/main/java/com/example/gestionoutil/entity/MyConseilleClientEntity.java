package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "conseilleclient", schema = "gestionoutils", catalog = "")
public class MyConseilleClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idco")
    private int idco;
    @Basic
    @Column(name = "nomco")
    private String nomco;
    @Basic
    @Column(name = "prenomco")
    private String prenomco;
    @Basic
    @Column(name = "ida")
    private Integer ida;

    public int getIdco() {
        return idco;
    }

    public void setIdco(int idco) {
        this.idco = idco;
    }

    public String getNomco() {
        return nomco;
    }

    public void setNomco(String nomco) {
        this.nomco = nomco;
    }

    public String getPrenomco() {
        return prenomco;
    }

    public void setPrenomco(String prenomco) {
        this.prenomco = prenomco;
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

        MyConseilleClientEntity that = (MyConseilleClientEntity) o;

        if (idco != that.idco) return false;
        if (nomco != null ? !nomco.equals(that.nomco) : that.nomco != null) return false;
        if (prenomco != null ? !prenomco.equals(that.prenomco) : that.prenomco != null) return false;
        if (ida != null ? !ida.equals(that.ida) : that.ida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idco;
        result = 31 * result + (nomco != null ? nomco.hashCode() : 0);
        result = 31 * result + (prenomco != null ? prenomco.hashCode() : 0);
        result = 31 * result + (ida != null ? ida.hashCode() : 0);
        return result;
    }
}
