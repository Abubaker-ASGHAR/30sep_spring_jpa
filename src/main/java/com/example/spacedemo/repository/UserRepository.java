package com.example.spacedemo.repository;

import com.example.spacedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>{


}
