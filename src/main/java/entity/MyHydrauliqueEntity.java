package entity;

import javax.persistence.*;

@Entity
@Table(name = "hydraulique", schema = "gestionoutils", catalog = "")
public class MyHydrauliqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idhyd")
    private int idhyd;
    @Basic
    @Column(name = "pression")
    private Double pression;
    @Basic
    @Column(name = "idoutil")
    private Integer idoutil;

    public int getIdhyd() {
        return idhyd;
    }

    public void setIdhyd(int idhyd) {
        this.idhyd = idhyd;
    }

    public Double getPression() {
        return pression;
    }

    public void setPression(Double pression) {
        this.pression = pression;
    }

    public Integer getIdoutil() {
        return idoutil;
    }

    public void setIdoutil(Integer idoutil) {
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
        int result = idhyd;
        result = 31 * result + (pression != null ? pression.hashCode() : 0);
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return result;
    }
}
