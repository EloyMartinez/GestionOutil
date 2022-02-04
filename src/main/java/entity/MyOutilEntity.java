package entity;

import javax.persistence.*;

@Entity
@Table(name = "outil", schema = "gestionoutils", catalog = "")
public class MyOutilEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idoutil")
    private int idoutil;
    @Basic
    @Column(name = "nomoutil")
    private String nomoutil;
    @Basic
    @Column(name = "prixdevente")
    private Integer prixdevente;
    @Basic
    @Column(name = "prixdelocation")
    private Integer prixdelocation;
    @Basic
    @Column(name = "stock")
    private Integer stock;
    @Basic
    @Column(name = "nbAvis")
    private Integer nbAvis;
    @Basic
    @Column(name = "nbEtoile")
    private Integer nbEtoile;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "commentaires")
    private String commentaires;

    public int getIdoutil() {
        return idoutil;
    }

    public void setIdoutil(int idoutil) {
        this.idoutil = idoutil;
    }

    public String getNomoutil() {
        return nomoutil;
    }

    public void setNomoutil(String nomoutil) {
        this.nomoutil = nomoutil;
    }

    public Integer getPrixdevente() {
        return prixdevente;
    }

    public void setPrixdevente(Integer prixdevente) {
        this.prixdevente = prixdevente;
    }

    public Integer getPrixdelocation() {
        return prixdelocation;
    }

    public void setPrixdelocation(Integer prixdelocation) {
        this.prixdelocation = prixdelocation;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNbAvis() {
        return nbAvis;
    }

    public void setNbAvis(Integer nbAvis) {
        this.nbAvis = nbAvis;
    }

    public Integer getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(Integer nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyOutilEntity that = (MyOutilEntity) o;

        if (idoutil != that.idoutil) return false;
        if (nomoutil != null ? !nomoutil.equals(that.nomoutil) : that.nomoutil != null) return false;
        if (prixdevente != null ? !prixdevente.equals(that.prixdevente) : that.prixdevente != null) return false;
        if (prixdelocation != null ? !prixdelocation.equals(that.prixdelocation) : that.prixdelocation != null)
            return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (nbAvis != null ? !nbAvis.equals(that.nbAvis) : that.nbAvis != null) return false;
        if (nbEtoile != null ? !nbEtoile.equals(that.nbEtoile) : that.nbEtoile != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (commentaires != null ? !commentaires.equals(that.commentaires) : that.commentaires != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idoutil;
        result = 31 * result + (nomoutil != null ? nomoutil.hashCode() : 0);
        result = 31 * result + (prixdevente != null ? prixdevente.hashCode() : 0);
        result = 31 * result + (prixdelocation != null ? prixdelocation.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (nbAvis != null ? nbAvis.hashCode() : 0);
        result = 31 * result + (nbEtoile != null ? nbEtoile.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (commentaires != null ? commentaires.hashCode() : 0);
        return result;
    }
}
