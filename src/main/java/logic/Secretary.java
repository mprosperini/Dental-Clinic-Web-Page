package logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Secretary extends Person implements Serializable {
    
    //private int idSecretary;
    private String workingSector;
    @OneToOne
    private AppUser anAppUser;

    public Secretary() {
    }

    public Secretary(String workingSector, AppUser anAppUser, int idPerson, String firstName, String secondName, String dni, Date birthDate, String cellphone, String address) {
        super(idPerson, firstName, secondName, dni, birthDate, cellphone, address);
        this.workingSector = workingSector;
        this.anAppUser = anAppUser;
    }

    public String getWorkingSector() {
        return workingSector;
    }

    public AppUser getAnAppUser() {
        return anAppUser;
    }

    public void setWorkingSector(String workingSector) {
        this.workingSector = workingSector;
    }

    public void setAnAppUser(AppUser anAppUser) {
        this.anAppUser = anAppUser;
    }
    
    
}
