/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author hp
 */
@Embeddable
public class ResultatID implements Serializable {
    private int examenId;
    private int etudiantId;

    public ResultatID() {
    }

    public ResultatID(int examenId, int etudiantId) {
        this.examenId = examenId;
        this.etudiantId = etudiantId;
    }

    

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultatID)) return false;
        ResultatID that = (ResultatID) o;
        return Objects.equals(examenId, that.examenId) &&
               Objects.equals(etudiantId, that.etudiantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examenId, etudiantId);
    }
}
