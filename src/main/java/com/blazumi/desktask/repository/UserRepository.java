package com.blazumi.desktask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
