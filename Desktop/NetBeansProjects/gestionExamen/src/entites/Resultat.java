
package entites;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultats")
public class Resultat {
    @Id
    private Float note;
     @ManyToOne(fetch = FetchType.EAGER)
     private Examen examen;
     @ManyToOne(fetch = FetchType.EAGER)
     private User user;

    public Resultat() {
    }

   

    public Resultat(Float note, Examen examen, User user) {
        this.note = note;
        this.examen = examen;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   
     
}
