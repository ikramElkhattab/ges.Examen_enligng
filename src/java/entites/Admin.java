
package entites;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
     private String role;

    public Admin() {
    }

    public Admin(String role) {
        this.role = role;
    }

    public Admin(String role, String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" + "role=" + role + '}';
    }
     
}
