package com.project.scheduling.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String roomName;




    public Integer getId() {
        return this.id;
    }

    public String getRoomName() {
        return this.roomName;
    }




    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }



    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Room))
            return false;
        Room room = (Room) o;
        return Objects.equals(this.id, room.id) && Objects.equals(this.roomName, room.roomName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.roomName);
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + this.id + ", firstName='" + this.roomName
                + '\'' + '}';
    }

}
