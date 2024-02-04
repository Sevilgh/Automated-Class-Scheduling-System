package com.project.scheduling.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Admin {


         @Id
         @GeneratedValue(strategy = GenerationType.AUTO)
         private Integer id;
        private String firstName;
        private String lastName;
        private String password;
        private String code;



        public Integer getId() {
            return this.id;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() { return this.lastName; }

        public String getPassword() { return this.password; }

        public String getCode() { return this.code; }


        public void setId(Integer id) {
            this.id = id;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName){this.lastName = lastName;}

        public void setPassword(String password) {
        this.password = password;
    }

        public void setCode(String code) {
        this.code = code;
    }

        @Override
        public boolean equals(Object o) {

            if (this == o)
                return true;
            if (!(o instanceof Admin))
                return false;
            Admin admin = (Admin) o;
            return Objects.equals(this.id, admin.id) && Objects.equals(this.firstName, admin.firstName)
                    && Objects.equals(this.lastName, admin.lastName)
                    && Objects.equals(this.password, admin.password) && Objects.equals(this.code, admin.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id, this.firstName, this.lastName, this.password,this.code);
        }

        @Override
        public String toString() {
            return "Admin{" + "id=" + this.id + ", firstName='" + this.firstName
                    +", lastName='" + this.lastName
                    +", password='" + this.password
                    + '\'' + ", code='" + this.code + '\'' + '}';
        }

}
