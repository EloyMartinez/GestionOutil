package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "panier", schema = "gestionoutils", catalog = "")
public class MyPanierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpanier")
    private Long idpanier;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;
    @Basic
    @Column(name = "idcom")
    private Long idcom;

    public MyPanierEntity() {
    }

    public Long getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(Long idpanier) {
        this.idpanier = idpanier;
    }

    public Long getIdoutil() {
        return idoutil;
    }

    public void setIdoutil(Long idoutil) {
        this.idoutil = idoutil;
    }

    public Long getIdcom() {
        return idcom;
    }

    public void setIdcom(Long idcom) {
        this.idcom = idcom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPanierEntity that = (MyPanierEntity) o;

        if (idpanier != that.idpanier) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;
        if (idcom != null ? !idcom.equals(that.idcom) : that.idcom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idpanier;
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        result = 31 * result + (idcom != null ? idcom.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
