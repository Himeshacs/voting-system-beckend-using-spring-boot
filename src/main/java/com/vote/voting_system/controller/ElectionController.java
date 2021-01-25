package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vote.voting_system.Model.Election;
import com.vote.voting_system.service.ElectionService;
import com.vote.voting_system.utill.AppDateTimeUtill;

@Controller
public class ElectionController {

	@Autowired
	ElectionService electionService_01;
	
	@PostMapping(value = "/saveelection")
	public String save(@RequestParam ("name") String name,@RequestParam ("status") int status,
			@RequestParam ("max_count") String max_count) {
		JSONObject resp_obj=new JSONObject();
		try {
			Election election=new Election();
			election.setName(name);
			election.setStatus(1);
			election.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			election.setMaxCount(max_count);
			election=electionService_01.save(election);
			resp_obj.put("p_id", election.getId());
			resp_obj.put("p_name", election.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return resp_obj.toString();
	}
	
	@ResponseBody
	@GetMapping(value = "/electionList")
	public String getAll()
	{JSONArray array=new JSONArray();
		List<Election> getAll;
		try {
			getAll=electionService_01.findAll();
			if(!getAll.isEmpty()) {
				for(Election c: getAll) {
					
					if(c.getStatus() == 1) {
					JSONObject object=new JSONObject();
					object.put("id", c.getId());
					object.put("name", c.getName());
					array.put(object);
					}
					
				}
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array.toString();
	}
	
	
}
