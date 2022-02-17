package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "manuel", schema = "gestionoutils", catalog = "")
public class MyManuelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmanuel")
    private Long idmanuel;
    @Basic
    @Column(name = "idoutil")
    private Long idoutil;

    public MyManuelEntity() {
    }

    public Long getIdmanuel() {
        return idmanuel;
    }

    public void setIdmanuel(Long idmanuel) {
        this.idmanuel = idmanuel;
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

        MyManuelEntity that = (MyManuelEntity) o;

        if (idmanuel != that.idmanuel) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idmanuel;
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
