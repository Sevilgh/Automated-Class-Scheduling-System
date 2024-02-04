package com.project.scheduling.Repository;

import com.project.scheduling.Model.Masterslesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MasterslessonRepository extends CrudRepository<Masterslesson, Integer> {

}