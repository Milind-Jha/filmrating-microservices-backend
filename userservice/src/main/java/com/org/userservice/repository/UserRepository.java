package com.org.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
