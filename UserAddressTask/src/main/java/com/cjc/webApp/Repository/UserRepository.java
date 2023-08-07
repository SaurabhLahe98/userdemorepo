package com.cjc.webApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.webApp.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

public	List<User> findAllByUsername(String username);

}
