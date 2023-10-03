package logic;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.AppUser;
import logic.Appointment;
import logic.Schedule;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T19:45:58")
@StaticMetamodel(Dentist.class)
public class Dentist_ extends Person_ {

    public static volatile SingularAttribute<Dentist, AppUser> appUser;
    public static volatile SingularAttribute<Dentist, Schedule> schedule;
    public static volatile SingularAttribute<Dentist, String> specialty;
    public static volatile ListAttribute<Dentist, Appointment> listOfTurns;

}