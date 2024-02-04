package com.project.scheduling.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Masterslesson {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String masters_name;
    private String m_num;
    private String lesson1;
    private String lesson2;
    private String lesson3;
    private String lesson4;



    public Integer getId() {
        return this.id;
    }

    public String getMastersName() {
        return this.masters_name;
    }

    public String getmNum() { return this.m_num; }

    public String getLesson1() { return this.lesson1; }
    public String getLesson2() { return this.lesson2; }
    public String getLesson3() { return this.lesson3; }
    public String getLesson4() { return this.lesson4; }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setMastersName(String mastersName) {
        this.masters_name = mastersName;
    }

    public void setmNum(String mNum){this.m_num = mNum;}

    public void setLesson1(String lesson1) {
        this.lesson1 = lesson1;
    }

    public void setLesson2(String lesson2) {
        this.lesson2 = lesson2;
    }
    public void setLesson3(String lesson3) {
        this.lesson3 = lesson3;
    }

    public void setLesson4(String lesson4) {
        this.lesson4 = lesson4;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Masterslesson))
            return false;
        Masterslesson masterslessons = (Masterslesson) o;
        return Objects.equals(this.id, masterslessons.id) && Objects.equals(this.masters_name, masterslessons.m_num)
                && Objects.equals(this.lesson1, masterslessons.lesson1)
                && Objects.equals(this.lesson2, masterslessons.lesson2)
                && Objects.equals(this.lesson3, masterslessons.lesson3)
                && Objects.equals(this.lesson4, masterslessons.lesson4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.masters_name, this.m_num, this.lesson1,this.lesson2,
                this.lesson3, this.lesson4);
    }

    @Override
    public String toString() {
        return "Masterslessons{" + "id=" + this.id + ", masterName='" + this.masters_name
                +", mNum='" + this.m_num
                +", lesson1='" + this.lesson1
                + '\'' + ", lesso2='" + this.lesson2 +", lesson3='" + this.lesson3
                +", lesson4='" + this.lesson4+ '\'' + '}';
    }

}
