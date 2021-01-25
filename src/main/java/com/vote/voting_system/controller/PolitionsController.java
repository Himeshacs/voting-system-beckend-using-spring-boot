package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.service.PoliticionService;

@RestController
public class PolitionsController {

	@Autowired
	PoliticionService politicionService_01;
	
	@PostMapping(value = "/getpoliList")
	public String GetListByTeamId(@RequestParam ("team_id") int team_id) {
		List<Politicion> getAll;
		JSONArray array=new JSONArray();
		try {
			Team team=new Team();
			team.setId(team_id);
			getAll=politicionService_01.findByTeam(team);
			if(!getAll.isEmpty()) {
				for(Politicion p : getAll) {
					JSONObject obj=new JSONObject();
					obj.put("id", p.getPerson().getId());
					obj.put("name", p.getPerson().getFname());
					obj.put("reff_code", p.getReffCode());
					obj.put("mobile", p.getPerson().getMobile1());
					obj.put("team name", p.getTeam().getName());
				array.put(obj);
				}
			}else {
				System.out.println("Null");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(array.toString());
		return array.toString();
	}
	
}
