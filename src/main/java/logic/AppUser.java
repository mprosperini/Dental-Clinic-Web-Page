package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppUser;
    private String userName;
    private String password;
    private String userType;

    public AppUser() {
    }

    public AppUser(int idAppUser, String userName, String password, String userType) {
        this.idAppUser = idAppUser;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public int getIdAppUser() {
        return idAppUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public void setIdAppUser(int idAppUser) {
        this.idAppUser = idAppUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
    
}
