package entity;

import javax.persistence.*;

@Entity
@Table(name = "inventaire", schema = "gestionoutils", catalog = "")
public class MyInventaireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idinv")
    private int idinv;
    @Basic
    @Column(name = "ida")
    private Integer ida;
    @Basic
    @Column(name = "idoutil")
    private Integer idoutil;

    public int getIdinv() {
        return idinv;
    }

    public void setIdinv(int idinv) {
        this.idinv = idinv;
    }

    public Integer getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
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

        MyInventaireEntity that = (MyInventaireEntity) o;

        if (idinv != that.idinv) return false;
        if (ida != null ? !ida.equals(that.ida) : that.ida != null) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idinv;
        result = 31 * result + (ida != null ? ida.hashCode() : 0);
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return result;
    }
}
