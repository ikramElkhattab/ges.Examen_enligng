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
    private int userId;

    public ResultatID() {
    }

    public ResultatID(int examenId, int userId) {
        this.examenId = examenId;
        this.userId = userId;
    }

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultatID)) return false;
        ResultatID that = (ResultatID) o;
        return Objects.equals(examenId, that.examenId) &&
               Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examenId, userId);
    }
}
