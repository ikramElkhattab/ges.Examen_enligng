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

@Entity
@Table(name = "etudiants")
public class Etudiant extends User {

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @OneToMany(mappedBy = "etudiant")
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

}
