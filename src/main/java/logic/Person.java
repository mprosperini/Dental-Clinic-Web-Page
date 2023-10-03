package logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS )
public class Person implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idPerson;    
private String firstName;
private String secondName;
private String  dni;
@Temporal(TemporalType.DATE)
private Date birthDate;
private String cellphone;
private String address;

    public Person() {
   }

    public Person(int idPerson, String firstName, String secondName, String dni, Date birthDate, String cellphone, String address) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.cellphone = cellphone;
        this.address = address;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDni() {
        return dni;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setAddress(String address) {
        this.address = address;
    }


     
        
    
}
