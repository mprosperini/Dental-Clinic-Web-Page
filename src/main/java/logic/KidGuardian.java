package logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class KidGuardian extends Person implements Serializable{
    
    //private int idKidGuardian;
    private String relationType;
    @OneToOne
    private Patient aPatient;

    public KidGuardian() {
    }

    public KidGuardian(String relationType, Patient aPatient, int idPerson, String firstName, String secondName, String dni, Date birthDate, String cellphone, String address) {
        super(idPerson, firstName, secondName, dni, birthDate, cellphone, address);
        this.relationType = relationType;
        this.aPatient = aPatient;
    }

    public String getRelationType() {
        return relationType;
    }

    public Patient getaPatient() {
        return aPatient;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public void setaPatient(Patient aPatient) {
        this.aPatient = aPatient;
    }
    
    
    
    
    
}
