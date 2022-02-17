package com.example.gestionoutil.entity;

import javax.persistence.*;

@Entity
@Table(name = "entreprise", schema = "gestionoutils", catalog = "")
public class MyEntrepriseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iden")
    private Long iden;
    @Basic
    @Column(name = "numeroSIREN")
    private String numeroSiren;
    @Basic
    @Column(name = "idcli")
    private Long idcli;

    public MyEntrepriseEntity() {
    }

    public Long getIden() {
        return iden;
    }

    public void setIden(Long iden) {
        this.iden = iden;
    }

    public String getNumeroSiren() {
        return numeroSiren;
    }

    public void setNumeroSiren(String numeroSiren) {
        this.numeroSiren = numeroSiren;
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

        MyEntrepriseEntity that = (MyEntrepriseEntity) o;

        if (iden != that.iden) return false;
        if (numeroSiren != null ? !numeroSiren.equals(that.numeroSiren) : that.numeroSiren != null) return false;
        if (idcli != null ? !idcli.equals(that.idcli) : that.idcli != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = iden;
        result = 31 * result + (numeroSiren != null ? numeroSiren.hashCode() : 0);
        result = 31 * result + (idcli != null ? idcli.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
