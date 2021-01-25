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
import com.vote.voting_system.Model.District;
import com.vote.voting_system.service.DistricService;

@RequestMapping("/vote/api/v1/distric")
@RestController
public class DistricController {

	@Autowired
	DistricService districService_01;
	
	@RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> findByAll(){
	
		JSONArray resp_obj=new JSONArray();
		List<District> listAll;
		
		try {
			listAll=districService_01.findByAll();
			if(!listAll.isEmpty()) {
				for(District d: listAll) {
					JSONObject obj=new JSONObject();
					if(d.getStatus() == 1) {
						
						obj.put("id", d.getId());
						obj.put("name", d.getName());
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
