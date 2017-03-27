package com.dao;

import com.model.LibrarySubscription;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Student on 2/24/2017.
 */
public interface StatusRepository extends CrudRepository<LibrarySubscription, Long> {

}
