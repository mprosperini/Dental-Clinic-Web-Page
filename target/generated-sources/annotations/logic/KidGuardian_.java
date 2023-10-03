package logic;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logic.Patient;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-28T19:45:58")
@StaticMetamodel(KidGuardian.class)
public class KidGuardian_ extends Person_ {

    public static volatile SingularAttribute<KidGuardian, String> relationType;
    public static volatile SingularAttribute<KidGuardian, Patient> aPatient;

}