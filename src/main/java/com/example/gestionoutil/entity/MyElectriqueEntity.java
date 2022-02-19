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
    @Column(name = "nomoutil")
    private String nomoutil;
    @Basic
    @Column(name = "puissance")
    private Long puissance;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "prix")
    private Double prix;

    public MyElectriqueEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getNomoutil() {
        return nomoutil;
    }

    public void setNomoutil(String nomoutil) {
        this.nomoutil = nomoutil;
    }

    public Long getIdelec() {
        return idelec;
    }

    public void setIdelec(Long idelec) {
        this.idelec = idelec;
    }

    public long getPuissance() {
        return puissance;
    }

    public void setPuissance(Long puissance) {
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

    public void edit(MyElectriqueEntity oldElectrique){
        if (this.idelec == null) this.idelec = oldElectrique.idelec;
        if (this.puissance == null) this.puissance = oldElectrique.puissance;
        if (this.nomoutil == null) this.nomoutil = oldElectrique.nomoutil;
        if (this.description== null) this.description = oldElectrique.description;
        if (this.prix== null) this.prix = oldElectrique.prix;

    }
}
