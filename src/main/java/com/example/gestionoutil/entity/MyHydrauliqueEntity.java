package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "hydraulique", schema = "gestionoutils", catalog = "")
public class MyHydrauliqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idhyd")
    private Long idhyd;
    @Basic
    @Column(name = "nomoutil")
    private String nomoutil;
    @Basic
    @Column(name = "pression")
    private Long pression;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "prix")
    private Double prix;

    public MyHydrauliqueEntity() {
    }

    public Long getIdhyd() {
        return idhyd;
    }

    public void setIdhyd(Long idhyd) {
        this.idhyd = idhyd;
    }

    public String getNomoutil() {
        return nomoutil;
    }

    public void setNomoutil(String nomoutil) {
        this.nomoutil = nomoutil;
    }

    public Long getPression() {
        return pression;
    }

    public void setPression(Long pression) {
        this.pression = pression;
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

        MyHydrauliqueEntity that = (MyHydrauliqueEntity) o;

        if (idhyd != that.idhyd) return false;
        if (pression != null ? !pression.equals(that.pression) : that.pression != null) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idhyd;
        result = 31 * result + (pression != null ? pression.hashCode() : 0);
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
