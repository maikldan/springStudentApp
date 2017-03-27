package com.dao;

import com.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Student on 2/22/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long>, PagingAndSortingRepository<Student, Long>{
    public Student findStudentByLibrarySubscription(LibrarySubscription librarySubscription);
    public List<Student> findStudentByDeleteStatusIsTrue(Sort orders);
 }
