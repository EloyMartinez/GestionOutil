package entity;

import javax.persistence.*;

@Entity
@Table(name = "particulier", schema = "gestionoutils", catalog = "")
public class MyParticulierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpar")
    private int idpar;
    @Basic
    @Column(name = "idcli")
    private Integer idcli;

    public int getIdpar() {
        return idpar;
    }

    public void setIdpar(int idpar) {
        this.idpar = idpar;
    }

    public Integer getIdcli() {
        return idcli;
    }

    public void setIdcli(Integer idcli) {
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
        int result = idpar;
        result = 31 * result + (idcli != null ? idcli.hashCode() : 0);
        return result;
    }
}
