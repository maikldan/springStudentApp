package com.dao;

import com.model.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Student on 2/27/2017.
 */
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    List<Profesor> findAll();
}
