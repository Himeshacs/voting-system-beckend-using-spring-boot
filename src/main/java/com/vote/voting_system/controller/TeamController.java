package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.Model.Team;
import com.vote.voting_system.service.TeamService;

@RequestMapping("/vote/api/v1/team")
@RestController
public class TeamController {

	@Autowired
	TeamService teamService_01;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ResponseEntity<?> findByAll(){
	
		JSONArray resp_obj=new JSONArray();
		List<Team> listAll;
		
		try {
			listAll=teamService_01.findByAll();
			if(!listAll.isEmpty()) {
				for(Team t: listAll) {
					JSONObject obj=new JSONObject();
					if(t.getStatus() == 1) {
						
						obj.put("id", t.getId());
						obj.put("name", t.getName());
						resp_obj.put(obj);
					}
					
					
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.BAD_REQUEST);
	}
	
	
}
