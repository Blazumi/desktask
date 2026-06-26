package com.blazumi.desktask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findByManagerId(Long managerId);
}
