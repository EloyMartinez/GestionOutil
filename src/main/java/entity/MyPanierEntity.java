package entity;

import javax.persistence.*;

@Entity
@Table(name = "panier", schema = "gestionoutils", catalog = "")
public class MyPanierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpanier")
    private int idpanier;
    @Basic
    @Column(name = "idoutil")
    private Integer idoutil;
    @Basic
    @Column(name = "idcom")
    private Integer idcom;

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public Integer getIdoutil() {
        return idoutil;
    }

    public void setIdoutil(Integer idoutil) {
        this.idoutil = idoutil;
    }

    public Integer getIdcom() {
        return idcom;
    }

    public void setIdcom(Integer idcom) {
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
        int result = idpanier;
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        result = 31 * result + (idcom != null ? idcom.hashCode() : 0);
        return result;
    }
}
