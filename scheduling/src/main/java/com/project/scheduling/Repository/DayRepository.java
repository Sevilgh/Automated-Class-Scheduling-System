package com.project.scheduling.Repository;


import com.project.scheduling.Model.Day;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {

}