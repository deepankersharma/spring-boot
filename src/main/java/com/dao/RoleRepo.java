package com.dao;

import com.modal.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {

    Role findByAuthority(String authority);
    Role findById(Long id);

}