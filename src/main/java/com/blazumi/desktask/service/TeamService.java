package com.blazumi.desktask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blazumi.desktask.enums.UserRole;
import com.blazumi.desktask.exception.BusinessException;
import com.blazumi.desktask.model.Team;
import com.blazumi.desktask.model.TeamMember;
import com.blazumi.desktask.model.User;
import com.blazumi.desktask.repository.TeamMemberRepository;
import com.blazumi.desktask.repository.TeamRepository;

@Service
public class TeamService {

	private final TeamRepository teamRepository;
	private final TeamMemberRepository teamMemberRepository;
	private final UserService userService;
	
	public TeamService(TeamRepository teamRepository,
						TeamMemberRepository teamMemberRepository,
						UserService userService) {
		this.teamMemberRepository = teamMemberRepository;
		this.teamRepository = teamRepository;
		this.userService = userService;
	}
	
	public Team createTeam(String name, Long managerId) {
		User manager = userService.findUserById(managerId);
		if(manager.getRole() != UserRole.MANAGER) {
			throw new BusinessException("只有主管可以建立團隊");
		}
		Team team = new Team();
		team.setName(name);
		team.setManager(manager);
		return teamRepository.save(team);
	}
	
	public Team findTeamById(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> new BusinessException("找不到 team id:" + id));
	}
	
	public List<Team> findTeamByManagerId(Long managerId) {
		userService.findUserById(managerId);
		return teamRepository.findByManagerId(managerId);
	}
	
	public TeamMember addTeamMember(Long teamId, Long userId) {
		Team team = findTeamById(teamId);
		User user = userService.findUserById(userId);
		
		if(teamMemberRepository.existsByTeamIdAndUserId(teamId, userId)) {
			throw new BusinessException("使用者已經在這個團隊裡");
		}
		TeamMember teamMember = new TeamMember();
		teamMember.setTeam(team);
		teamMember.setUser(user);
		
		return teamMemberRepository.save(teamMember);
	}
	
	public List<TeamMember> findTeamMemberById(Long teamId){
		findTeamById(teamId);
		return teamMemberRepository.findByTeamId(teamId);
	}
}
