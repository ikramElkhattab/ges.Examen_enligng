
package entites;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@Table(name = "matieres")
@NamedNativeQuery(
    name = "Matiere.findExamensByMatiereId",
    query = "SELECT e.* FROM examen e WHERE e.matiere_id = :matiereId",
    resultClass = Examen.class
)
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Examen>examens;

    public Matiere() {
    }

    public Matiere(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
    
     
}
