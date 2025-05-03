package entites;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examens")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private int durée;

    @ManyToOne(fetch = FetchType.EAGER) // Changer en Lazy si nécessaire
    private Matiere matiere;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resultat> resultats;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public Examen() {}

    public Examen(String titre, int durée, Matiere matiere) {
        this.titre = titre;
        this.durée = durée;
        this.matiere = matiere;
    }

    public Examen(String titre, int durée, Matiere matiere, Etudiant etudiant) {
        this.titre = titre;
        this.durée = durée;
        this.matiere = matiere;
        this.etudiant = etudiant;
    }

    public Examen(String titre, int durée, Matiere matiere, List<Resultat> resultats, Etudiant etudiant) {
        this.titre = titre;
        this.durée = durée;
        this.matiere = matiere;
        this.resultats = resultats;
        this.etudiant = etudiant;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDurée() {
        return durée;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Examen{id=" + id + ", titre='" + titre + "', durée=" + durée + ", matiere=" + matiere + "}";
    }
}
