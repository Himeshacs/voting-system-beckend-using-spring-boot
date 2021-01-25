package com.vote.voting_system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.Login;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.service.CitizenService;
import com.vote.voting_system.service.LoginService;
import com.vote.voting_system.utill.AppDateTimeUtill;
import com.vote.voting_system.utill.EmailThreadMessage;
import com.vote.voting_system.utill.OtpController;

@RequestMapping("/vote/api/v1/authentication")
@RestController
public class Authentication {

	@Autowired
	LoginService loginService_01;
	
	@Autowired
	CitizenService citizenService_01;
	
	@RequestMapping(value = "/mobile",method = RequestMethod.POST)
	public ResponseEntity<?> loginMobile(@RequestBody String str){
		Optional<Login> getAll=null;
		Optional<Citizen> citizenData=null;
		JSONObject jsonObject=new JSONObject(str);
		JSONObject Object=new JSONObject();
		try {
			getAll=loginService_01.findByUsernameAndPassword(jsonObject.getString("username"), jsonObject.getString("password"));
			if(getAll.isPresent()) {
				if(getAll.get().getStatus() == 1) {
					Object.put("id", getAll.get().getId());
					Object.put("username", getAll.get().getUsername());
					Object.put("password", getAll.get().getPassword());
					Object.put("status", getAll.get().getStatus());
					Object.put("role", getAll.get().getRole());
					Object.put("person_id", getAll.get().getPerson().getId());
					
					citizenData=citizenService_01.findById(getAll.get().getPerson());
					if(citizenData.isPresent()) {
						Object.put("citizen_id", citizenData.get().getId());
						Object.put("reffno", citizenData.get().getReffNo());
						Object.put("distric_id", citizenData.get().getDistrict().getId());
						Object.put("distric_name", citizenData.get().getDistrict().getName());
						Object.put("citizen_code", citizenData.get().getCode());
						Object.put("c_status", getAll.get().getStatus());
					}else {
						System.out.println("Null citizen");
					}
					
				}
				
				
			}else {
				System.out.println("NULL");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Object.toString());
		return new ResponseEntity<String>(Object.toString(),HttpStatus.ACCEPTED);
	}
	
//	@RequestMapping(value = "/code",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.ALL_VALUE)
//	public ResponseEntity<?> sendCode(@RequestParam int p_type){
//		try {
//			List<String[]> setArray = new ArrayList();
//			List<Citizen> getAll;
//			getAll=citizenService_01.findByAll();
//			System.out.println(p_type+" status of pass");
//			try {
//				
//				if(p_type == 1) {   // active citizend send otp code
//					
//					if(!getAll.isEmpty()) {
//						for(Citizen c: getAll) {
//							Citizen citzen=new Citizen();
//							citzen.setId(c.getId());
//							citzen.setReffNo(c.getReffNo());
//							citzen.setStatus(1);
//							citzen.setPerson(c.getPerson());
//							District district=new District();
//							district.setId(c.getDistrict().getId());
//							citzen.setDistrict(district);
////							citzen.setCode(OtpController.generatorOTP(4).toString());
//							citzen=citizenService_01.save(citzen);
//							System.out.println(citzen.getId()+" updated ID");
//							
//						}
//					}
//				}else if(p_type == 2) { // Deactive citizend 
//					if(!getAll.isEmpty()) {
//						for(Citizen c: getAll) {
//							Citizen citzen=new Citizen();
//							citzen.setId(c.getId());
//							citzen.setReffNo(c.getReffNo());
//							citzen.setStatus(2);
//							citzen.setPerson(c.getPerson());
//							District district=new District();
//							district.setId(c.getDistrict().getId());
//							citzen.setDistrict(district);
////							citzen.setCode(OtpController.generatorOTP(4).toString());
//							citizenService_01.save(citzen);
//							
//							
//						}
//						
//						if(!getAll.isEmpty()) {
//							for(Citizen c: getAll) {
//								JSONObject obj=new JSONObject();
//								if(c.getStatus() == 1) {
//									
//									obj.put("id",  c.getId());
//									obj.put("name", c.getReffNo());
//									String msgContent = "Dear "+c.getPerson().getFname()+" and your nic is number "+c.getPerson().getNic() + ","
//									+ " and authentication code is  " + c.getCode() + " " +
//									"please use this code and Vote now untill mid night ,automatically it will disable"
//									+" District "+c.getDistrict().getName()+"Date "+AppDateTimeUtill.getCurrentDateTime().toString() ;
//									
//									String arry[] = { "Now vote is starting",c.getPerson().getEmail(),msgContent};
//									setArray.add(arry);
//								}
//								
//								
//							}
//						}
//						
//					}
//				}
//				
//				
//				
//				
//				
//				
//				
//				
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			
//			EmailThreadMessage emailThreadMannager = new EmailThreadMessage(setArray);
//			Thread thread = new Thread(emailThreadMannager);
//			thread.start();
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return new ResponseEntity<String>("Sent",HttpStatus.ACCEPTED);
//	}
	
	@PostMapping(value = "/web")
	public String loginWeb(@RequestParam("email") String email,
			@RequestParam("password") String password,Map<String, Object> model,
			HttpServletRequest request){
		Optional<Login> getAll=null;
		Optional<Citizen> citizenData=null;
		Path_controller main_url=new Path_controller();
		String path="";
		JSONObject Object=new JSONObject();
		try {
			
			if(email.equals("") && password.equals("")) {
				
				String temp="<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n" + 
				"            <strong>Alert!</strong>Username & Password Empty !!.\r\n" + 
				"            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
				"            <span class=\"fa fa-times\"></span>\r\n" + 
				"            </button>\r\n" + 
				"            </div>";

				model.put("message", temp);
				return "login";

				
			}else {
				
				getAll=loginService_01.findByUsernameAndPassword(email, password);
				if(getAll.isPresent()) {
					if(getAll.get().getStatus() == 1) {
						
						path= main_url.Dashboard();
						return path;
										
							
						}else {
							String temp="<div class=\"alert alert-info alert-dismissible fade show\" role=\"alert\">\r\n" + 
									"            <strong>Alert!</strong>Your password does not match error message...!!\r\n" + 
									"            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
									"            <span class=\"fa fa-times\"></span>\r\n" + 
									"            </button>\r\n" + 
									"            </div>";
									
							model.put("message", temp);
							return "login";
						
						
					}
					
					
				}else {
					String temp="<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n" + 
							"            <strong>Alert!</strong>Your Account Has Been Deactivated...!!\r\n" + 
							"            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
							"            <span class=\"fa fa-times\"></span>\r\n" + 
							"            </button>\r\n" + 
							"            </div>";
							
					model.put("message", temp);
					return "login";
//					System.err.println("");
				}
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
//		return new ResponseEntity<String>(Object.toString(),HttpStatus.ACCEPTED);
	}
	
	@ResponseBody
	@PostMapping(value = "/validOtp")
	public String GetListByTeamId(@RequestParam ("c_id") int citizen_id,@RequestParam ("code") String code) {
		Optional<Citizen> getAll;
		JSONArray array=new JSONArray();
		System.out.println(citizen_id);
		System.out.println(code);
		JSONObject obj=new JSONObject();
		try {
			
			getAll=citizenService_01.findByIdAndCode(citizen_id, code);
			if(getAll.isPresent()) {
				
//					JSONObject obj=new JSONObject();
					obj.put("result", "1");
			}else {
				
				obj.put("result", "0");
//				System.out.println("Null");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
//		array.put(obj);
		System.out.println(obj.toString());
		return obj.toString();
	}
}
