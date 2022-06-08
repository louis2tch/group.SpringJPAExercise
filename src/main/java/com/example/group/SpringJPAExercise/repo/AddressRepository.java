package com.example.group.SpringJPAExercise.repo;

import com.example.group.SpringJPAExercise.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
