package entity;

import javax.persistence.*;

@Entity
@Table(name = "achat", schema = "gestionoutils", catalog = "")
public class MyAchatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idachat")
    private int idachat;
    @Basic
    @Column(name = "idcom")
    private Integer idcom;

    public int getIdachat() {
        return idachat;
    }

    public void setIdachat(int idachat) {
        this.idachat = idachat;
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

        MyAchatEntity that = (MyAchatEntity) o;

        if (idachat != that.idachat) return false;
        if (idcom != null ? !idcom.equals(that.idcom) : that.idcom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idachat;
        result = 31 * result + (idcom != null ? idcom.hashCode() : 0);
        return result;
    }
}
