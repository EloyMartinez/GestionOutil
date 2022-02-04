package entity;

import javax.persistence.*;

@Entity
@Table(name = "location", schema = "gestionoutils", catalog = "")
public class MyLocationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idloc")
    private int idloc;
    @Basic
    @Column(name = "idcom")
    private Integer idcom;

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
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

        MyLocationEntity that = (MyLocationEntity) o;

        if (idloc != that.idloc) return false;
        if (idcom != null ? !idcom.equals(that.idcom) : that.idcom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idloc;
        result = 31 * result + (idcom != null ? idcom.hashCode() : 0);
        return result;
    }
}
