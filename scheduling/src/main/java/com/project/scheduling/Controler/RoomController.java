package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;


import com.project.scheduling.Model.Room;
import com.project.scheduling.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RoomController {

    @Autowired
    private RoomRepository repository;




    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/rooms")
    List<Room> all() {
        return (List<Room>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/rooms")
    Room newRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    }

    // Single item

    @GetMapping("/rooms/{id}")
    Optional<Room> one(@PathVariable int id){
        return repository.findById(id);
    }


    @PutMapping("/rooms/{id}")
    Room replacerooms(@RequestBody Room newRoom, @PathVariable("id") Integer id) {

        return repository.findById(id)
                .map(room -> {
                    room.setRoomName(newRoom.getRoomName());
                    return repository.save(room);
                })
                .orElseGet(() -> {
                    newRoom.setId(id);
                    return repository.save(newRoom);
                });
    }

    @DeleteMapping("/rooms/{id}")
    void deleterooms(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}