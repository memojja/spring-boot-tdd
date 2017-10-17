package com.springboottdd.springboottdd.repository;

import com.springboottdd.springboottdd.model.Telephone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends CrudRepository<Telephone,Long> {
}
