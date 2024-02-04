package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;

import com.project.scheduling.Model.Day;
import com.project.scheduling.Repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DayController {

    @Autowired
    private  DayRepository repository;




    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/days")
    List<Day> all() {
        return (List<Day>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/days")
    Day newDay(@RequestBody Day newDay) {
        return repository.save(newDay);
    }

    // Single item

    @GetMapping("/days/{id}")
    Optional<Day> one(@PathVariable int id){
        return repository.findById(id);
    }


    @PutMapping("/days/{id}")
    Day replaceDay(@RequestBody Day newDay, @PathVariable("id") Integer id) {

        return repository.findById(id)
                .map(day -> {
                    day.setLabel(newDay.getLabel());
                    day.setDayOfWeek(newDay.getDayOfWeek());
                    return repository.save(day);
                })
                .orElseGet(() -> {
                    newDay.setId(id);
                    return repository.save(newDay);
                });
    }

    @DeleteMapping("/days/{id}")
    void deleteDay(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}