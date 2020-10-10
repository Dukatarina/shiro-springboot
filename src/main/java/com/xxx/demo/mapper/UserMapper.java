package com.xxx.demo.mapper;

import com.xxx.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findUserByName(String name);
}
