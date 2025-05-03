package entites;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "findBetweenDate", query = "from Etudiant where dateNaissance between :d1 and :d2"),
    @NamedQuery(name = "findByExamen", query = "FROM Examen e WHERE e.etudiant.id = :id")
})
@NamedNativeQuery(
    name = "findExamenByUserId",  
    query = "SELECT e.* FROM examens e INNER JOIN resultats r ON e.id = r.examen_id WHERE r.etudiant_id = :id",
    resultClass = Examen.class
)

@Table(name = "etudiants")
public class Etudiant extends User {

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.EAGER)
    private List<Examen> examens;

    public Etudiant() {
    }

    public Etudiant(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Etudiant(Date dateNaissance, String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "dateNaissance=" + dateNaissance + ", examens=" + examens + '}';
    }

}
