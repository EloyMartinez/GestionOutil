package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "electrique", schema = "gestionoutils", catalog = "")
public class MyElectriqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idelec")
    private Long idelec;
    @Basic
    @Column(name = "nomOutil")
    private String nomOutil;
    @Basic
    @Column(name = "puissance")
    private Double puissance;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;

    public MyElectriqueEntity() {
    }

    public void setNomOutil(String nomOutil) {
        this.nomOutil = nomOutil;
    }

    public String getNomOutil() {
        return nomOutil;
    }

    public Long getIdelec() {
        return idelec;
    }

    public void setIdelec(Long idelec) {
        this.idelec = idelec;
    }

    public Double getPuissance() {
        return puissance;
    }

    public void setPuissance(Double puissance) {
        this.puissance = puissance;
    }

    public Long getIdoutil() {
        return idoutil;
    }

    public void setIdoutil(Long idoutil) {
        this.idoutil = idoutil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyElectriqueEntity that = (MyElectriqueEntity) o;

        if (idelec != that.idelec) return false;
        if (puissance != null ? !puissance.equals(that.puissance) : that.puissance != null) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idelec;
        result = 31 * result + (puissance != null ? puissance.hashCode() : 0);
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
