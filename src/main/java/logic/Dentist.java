package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dentist extends Person implements Serializable {
    
//private int  idDentist ;
private String specialty ;
@OneToOne
private AppUser appUser;
@OneToOne
private Schedule schedule;
@OneToMany(mappedBy = "dentistMapedBy")
private List<Appointment> listOfTurns;

    public Dentist() {
    }

    public Dentist(String specialty, AppUser appUser, Schedule schedule, List<Appointment> listOfTurns, int idPerson, String firstName, String secondName, String dni, Date birthDate, String cellphone, String address) {
        super(idPerson, firstName, secondName, dni, birthDate, cellphone, address);
        this.specialty = specialty;
        this.appUser = appUser;
        this.schedule = schedule;
        this.listOfTurns = listOfTurns;
    }



    public String getSpecialty() {
        return specialty;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Appointment> getListOfTurns() {
        return listOfTurns;
    }



    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setListOfTurns(List<Appointment> listOfTurns) {
        this.listOfTurns = listOfTurns;
    }
    
    



 

    
}
