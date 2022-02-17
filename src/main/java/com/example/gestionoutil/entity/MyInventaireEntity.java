package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventaire", schema = "gestionoutils", catalog = "")
public class MyInventaireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idinv")
    private Long idinv;
    @Basic
    @Column(name = "ida")
    private Long ida;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;

    public MyInventaireEntity() {
    }

    public Long getIdinv() {
        return idinv;
    }

    public void setIdinv(Long idinv) {
        this.idinv = idinv;
    }

    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
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

        MyInventaireEntity that = (MyInventaireEntity) o;

        if (idinv != that.idinv) return false;
        if (ida != null ? !ida.equals(that.ida) : that.ida != null) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idinv;
        result = 31 * result + (ida != null ? ida.hashCode() : 0);
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
