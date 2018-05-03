package com.dao;

import com.modal.User;
import com.modal.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {


        User findByUsername(String username);






}
