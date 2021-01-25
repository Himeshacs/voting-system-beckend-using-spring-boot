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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.voting_system.Model.Citizen;
import com.vote.voting_system.Model.District;
import com.vote.voting_system.Model.Login;
import com.vote.voting_system.Model.Person;
import com.vote.voting_system.Model.Politicion;
import com.vote.voting_system.Model.Role;
import com.vote.voting_system.Model.RoleHasActivite;
import com.vote.voting_system.Model.Team;
import com.vote.voting_system.repository.LoginRepository;
import com.vote.voting_system.repository.PoliticionRepository;
import com.vote.voting_system.repository.PoliticionsHasElectionRepository;
import com.vote.voting_system.service.CitizenService;
import com.vote.voting_system.service.DistricService;
import com.vote.voting_system.service.LoginService;
import com.vote.voting_system.service.PersonService;
import com.vote.voting_system.service.PoliticionService;
import com.vote.voting_system.service.RolehasActivitiesService;
import com.vote.voting_system.service.TeamService;
import com.vote.voting_system.utill.AppDateTimeUtill;
import com.vote.voting_system.utill.EmailThreadMessage;
import com.vote.voting_system.utill.OtpController;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService_01;
	
	@Autowired
	CitizenService citizenService_01;
	
	@Autowired
	RolehasActivitiesService rolehasActivitiesService_01;
	
	@Autowired
	PersonService personService_01;
	
	@Autowired
	PoliticionService politicionService_01;
	
	
	
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
					if(getAll.get().getStatus() == 1 && getAll.get().getRole() == 1) {
						
						path= main_url.Dashboard();
						return path;
										
							
						}else {
							String temp="<div class=\"alert alert-info alert-dismissible fade show\" role=\"alert\">\r\n" + 
									"            <strong>Alert!</strong>Your password does not matchv OR Not a Admin user error message...!!\r\n" + 
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
	@PostMapping(value = "/Getmenulist")
	public String get_main_menu_list() {
		
		List<RoleHasActivite> menu_list;
		JSONArray jr=new JSONArray();
		Role role=new Role();
		try {
			
			role.setId(1);
			menu_list=rolehasActivitiesService_01.findbyroleid(role);
//			System.out.println(""+);
			if (menu_list.isEmpty()) {
				
				System.out.println("EMPTY LIST");
				
				return "0";
			}else {
			
			for(RoleHasActivite ra: menu_list) {
				
				String name=ra.getActivite().getName().toString();
				String url=ra.getActivite().getUrl().toString();
				int status=ra.getActivite().getStatus();
				String order=ra.getActivite().getOrder();
				int id=ra.getActivite().getId();
				
				if(status == 1) {
					
					JSONObject j=new JSONObject();
					
					j.put("id", id);
					j.put("name", name);
					j.put("url", url);
					j.put("order", order);
					
					jr.put(j);
//					System.out.println(jr.toString());
					
				}
			  }
			}
		  } catch (Exception e) {
			  e.printStackTrace();
		}
		
		return jr.toString();

	}
	
	
	//fname,mname,lname,add1,add2,add3,p_type,mobile1,mobile2,Email,nic,exampledate,fax
		@ResponseBody
		@PostMapping(value = "/webperson")
		public String saveWeb(@RequestParam ("fname") String fname,@RequestParam ("mname") String mname
				,@RequestParam ("lname") String lname,@RequestParam ("add1") String add1,@RequestParam ("add2") String add2,
				@RequestParam ("add3") String add3,@RequestParam ("p_type") int p_type,@RequestParam ("mobile1") String mobile1
				,@RequestParam ("mobile2") String mobile2,@RequestParam ("Email") String Email,@RequestParam ("nic") String nic
				,@RequestParam ("exampledate") String exampledate,@RequestParam ("fax") String fax,
				@RequestParam ("reff_code") String reff_code,@RequestParam ("team_id") int team_id,
				@RequestParam ("reff_no") String reff_no,@RequestParam ("district_id") int district_id){
			
			ResponseEntity<?> resPonese;
			JSONObject resp_obj=new JSONObject();
			try {
				
				Person person=new Person();
				person.setFname(fname);
				person.setMname(mname);
				person.setLname(lname);
				person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				person.setStatus(1);
				person.setAdd1(add1);
				person.setAdd2(add2);
				person.setAdd3(add3);
				person.setDob(AppDateTimeUtill.formatDate(exampledate));
				person.setMobile1(mobile1);
				person.setMobile2(mobile2);
				person.setEmail(Email);
				person.setFax(fax);
				person.setNic(nic);
				
				Person p_res=personService_01.save(person);
				Login login=new Login();
				login.setUsername(Email);
				login.setPassword(nic);
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
				
				if(p_type == 1) {    //politicions
					Politicion politicion=new Politicion();
					politicion.setReffCode(reff_code);
					politicion.setOtpCode(OtpController.generatorOTP(4).toString());
					politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
					politicion.setStatus(1);
					Team team=new Team();
					team.setId(team_id);
					politicion.setTeam(team);
					politicion.setPerson(person);
					politicionService_01.save(politicion);
									
				}else if(p_type == 2) { // citizen
					Citizen citzen=new Citizen();
					citzen.setReffNo(reff_no);
					citzen.setStatus(1);
					citzen.setPerson(person);
					District district=new District();
					district.setId(district_id);
					citzen.setDistrict(district);
					citzen.setCode(OtpController.generatorOTP(4).toString());
					citizenService_01.save(citzen);
				}	
				
//				return "";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
	
		
		@Autowired
		TeamService teamService_01;
		
	
		@ResponseBody
		@GetMapping(value = "/teamlist")
		public String findByAll(){
		
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
			
			return resp_obj.toString();
		}
		
		@Autowired
		DistricService districService_01;
		
		@ResponseBody
		@GetMapping(value = "/distric")
		public String getAllDistric(){
		
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
			
			return resp_obj.toString();
		}
		
		
		@ResponseBody
		@GetMapping(value = "/get_person_list")
		public String getAllPersonList() {
			JSONArray array=new JSONArray();
			List<Person> getAll;
			try {
				getAll=personService_01.findAll();
				if(!getAll.isEmpty()) {
					for(Person p :getAll) {
						JSONObject object=new JSONObject();
						object.put("id", p.getId());
						object.put("fname", p.getFname());
						object.put("mname", p.getMname());
						object.put("lname", p.getLname());
						object.put("register", p.getRegtime());
						object.put("status", p.getStatus());
						object.put("add1", p.getAdd1());
						object.put("add2", p.getAdd2());
						object.put("add3", p.getAdd3());
						object.put("dob", p.getDob());
						object.put("mobile1", p.getMobile1());
						object.put("mobile2", p.getMobile2());
						object.put("email", p.getEmail());
						object.put("fax", p.getFax());
						object.put("nic", p.getNic());
						array.put(object);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return array.toString();
		}
		
		
		@ResponseBody()
		@PostMapping(value = "/update_person")
		public String update(@RequestParam ("p_id") int p_id,@RequestParam ("fname") String fname,@RequestParam ("mname") String mname
				,@RequestParam ("lname") String lname,@RequestParam ("add1") String add1,@RequestParam ("add2") String add2,
				@RequestParam ("add3") String add3,@RequestParam ("mobile1") String mobile1
				,@RequestParam ("mobile2") String mobile2,@RequestParam ("Email") String Email,@RequestParam ("nic") String nic
				,@RequestParam ("exampledate") String dob,@RequestParam ("fax") String fax){
//			System.out.println(person_obj);
			ResponseEntity<?> resPonese;
//			JSONObject j_obj=new JSONObject(person_obj);
			JSONObject resp_obj=new JSONObject();
			try {
				
				Person person=new Person();
				person.setId(p_id);
				person.setFname(fname);
				person.setMname(mname);
				person.setLname(lname);
				person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				person.setStatus(1);
				person.setAdd1(add1);
				person.setAdd2(add2);
				person.setAdd3(add3);
				person.setDob(AppDateTimeUtill.formatDate(dob));
				person.setMobile1(mobile1);
				person.setMobile2(mobile2);
				person.setEmail(Email);
				person.setFax(fax);
				person.setNic(nic);
				
				Person p_res=personService_01.save(person);
					resp_obj.put("p_id", p_res.getId());
					resp_obj.put("p_name", p_res.getFname());
				
//				if(j_obj.getInt("type") == 1) {    //citizen
//					Politicion politicion=new Politicion();
//					politicion.setId(j_obj.getInt("politicion_id"));
//					politicion.setReffCode(j_obj.getString("reff_code"));
//					politicion.setOtpCode(j_obj.getString("otp_code"));
//					politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//					politicion.setStatus(1);
//					Team team=new Team();
//					team.setId(j_obj.getInt("team_id"));
//					politicion.setTeam(team);
//					politicionService_01.save(politicion);
//									
//				}else if(j_obj.getInt("type") == 2) { //politicions
//					Citizen citzen=new Citizen();
//					citzen.setId(j_obj.getInt("citizen_id"));
//					citzen.setReffNo(j_obj.getString("reff_no"));
//					citzen.setStatus(1);
//					citzen.setPerson(person);
//					District district=new District();
//					district.setId(j_obj.getInt("district_id"));
//					citzen.setDistrict(district);
//					citzen.setCode(j_obj.getString("code"));
//					citizenService_01.save(citzen);
//				}	
//				
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
		
		
		@GetMapping(value = "/code")
		public ResponseEntity<?> sendCode(@RequestParam int p_type){
			try {
				List<String[]> setArray = new ArrayList();
				List<Citizen> getAll;
				getAll=citizenService_01.findByAll();
				System.out.println(p_type+" status of pass");
				try {
					
					if(p_type == 1) {   // active citizend send otp code
						
						if(!getAll.isEmpty()) {
							for(Citizen c: getAll) {
								Citizen citzen=new Citizen();
								citzen.setId(c.getId());
								citzen.setReffNo(c.getReffNo());
								citzen.setStatus(1);
								citzen.setPerson(c.getPerson());
								District district=new District();
								district.setId(c.getDistrict().getId());
								citzen.setDistrict(district);
								citzen.setCode(c.getCode());
								citzen=citizenService_01.save(citzen);
								System.out.println(citzen.getId()+" updated ID");
								
							}
							

							if(!getAll.isEmpty()) {
								for(Citizen c: getAll) {
									JSONObject obj=new JSONObject();
									if(c.getStatus() == 1) {
										
										obj.put("id",  c.getId());
										obj.put("name", c.getReffNo());
										String msgContent = "Dear "+c.getPerson().getFname()+" and your nic is number "+c.getPerson().getNic() + ","
										+ " and authentication code is  " + c.getCode() + " " +
										"please use this code and Vote now untill mid night ,automatically it will disable"
										+" District "+c.getDistrict().getName()+"Date "+AppDateTimeUtill.getCurrentDateTime().toString() ;
										
										String arry[] = { "Now vote is starting",c.getPerson().getEmail(),msgContent};
										setArray.add(arry);
//										System.out.println("Email working"+c.getPerson().getEmail());
									}
									
									
								}
							}
							
						}
					}else if(p_type == 2) { // Deactive citizend 
						if(!getAll.isEmpty()) {
							for(Citizen c: getAll) {
								Citizen citzen=new Citizen();
								citzen.setId(c.getId());
								citzen.setReffNo(c.getReffNo());
								citzen.setStatus(2);
								citzen.setPerson(c.getPerson());
								District district=new District();
								district.setId(c.getDistrict().getId());
								citzen.setDistrict(district);
								citzen.setCode(c.getCode());
								citzen=citizenService_01.save(citzen);
								System.out.println(citzen.getId()+" updated ID as "+citzen.getStatus());
								
							}
							
							if(!getAll.isEmpty()) {
								for(Citizen c: getAll) {
									JSONObject obj=new JSONObject();
									if(c.getStatus() == 2) {
										
										obj.put("id",  c.getId());
										obj.put("name", c.getReffNo());
										String msgContent = "Dear "+c.getPerson().getFname()+" and your nic is number "+c.getPerson().getNic() + ","
										+"Access automatically disabled thank you for using your valiable vote"
										+" District "+c.getDistrict().getName()+"Date "+AppDateTimeUtill.getCurrentDateTime().toString() ;
										
										String arry[] = { "Now vote is Disable",c.getPerson().getEmail(),msgContent};
										setArray.add(arry);
//										System.out.println("Email working"+c.getPerson().getEmail());
									}
									
									
								}
							}
							
							
						}
					}
			
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
				EmailThreadMessage emailThreadMannager = new EmailThreadMessage(setArray);
				Thread thread = new Thread(emailThreadMannager);
				thread.start();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return new ResponseEntity<String>("Sent",HttpStatus.ACCEPTED);
		}
		
		@ResponseBody
		@GetMapping(value = "/get_citizen_list")
		public String getAllCitizenList() {
			JSONArray array=new JSONArray();
			List<Citizen> getAll;
			try {
				getAll=citizenService_01.findByAll();
				if(!getAll.isEmpty()) {
					for(Citizen c: getAll) {
						JSONObject obj=new JSONObject();
						if(c.getPerson().getStatus() == 1) {
						JSONObject object=new JSONObject();
						object.put("c_id", c.getId());
						object.put("citi_status", c.getStatus());
						object.put("reff", c.getReffNo());
						object.put("distric_id", c.getDistrict().getId());
						object.put("distric_name", c.getDistrict().getName());
						object.put("otpcode", c.getCode());
						object.put("p_id", c.getPerson().getId());
						object.put("fname", c.getPerson().getFname());
						object.put("mname", c.getPerson().getMname());
						object.put("lname", c.getPerson().getLname());
						object.put("register", c.getPerson().getRegtime());
						object.put("add1", c.getPerson().getAdd1());
						object.put("add2", c.getPerson().getAdd2());
						object.put("add3", c.getPerson().getAdd3());
						object.put("dob", c.getPerson().getDob());
						object.put("mobile1", c.getPerson().getMobile1());
						object.put("mobile2", c.getPerson().getMobile2());
						object.put("email", c.getPerson().getEmail());
						object.put("fax", c.getPerson().getFax());
						object.put("nic", c.getPerson().getNic());
						array.put(object);
					}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(array.toString());
			return array.toString();
		
		}
		
		
		@ResponseBody()
		@PostMapping(value = "/update_citizen")
		public String update_citizen(@RequestParam ("p_id") int p_id,@RequestParam ("fname") String fname,@RequestParam ("mname") String mname
				,@RequestParam ("lname") String lname,@RequestParam ("add1") String add1,@RequestParam ("add2") String add2,
				@RequestParam ("add3") String add3,@RequestParam ("mobile1") String mobile1
				,@RequestParam ("mobile2") String mobile2,@RequestParam ("Email") String Email,@RequestParam ("nic") String nic
				,@RequestParam ("exampledate") String dob,@RequestParam ("fax") String fax,
				@RequestParam ("c_id") int c_id,
				@RequestParam ("reff") String reff,@RequestParam ("district_id") int district_id,
				@RequestParam ("code") String code){

			JSONObject resp_obj=new JSONObject();
			try {
				
				Person person=new Person();
				person.setId(p_id);
				person.setFname(fname);
				person.setMname(mname);
				person.setLname(lname);
				person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				person.setStatus(1);
				person.setAdd1(add1);
				person.setAdd2(add2);
				person.setAdd3(add3);
				person.setDob(AppDateTimeUtill.formatDate(dob));
				person.setMobile1(mobile1);
				person.setMobile2(mobile2);
				person.setEmail(Email);
				person.setFax(fax);
				person.setNic(nic);
				
				
				
//				if(j_obj.getInt("type") == 1) {    //citizen
//					Politicion politicion=new Politicion();
//					politicion.setId(j_obj.getInt("politicion_id"));
//					politicion.setReffCode(j_obj.getString("reff_code"));
//					politicion.setOtpCode(j_obj.getString("otp_code"));
//					politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
//					politicion.setStatus(1);
//					Team team=new Team();
//					team.setId(j_obj.getInt("team_id"));
//					politicion.setTeam(team);
//					politicionService_01.save(politicion);
//									
//				}else if(j_obj.getInt("type") == 2) { //politicions
					Citizen citzen=new Citizen();
					citzen.setId(c_id);
					citzen.setReffNo(reff);
					citzen.setStatus(1);
					citzen.setPerson(person);
					District district=new District();
					district.setId(district_id);
					citzen.setDistrict(district);
					citzen.setCode(code);
					citizenService_01.save(citzen);
//				}	
				Person p_res=personService_01.save(person);
					resp_obj.put("p_id", p_res.getId());
					resp_obj.put("p_name", p_res.getFname());
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
	
		
		@ResponseBody()
		@DeleteMapping(value = "/delete_citizen")
		public String delete_citizen(@RequestParam ("c_id") int c_id,@RequestParam ("p_id") int p_id){

			JSONObject resp_obj=new JSONObject();
			try {
				
				citizenService_01.delete(c_id);
				
				personService_01.delete(p_id);
				resp_obj.put("p_id", c_id);
				resp_obj.put("p_name", "deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
		
		@ResponseBody
		@GetMapping(value = "/get_polition_list")
		public String getAllPolitionList() {
			JSONArray array=new JSONArray();
			List<Politicion> getAll;
			try {
				getAll=politicionService_01.findAll();
				if(!getAll.isEmpty()) {
					for(Politicion c: getAll) {
						JSONObject obj=new JSONObject();
						if(c.getPerson().getStatus() == 1) {
						JSONObject object=new JSONObject();
						object.put("pp_id", c.getId());
						object.put("poli_status", c.getStatus());
						object.put("reff", c.getReffCode());
						object.put("team_id", c.getTeam().getId());
						object.put("team_name", c.getTeam().getName());
						object.put("otpcode", c.getOtpCode());
						object.put("p_id", c.getPerson().getId());
						object.put("fname", c.getPerson().getFname());
						object.put("mname", c.getPerson().getMname());
						object.put("lname", c.getPerson().getLname());
						object.put("register", c.getPerson().getRegtime());
						object.put("add1", c.getPerson().getAdd1());
						object.put("add2", c.getPerson().getAdd2());
						object.put("add3", c.getPerson().getAdd3());
						object.put("dob", c.getPerson().getDob());
						object.put("mobile1", c.getPerson().getMobile1());
						object.put("mobile2", c.getPerson().getMobile2());
						object.put("email", c.getPerson().getEmail());
						object.put("fax", c.getPerson().getFax());
						object.put("nic", c.getPerson().getNic());
						array.put(object);
					}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(array.toString());
			return array.toString();
		
		}
		
		
		@ResponseBody()
		@PostMapping(value = "/update_politions")
		public String update_politions(@RequestParam ("p_id") int p_id,@RequestParam ("fname") String fname,@RequestParam ("mname") String mname
				,@RequestParam ("lname") String lname,@RequestParam ("add1") String add1,@RequestParam ("add2") String add2,
				@RequestParam ("add3") String add3,@RequestParam ("mobile1") String mobile1
				,@RequestParam ("mobile2") String mobile2,@RequestParam ("Email") String Email,@RequestParam ("nic") String nic
				,@RequestParam ("exampledate") String dob,@RequestParam ("fax") String fax,
				@RequestParam ("pp_id") int pp_id,
				@RequestParam ("reff") String reff_code,@RequestParam ("team_id") int team_id,
				@RequestParam ("code") String code){

			JSONObject resp_obj=new JSONObject();
			try {
				
				Person person=new Person();
				person.setId(p_id);
				person.setFname(fname);
				person.setMname(mname);
				person.setLname(lname);
				person.setRegtime(AppDateTimeUtill.getCurrentDateTime());
				person.setStatus(1);
				person.setAdd1(add1);
				person.setAdd2(add2);
				person.setAdd3(add3);
				person.setDob(AppDateTimeUtill.formatDate(dob));
				person.setMobile1(mobile1);
				person.setMobile2(mobile2);
				person.setEmail(Email);
				person.setFax(fax);
				person.setNic(nic);
				
				
				
//				if(j_obj.getInt("type") == 1) {    //citizen
					Politicion politicion=new Politicion();
					politicion.setPerson(person);
					politicion.setId(pp_id);
					politicion.setReffCode(reff_code);
					politicion.setOtpCode(code);
					politicion.setRegtime(AppDateTimeUtill.getCurrentDateTime());
					politicion.setStatus(1);
					Team team=new Team();
					team.setId(team_id);
					politicion.setTeam(team);
					politicionService_01.save(politicion);
//									
//				}else if(j_obj.getInt("type") == 2) { //politicions
//					Citizen citzen=new Citizen();
//					citzen.setId(c_id);
//					citzen.setReffNo(reff);
//					citzen.setStatus(1);
//					citzen.setPerson(person);
//					District district=new District();
//					district.setId(district_id);
//					citzen.setDistrict(district);
//					citzen.setCode(code);
//					citizenService_01.save(citzen);
//				}	
				Person p_res=personService_01.save(person);
					resp_obj.put("p_id", p_res.getId());
					resp_obj.put("p_name", p_res.getFname());
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
		
		@Autowired
		PoliticionRepository politicionRepository;
		
		@Autowired
		PoliticionsHasElectionRepository politicionsHasElectionRepository;
		
		@ResponseBody()
		@DeleteMapping(value = "/delete_polition")
		public String delete_polition(@RequestParam ("pp_id") int pp_id,@RequestParam ("p_id") int p_id){

			JSONObject resp_obj=new JSONObject();
			try {
				
//				politicionsHasElectionRepository.delete(entity);
				
				Politicion politicion=new Politicion();
				politicion.setId(pp_id);
				politicionRepository.delete(politicion);
				
				personService_01.delete(p_id);
				resp_obj.put("p_id", pp_id);
				resp_obj.put("p_name", "deleted");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("OK");
			}
			
			return resp_obj.toString();
		}
		
	
}
