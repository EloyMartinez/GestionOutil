package entity;

import javax.persistence.*;

@Entity
@Table(name = "acteur", schema = "gestionoutils", catalog = "")
public class MyActeurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ida")
    private int ida;
    @Basic
    @Column(name = "noma")
    private String noma;
    @Basic
    @Column(name = "prenoma")
    private String prenoma;

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public String getPrenoma() {
        return prenoma;
    }

    public void setPrenoma(String prenoma) {
        this.prenoma = prenoma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyActeurEntity that = (MyActeurEntity) o;

        if (ida != that.ida) return false;
        if (noma != null ? !noma.equals(that.noma) : that.noma != null) return false;
        if (prenoma != null ? !prenoma.equals(that.prenoma) : that.prenoma != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ida;
        result = 31 * result + (noma != null ? noma.hashCode() : 0);
        result = 31 * result + (prenoma != null ? prenoma.hashCode() : 0);
        return result;
    }
}
