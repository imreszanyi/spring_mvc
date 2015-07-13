package com.epam.bookshop.user.repository.dao;

import org.springframework.data.repository.CrudRepository;
import com.epam.bookshop.user.repository.domain.UserEntity;;


public interface UserDao extends CrudRepository<UserEntity, Long> {

}




