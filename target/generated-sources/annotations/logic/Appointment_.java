package logic;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.Dentist;
import logic.Patient;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T19:45:58")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Dentist> dentistMapedBy;
    public static volatile SingularAttribute<Appointment, String> hourAppointment;
    public static volatile SingularAttribute<Appointment, Patient> patientMappedBy;
    public static volatile SingularAttribute<Appointment, Date> dateAppointment;
    public static volatile SingularAttribute<Appointment, String> appointmentIssue;
    public static volatile SingularAttribute<Appointment, Integer> idAppointment;

}