package entity;

import javax.persistence.*;

@Entity
@Table(name = "manuel", schema = "gestionoutils", catalog = "")
public class MyManuelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmanuel")
    private int idmanuel;
    @Basic
    @Column(name = "idoutil")
    private Integer idoutil;

    public int getIdmanuel() {
        return idmanuel;
    }

    public void setIdmanuel(int idmanuel) {
        this.idmanuel = idmanuel;
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

        MyManuelEntity that = (MyManuelEntity) o;

        if (idmanuel != that.idmanuel) return false;
        if (idoutil != null ? !idoutil.equals(that.idoutil) : that.idoutil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmanuel;
        result = 31 * result + (idoutil != null ? idoutil.hashCode() : 0);
        return result;
    }
}
