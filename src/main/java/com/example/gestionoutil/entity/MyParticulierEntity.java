package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "particulier", schema = "gestionoutils", catalog = "")
public class MyParticulierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpar")
    private Long idpar;
    @Basic
    @Column(name = "mot_de_passe")
    private String motDepasse;
    @Basic
    @Column(name = "idcli")
    private Long idcli;

    public MyParticulierEntity() {
    }

    public Long getIdpar() {
        return idpar;
    }

    public void setIdpar(Long idpar) {
        this.idpar = idpar;
    }

    public String getMotDepasse() {
        return motDepasse;
    }

    public Long getIdcli() {
        return idcli;
    }

    public void setIdcli(Long idcli) {
        this.idcli = idcli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyParticulierEntity that = (MyParticulierEntity) o;

        if (idpar != that.idpar) return false;
        if (idcli != null ? !idcli.equals(that.idcli) : that.idcli != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = idpar;
        result = 31 * result + (idcli != null ? idcli.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
