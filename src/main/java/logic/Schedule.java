package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule ;
    private String scheduleStart;
    private String scheduleEnd;

    public Schedule() {
    }

    public Schedule(int idSchedule, String scheduleStart, String scheduleEnd) {
        this.idSchedule = idSchedule;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public String getScheduleStart() {
        return scheduleStart;
    }

    public String getScheduleEnd() {
        return scheduleEnd;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setScheduleStart(String scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public void setScheduleEnd(String scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }


    
    
    
            
}
