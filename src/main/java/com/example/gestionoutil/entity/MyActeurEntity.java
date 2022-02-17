package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "acteur", schema = "gestionoutils", catalog = "")
public class MyActeurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ida")
    private Long ida;
    @Basic
    @Column(name = "noma")
    private String noma;
    @Basic
    @Column(name = "prenoma")
    private String prenoma;

    public MyActeurEntity(String noma, String prenoma) {
        this.noma = noma;
        this.prenoma = prenoma;
    }

    public MyActeurEntity() {
    }

    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public String getPrenoma() {
        return prenoma;
    }

    public void setPrenoma(String prenoma) {
        this.prenoma = prenoma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyActeurEntity that = (MyActeurEntity) o;

        if (ida != that.ida) return false;
        if (noma != null ? !noma.equals(that.noma) : that.noma != null) return false;
        if (prenoma != null ? !prenoma.equals(that.prenoma) : that.prenoma != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = ida;
        result = 31 * result + (noma != null ? noma.hashCode() : 0);
        result = 31 * result + (prenoma != null ? prenoma.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
