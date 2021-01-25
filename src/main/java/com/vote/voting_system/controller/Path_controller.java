package com.vote.voting_system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Path_controller {
	
	@GetMapping(value = {"/login","/"})
	public String login() throws Exception{
		return "login";
	}
	
	@GetMapping(value ="/Dashboard")
	public String Dashboard() {
		return "/Dashboard";
	}
	
	@GetMapping(value ="/daily_report")
	public String daily_report() {
		return "/daily_report";
	}
	
	@GetMapping(value ="/personregister")
	public String test() {
		return "/personregister";
	}
	
	@GetMapping(value="/citizen_page")
	public String test_page() {
		return "/citizen_page";
	}
	
	@GetMapping(value = "/Home")
	public String home_page() {
		return "/Home";
	}
	
	@GetMapping(value = "/sendData")
	public String vehicle_page() {
		return "/sendData";
	}
	
	@GetMapping(value = "/politicion_page")
	public String mark_vehicle() {
		return "/politicion_page";
	}
	
	@GetMapping(value = "/reports")
	public String reports() {
		return "/reports";
	}
	
	@GetMapping(value = "/customer_visit_report")
	public String cusomer_visit_report() {
		return "/cusomer_visit_report";
	}
}
