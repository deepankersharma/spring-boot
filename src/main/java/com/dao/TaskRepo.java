package com.dao;

import com.modal.Persons;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Persons,Integer> {
}
