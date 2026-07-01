package com.blazumi.desktask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blazumi.desktask.dto.TeamCreateRequest;
import com.blazumi.desktask.dto.TeamMemberResponse;
import com.blazumi.desktask.dto.TeamResponse;
import com.blazumi.desktask.model.Team;
import com.blazumi.desktask.model.TeamMember;
import com.blazumi.desktask.response.ApiResponse;
import com.blazumi.desktask.service.TeamService;

import jakarta.validation.Valid;

@RestController
public class TeamController {

	private final TeamService teamService;
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@PostMapping("/teams")
	public ApiResponse<TeamResponse> createTeam(@Valid @RequestBody TeamCreateRequest request){
		Team team = teamService.createTeam(request.getName(), request.getManagerId());
		return ApiResponse.success("建立團隊成功", toResponse(team));
	}
	
	@GetMapping("/teams/{id}")
	public ApiResponse<TeamResponse> findTeamById(@PathVariable Long id){
		Team team = teamService.findTeamById(id);
		return ApiResponse.success("查詢團隊成功", toResponse(team));
	}
	
	@GetMapping("/manager/{managerId}/teams")
	public ApiResponse<List<TeamResponse>> findTeamByManagerId(@PathVariable Long managerId) {
		List<Team> teams = teamService.findTeamByManagerId(managerId);
		return ApiResponse.success("查詢主管管理團隊成功", toTeamResponseList(teams));
	}
	
	@GetMapping("/teams/{teamId}/members")
	public ApiResponse<List<TeamMemberResponse>> findTeamMembers(@PathVariable Long teamId){
		List<TeamMember> members = teamService.findTeamMemberById(teamId);
		return ApiResponse.success("查詢團隊成員成功", toMemberResponseList(members));
	}
	
	
	private TeamResponse toResponse(Team team) {
		TeamResponse response = new TeamResponse();
		response.setId(team.getId());
		response.setName(team.getName());
		response.setCreateAt(team.getCreateAt());
		response.setUpdateAt(team.getUpdateAt());
		if(team.getManager() != null) {
			response.setManagerId(team.getManager().getId());
			response.setManagerUsername(team.getManager().getUsername());
		}
		return response;
	}
	
	private List<TeamResponse> toTeamResponseList(List<Team> teams) {
		List<TeamResponse> responses = new ArrayList<>();
		for(Team team : teams) {
			responses.add(toResponse(team));
		}
		return responses;
	}
	
	private TeamMemberResponse toMemberResponse(TeamMember teamMember) {
		TeamMemberResponse response = new TeamMemberResponse();
		response.setId(teamMember.getId());
		response.setJoinedAt(teamMember.getJoinedAt());
		if(teamMember.getTeam() != null) {
			response.setTeamId(teamMember.getTeam().getId());
			response.setTeamName(teamMember.getTeam().getName());
		}
		if(teamMember.getUser() != null) {
			response.setUserId(teamMember.getUser().getId());
			response.setUsername(teamMember.getUser().getUsername());
			response.setEmail(teamMember.getUser().getEmail());
			response.setRole(teamMember.getUser().getRole());
		}
		return response;
	}
	
	private List<TeamMemberResponse> toMemberResponseList(List<TeamMember> members){
		List<TeamMemberResponse> responses = new ArrayList<>();
		for(TeamMember member : members) {
			responses.add(toMemberResponse(member));
		}
		return responses;
	}
}
