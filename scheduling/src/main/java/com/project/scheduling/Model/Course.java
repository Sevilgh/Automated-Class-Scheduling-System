package com.project.scheduling.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Course {


     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
    private String number;
    private String title;
    private String unit;
    private String master1;
    private String master2;
    private String master3;



    public Integer getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTitle() { return this.title; }

    public String getUnit() { return this.unit; }

    public String getMaster1() { return this.master1; }
    public String getMaster2() { return this.master2; }
    public String getMaster3() { return this.master3; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title){this.title = title;}

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setMaster1(String master1) {
        this.master1 = master1;
    }
    public void setMaster2(String master1) {
        this.master2 = master2;
    }
    public void setMaster3(String master1) { this.master3 = master3; }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Course))
            return false;
        Course course = (Course) o;
        return Objects.equals(this.id, course.id) && Objects.equals(this.number, course.number)
                && Objects.equals(this.title, course.title)
                && Objects.equals(this.unit, course.unit) && Objects.equals(this.master1, course.master1)
                && Objects.equals(this.master2, course.master2) && Objects.equals(this.master3, course.master3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.number, this.title, this.unit,this.master1,this.master2
        ,this.master3);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + this.id + ", number='" + this.number
                +", title='" + this.title
                +", unit='" + this.unit
                + '\'' + ", master1='" + this.master1 + ", master2='" + this.master2
                + ", master3='" + this.master3+ '\'' + '}';
    }

}
