package com.tupurp.learn.springboot.demo.dao;

import com.tupurp.learn.springboot.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Long> {

    User findByMobile(String mobile);
    User findByMobileOrEmail(String name,String email);

}
