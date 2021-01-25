package com.vote.voting_system.utill;

import java.util.Random;

public class OtpController {

	public static char[] generatorOTP(int length) 
	  { 
	    System.out.print("Your OTP is : "); 
	              //Creating object of Random class
	    Random obj = new Random(); 
	    char[] otp = new char[length]; 
	    for (int i=0; i<length; i++) 
	    { 
	      otp[i]= (char)(obj.nextInt(10)+48); 
	    } 
	    return otp; 
	  } 
	
}
