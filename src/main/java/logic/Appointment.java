package logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppointment;
    @Temporal(TemporalType.DATE)
    private Date dateAppointment;
    private String hourAppointment;
    private String appointmentIssue;
    
    @ManyToOne
    @JoinColumn(name = "idAppointment")
    private Dentist dentistMapedBy;
    
    @ManyToOne
    @JoinColumn(name = "idAppointment2")
    private Patient patientMappedBy;

    public Appointment() {
    }

    public Appointment(int idAppointment, Date dateAppointment, String hourAppointment, String appointmentIssue) {
        this.idAppointment = idAppointment;
        this.dateAppointment = dateAppointment;
        this.hourAppointment = hourAppointment;
        this.appointmentIssue = appointmentIssue;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public String getHourAppointment() {
        return hourAppointment;
    }

    public String getAppointmentIssue() {
        return appointmentIssue;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public void setHourAppointment(String hourAppointment) {
        this.hourAppointment = hourAppointment;
    }

    public void setAppointmentIssue(String appointmentIssue) {
        this.appointmentIssue = appointmentIssue;
    }
    
    
    
}
