package com.blazumi.desktask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
	
	List<TeamMember>findByTeamId(Long teamId);
	List<TeamMember> findByUserId(Long userId); 
	boolean existsByTeamIdAndUserId(Long teamId, Long userId);

}
