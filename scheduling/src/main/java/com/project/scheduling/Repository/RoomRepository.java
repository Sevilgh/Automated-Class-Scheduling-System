package com.project.scheduling.Repository;



import com.project.scheduling.Model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

}