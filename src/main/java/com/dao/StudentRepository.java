package com.dao;

import com.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Student on 2/22/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long>{

}
