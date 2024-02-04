package com.project.scheduling.Repository;


import com.project.scheduling.Model.Bell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BellRepository extends CrudRepository<Bell, Integer> {

}