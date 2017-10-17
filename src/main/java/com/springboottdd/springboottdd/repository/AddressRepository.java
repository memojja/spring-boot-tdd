package com.springboottdd.springboottdd.repository;

import com.springboottdd.springboottdd.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long>{
}
