package com.project.scheduling.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Bell {


     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
    private String label;
    private String bellOfDay;


    public Integer getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getBellOfDay() { return this.bellOfDay; }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setBellOfDay(String bellOfDay){this.bellOfDay = bellOfDay;}


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Bell))
            return false;
        Bell bell = (Bell) o;
        return Objects.equals(this.id, bell.id) && Objects.equals(this.label, bell.label)
                && Objects.equals(this.bellOfDay, bell.bellOfDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.label, this.bellOfDay);
    }

    @Override
    public String toString() {
        return "Bell{" + "id=" + this.id + ", label='" + this.label
                +", bellOfDay='" + this.bellOfDay
                + '\'' + '}';
    }

}
