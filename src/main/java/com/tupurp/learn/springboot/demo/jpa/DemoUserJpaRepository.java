package com.tupurp.learn.springboot.demo.jpa;

import com.tupurp.learn.springboot.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* 继承JpaRepository来完成对数据库的操作,不需要加任何注解
* */
public interface DemoUserJpaRepository extends JpaRepository<User,Long> {
}
