package com.vote.voting_system.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.Login;
import com.vote.voting_system.Model.Person;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Role;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.repository.LoginRepository;
import com.vote.voting_system.service.CitizenService;
import com.vote.voting_system.service.PersonService;
import com.vote.voting_system.service.PoliticionService;
import com.vote.voting_system.utill.AppDateTimeUtill;

@RestController
@RequestMapping("vote/api/v1/person")
public class PersonController {

	@Autowired
	PersonService personService_01;
	
	@Autowired
	PoliticionService politicionService_01;
	
	@Autowired
	CitizenService citizenService_01;
	
	@Autowired
	LoginRepository loginService_01;
	
	@RequestMapping(value = "/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> save(@RequestBody String person_obj){
		System.out.println(person_obj);
		ResponseEntity<?> resPonese;
		JSONObject j_obj=new JSONObject(person_obj);
		JSONObject resp_obj=new JSONObject();
		try {
			
			Person person=new Person();
			person.setFname(j_obj.getString("fname"));
			person.setMname(j_obj.getString("mname"));
			person.setLname(j_obj.getString("lname"));
			person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			person.setStatus(1);
			person.setAdd1(j_obj.getString("add1"));
			person.setAdd2(j_obj.getString("add2"));
			person.setAdd3(j_obj.getString("add3"));
			person.setDob(AppDateTimeUtill.formatDate(j_obj.getString("dob")));
			person.setMobile1(j_obj.getString("mobile1"));
			person.setMobile2(j_obj.getString("mobile2"));
			person.setEmail(j_obj.getString("email"));
			person.setFax(j_obj.getString("fax"));
			person.setNic(j_obj.getString("nic"));
			
			Person p_res=personService_01.save(person);
			Login login=new Login();
			login.setUsername(j_obj.getString("email"));
			login.setPassword(j_obj.getString("nic"));
			login.setStatus(1);
			login.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			login.setLogincol("");
			login.setPerson(person);
			Role role=new Role();
			role.setId(2);
			login.setRoleBean(role);
			loginService_01.save(login);
			
				resp_obj.put("p_id", p_res.getId());
				resp_obj.put("p_name", p_res.getFname());
			
			if(j_obj.getInt("type") == 1) {    //citizen
				Politicion politicion=new Politicion();
				politicion.setReffCode(j_obj.getString("reff_code"));
				politicion.setOtpCode(j_obj.getString("otp_code"));
				politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				politicion.setStatus(1);
				Team team=new Team();
				team.setId(j_obj.getInt("team_id"));
				politicion.setTeam(team);
				politicionService_01.save(politicion);
								
			}else if(j_obj.getInt("type") == 2) { //politicions
				Citizen citzen=new Citizen();
				citzen.setReffNo(j_obj.getString("reff_no"));
				citzen.setStatus(1);
				citzen.setPerson(person);
				District district=new District();
				district.setId(j_obj.getInt("district_id"));
				citzen.setDistrict(district);
				citzen.setCode(j_obj.getString("code"));
				citizenService_01.save(citzen);
			}	
			
			return new ResponseEntity<String>("",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("OK");
		}
		
		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.BAD_REQUEST);
	}
	
	
//	@PutMapping("")
	@RequestMapping(value = "/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> update(@RequestBody String person_obj){
		System.out.println(person_obj);
		ResponseEntity<?> resPonese;
		JSONObject j_obj=new JSONObject(person_obj);
		JSONObject resp_obj=new JSONObject();
		try {
			
			Person person=new Person();
			person.setId(j_obj.getInt("p_id"));
			person.setFname(j_obj.getString("fname"));
			person.setMname(j_obj.getString("mname"));
			person.setLname(j_obj.getString("lname"));
			person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
			person.setStatus(1);
			person.setAdd1(j_obj.getString("add1"));
			person.setAdd2(j_obj.getString("add2"));
			person.setAdd3(j_obj.getString("add3"));
			person.setDob(AppDateTimeUtill.formatDate(j_obj.getString("dob")));
			person.setMobile1(j_obj.getString("mobile1"));
			person.setMobile2(j_obj.getString("mobile2"));
			person.setEmail(j_obj.getString("email"));
			person.setFax(j_obj.getString("fax"));
			person.setNic(j_obj.getString("nic"));
			
			Person p_res=personService_01.save(person);
				resp_obj.put("p_id", p_res.getId());
				resp_obj.put("p_name", p_res.getFname());
			
			if(j_obj.getInt("type") == 1) {    //citizen
				Politicion politicion=new Politicion();
				politicion.setId(j_obj.getInt("politicion_id"));
				politicion.setReffCode(j_obj.getString("reff_code"));
				politicion.setOtpCode(j_obj.getString("otp_code"));
				politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				politicion.setStatus(1);
				Team team=new Team();
				team.setId(j_obj.getInt("team_id"));
				politicion.setTeam(team);
				politicionService_01.save(politicion);
								
			}else if(j_obj.getInt("type") == 2) { //politicions
				Citizen citzen=new Citizen();
				citzen.setId(j_obj.getInt("citizen_id"));
				citzen.setReffNo(j_obj.getString("reff_no"));
				citzen.setStatus(1);
				citzen.setPerson(person);
				District district=new District();
				district.setId(j_obj.getInt("district_id"));
				citzen.setDistrict(district);
				citzen.setCode(j_obj.getString("code"));
				citizenService_01.save(citzen);
			}	
			
			return new ResponseEntity<String>("",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("OK");
		}
		
		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.BAD_REQUEST);
	}
	
	
//	@DeleteMapping("")
	@RequestMapping(value = "/disabel/{politic_id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> delete(@PathVariable int politic_id){
		Politicion politicion=new Politicion();
		System.out.println(politic_id);
		politicionService_01.delete(politicion);
		return new ResponseEntity<String>("",HttpStatus.ACCEPTED);
	}
	
//	//fname,mname,lname,add1,add2,add3,p_type,mobile1,mobile2,Email,nic,exampledate,fax
//	@RequestMapping(value = "/webperson",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
//	public ResponseEntity<?> saveWeb(@RequestParam ("fname") String fname,@RequestParam ("mname") String mname
//			,@RequestParam ("lname") String lname,@RequestParam ("add1") String add1,@RequestParam ("add2") String add2,
//			@RequestParam ("add3") String add3,@RequestParam ("p_type") int p_type,@RequestParam ("mobile1") String mobile1
//			,@RequestParam ("mobile2") String mobile2,@RequestParam ("Email") String Email,@RequestParam ("nic") String nic
//			,@RequestParam ("exampledate") String exampledate,@RequestParam ("fax") String fax,
//			@RequestParam ("reff_code") String reff_code,@RequestParam ("team_id") int team_id,
//			@RequestParam ("reff_no") String reff_no,@RequestParam ("district_id") int district_id){
//		
//		ResponseEntity<?> resPonese;
//		JSONObject resp_obj=new JSONObject();
//		try {
//			
//			Person person=new Person();
//			person.setFname(fname);
//			person.setMname(mname);
//			person.setLname(lname);
//			person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//			person.setStatus(1);
//			person.setAdd1(add1);
//			person.setAdd2(add2);
//			person.setAdd3(add3);
//			person.setDob(AppDateTimeUtill.formatDate(exampledate));
//			person.setMobile1(mobile1);
//			person.setMobile2(mobile2);
//			person.setEmail(Email);
//			person.setFax(fax);
//			person.setNic(nic);
//			
//			Person p_res=personService_01.save(person);
//			Login login=new Login();
//			login.setUsername(Email);
//			login.setPassword(nic);
//			login.setStatus(1);
//			login.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//			login.setLogincol("");
//			login.setPerson(person);
//			Role role=new Role();
//			role.setId(2);
//			login.setRoleBean(role);
//			loginService_01.save(login);
//			
//				resp_obj.put("p_id", p_res.getId());
//				resp_obj.put("p_name", p_res.getFname());
//			
//			if(p_type == 1) {    //politicions
//				Politicion politicion=new Politicion();
//				politicion.setReffCode(reff_code);
//				politicion.setOtpCode(OtpController.generatorOTP(4).toString());
//				politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//				politicion.setStatus(1);
//				Team team=new Team();
//				team.setId(team_id);
//				politicion.setTeam(team);
//				politicionService_01.save(politicion);
//								
//			}else if(p_type == 2) { // citizen
//				Citizen citzen=new Citizen();
//				citzen.setReffNo(reff_no);
//				citzen.setStatus(1);
//				citzen.setPerson(person);
//				District district=new District();
//				district.setId(district_id);
//				citzen.setDistrict(district);
//				citzen.setCode(OtpController.generatorOTP(4).toString());
//				citizenService_01.save(citzen);
//			}	
//			
//			return new ResponseEntity<String>("",HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			System.out.println("OK");
//		}
//		
//		return new ResponseEntity<String>(resp_obj.toString(),HttpStatus.BAD_REQUEST);
//	}
	
	
	
}
