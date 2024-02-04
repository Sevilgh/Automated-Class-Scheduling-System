package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;


import com.project.scheduling.Model.Bell;

import com.project.scheduling.Repository.BellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BellController {

    @Autowired
    private BellRepository repository;




    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/bells")
    List<Bell> all() {
        return (List<Bell>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/bells")
    Bell newBell(@RequestBody Bell newBell) {
        return repository.save(newBell);
    }

    // Single item

    @GetMapping("/bells/{id}")
    Optional<Bell> one(@PathVariable int id){
        return repository.findById(id);
    }


    @PutMapping("/bells/{id}")
    Bell replaceBell(@RequestBody Bell newBell, @PathVariable("id") Integer id) {

        return repository.findById(id)
                .map(bell -> {
                    bell.setLabel(newBell.getLabel());
                    bell.setBellOfDay(newBell.getBellOfDay());
                    return repository.save(bell);
                })
                .orElseGet(() -> {
                    newBell.setId(id);
                    return repository.save(newBell);
                });
    }

    @DeleteMapping("/bells/{id}")
    void deleteBell(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}