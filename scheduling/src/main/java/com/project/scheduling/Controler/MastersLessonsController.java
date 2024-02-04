package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;


import com.project.scheduling.Model.Masterslesson;

import com.project.scheduling.Repository.MasterslessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MastersLessonsController {

    @Autowired
    private MasterslessonRepository repository;




    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/masterslessons")
    List<Masterslesson> all() {
        return (List<Masterslesson>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/masterslessons")
    Masterslesson newMasterslessons(@RequestBody Masterslesson newMasterslessons) {

        return repository.save(newMasterslessons);
    }

    // Single item

    @GetMapping("/masterslessons/{id}")
    Optional<Masterslesson> one(@PathVariable int id){
        return repository.findById(id);
    }


    @PutMapping("/masterslessons/{id}")
    Masterslesson replaceMasterslessons(@RequestBody Masterslesson newMasterslessons,
                                        @PathVariable("id") Integer id) {

        return repository.findById(id)
                .map(masterslessons -> {
                    masterslessons.setMastersName(newMasterslessons.getMastersName());
                    masterslessons.setmNum(newMasterslessons.getmNum());
                    masterslessons.setLesson1(newMasterslessons.getLesson1());
                    masterslessons.setLesson2(newMasterslessons.getLesson2());
                    masterslessons.setLesson3(newMasterslessons.getLesson3());
                    masterslessons.setLesson4(newMasterslessons.getLesson4());
                    return repository.save(masterslessons);
                })
                .orElseGet(() -> {
                    newMasterslessons.setId(id);
                    return repository.save(newMasterslessons);
                });
    }

    @DeleteMapping("/masterslessons/{id}")
    void deleteMasterslessons(@PathVariable Integer id) {
        repository.deleteById(id);

    }
}