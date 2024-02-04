package com.project.scheduling.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Day {


     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
    private String label;
    private String dayOfWeek;



    public Integer getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDayOfWeek() { return this.dayOfWeek; }




    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDayOfWeek(String dayOfWeek){this.dayOfWeek = dayOfWeek;}



    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Day))
            return false;
        Day day = (Day) o;
        return Objects.equals(this.id, day.id) && Objects.equals(this.label, day.label)
                && Objects.equals(this.dayOfWeek, day.dayOfWeek);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.label, this.dayOfWeek);
    }

    @Override
    public String toString() {
        return "Day{" + "id=" + this.id + ", label='" + this.label
                +", dayOfWeek='" + this.dayOfWeek + '\'' + '}';
    }

}
