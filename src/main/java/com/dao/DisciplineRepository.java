package com.dao;

import com.model.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineRepository extends CrudRepository<Discipline, Long> {
    List<Discipline> findAll();
}
