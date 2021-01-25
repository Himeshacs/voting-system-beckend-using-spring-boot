package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.Election;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.PoliticionsHasElection;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.service.PoliticionsHasElectionService;
import com.vote.voting_system.utill.AppDateTimeUtill;

@RequestMapping("vote/api/v1/politicionshaselection")
@RestController
public class PoliticionsHasElectionController {

	@Autowired
	PoliticionsHasElectionService politicionsHasElectionService_01;
	
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> save(@RequestParam ("politicion_id") int politicion_id,@RequestParam ("election_id") int election_id,
			@RequestParam ("distric_id") int distric_id,@RequestParam ("number_elex") String number_elex){
		JSONObject resp_obj=new JSONObject();
		
		try {
			PoliticionsHasElection p=new PoliticionsHasElection();
			Politicion politicion=new Politicion();
			politicion.setId(politicion_id);
			p.setPoliticion(politicion);
			Election election=new Election();
			election.setId(election_id);
			p.setElection(election);
			District district=new District();
			district.setId(distric_id);
			p.setDistrict(district);
			p.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			p.setStatus(1);
			p.setNumberEle(number_elex);
			politicionsHasElectionService_01.save(p);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.ACCEPTED);
	}
	
	
//	@RequestMapping(value = "/{distric_id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
//	public ResponseEntity<?> findByDistric(@PathVariable int distric_id){
//	
//		JSONArray resp_obj=new JSONArray();
//		List<PoliticionsHasElection> listAll;
//		System.err.println(distric_id);
//		try {
//			District district=new District();
//			district.setId(distric_id);
//			listAll=politicionsHasElectionService_01.findByDistric(district);
//			if(!listAll.isEmpty()) {
//				for(PoliticionsHasElection t: listAll) {
//					JSONObject obj=new JSONObject();
//					if(t.getStatus() == 1) {
//						
//						obj.put("id", t.getId());
////						obj.put("poli_id", t.getPoliticion().getId());
//						obj.put("team_id", t.getPoliticion().getTeam().getId());
//						obj.put("team_name", t.getPoliticion().getTeam().getName());
////						obj.put("poli_id", t.getPoliticion().getId());
////						obj.put("poli_id", t.getPoliticion().getId());
////						obj.put("poli_id", t.getPoliticion().getId());
//						resp_obj.put(obj);
//					}
//					
//					
//				}
//			}else {
//				System.err.println("NULL");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.BAD_REQUEST);
//	}
	
	@RequestMapping(value = "/team",method = RequestMethod.POST)
	public String findByDistric(@RequestParam ("distric_id") int distric_id){
	
		JSONArray resp_obj=new JSONArray();
		List<PoliticionsHasElection> listAll;
		System.err.println(distric_id);
//		JSONObject jsonObject=new JSONObject(str);
		try {
			District district=new District();
//			district.setId(jsonObject.getInt("d_id"));
			district.setId(distric_id);
			listAll=politicionsHasElectionService_01.findByDistric(district);
			if(!listAll.isEmpty()) {
				for(PoliticionsHasElection t: listAll) {
					JSONObject obj=new JSONObject();
					if(t.getStatus() == 1) {
						
						obj.put("id", t.getId());
//						obj.put("poli_id", t.getPoliticion().getId());
						obj.put("team_id", t.getPoliticion().getTeam().getId());
						obj.put("team_name", t.getPoliticion().getTeam().getName());
//						obj.put("poli_id", t.getPoliticion().getId());
//						obj.put("poli_id", t.getPoliticion().getId());
//						obj.put("poli_id", t.getPoliticion().getId());
						resp_obj.put(obj);
					}
					
					
				}
			}else {
				System.err.println("NULL");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(resp_obj.toString());
		return resp_obj.toString();
	}
}
