package entites;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultats")
public class Resultat {

   
    private Float note;
    @EmbeddedId
    private ResultatID id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Examen examen;
    @ManyToOne(fetch = FetchType.EAGER)
    private Etudiant etudiant;

    public Resultat() {
    }

    public Resultat(Float note, ResultatID id, Examen examen, Etudiant etudiant) {
        this.note = note;
        this.id = id;
        this.examen = examen;
        this.etudiant = etudiant;
    }

  

    public ResultatID getId() {
        return id;
    }

    public void setId(ResultatID id) {
        this.id = id;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

   
}
