package logic;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.Appointment;
import logic.KidGuardian;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T19:45:58")
@StaticMetamodel(Patient.class)
public class Patient_ extends Person_ {

    public static volatile SingularAttribute<Patient, Boolean> healthInsurance;
    public static volatile ListAttribute<Patient, Appointment> listOfTurns;
    public static volatile SingularAttribute<Patient, String> bloodType;
    public static volatile SingularAttribute<Patient, KidGuardian> kidGuardian;

}