package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient extends Person implements Serializable {
    
   // private int idPatient;
    private boolean healthInsurance;
    private String bloodType;
    @OneToOne
    private KidGuardian kidGuardian;
    @OneToMany(mappedBy = "patientMappedBy")
    private List<Appointment> listOfTurns;

    public Patient() {
    }

    public Patient(boolean healthInsurance, String bloodType, KidGuardian kidGuardian, List<Appointment> listOfTurns, int idPerson, String firstName, String secondName, String dni, Date birthDate, String cellphone, String address) {
        super(idPerson, firstName, secondName, dni, birthDate, cellphone, address);
        this.healthInsurance = healthInsurance;
        this.bloodType = bloodType;
        this.kidGuardian = kidGuardian;
        this.listOfTurns = listOfTurns;
    }

    public KidGuardian getKidGuardian() {
        return kidGuardian;
    }

    public List<Appointment> getListOfTurns() {
        return listOfTurns;
    }

    public boolean isHealthInsurance() {
        return healthInsurance;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setHealthInsurance(boolean healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setKidGuardian(KidGuardian kidGuardian) {
        this.kidGuardian = kidGuardian;
    }

    public void setListOfTurns(List<Appointment> listOfTurns) {
        this.listOfTurns = listOfTurns;
    }
    
    
    
    
    
    
    
    
}
