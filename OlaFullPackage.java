package com.chainsys;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class OlaFullPackage {
static int fare; static float fare_gst; static float fare_senior;
	 public static void main(String[] args) {
		 
		 login();
		 
		 
	 }	 
	
// Level 1 - Check whether the entered mobile number and password is correct //
	 
	
	 	public static void login() {
	 		System.out.println("LEVEL 1");
		  Scanner S = new Scanner(System.in);
	  	System.out.println("Enter the mobile No:");
		long mobileNo = S.nextLong();
		String mobileNostring = String.valueOf(mobileNo);
		System.out.println("Enter the password:");
			String password = S.next();
			if(mobileNostring.length() == 10 && password.length()>=8) {
				System.out.println("Its a valid mobile number and password");
				System.out.println("Successfully logged in");
			}
			else {
				System.out.println("Invalid password or mobile number");
				System.out.println();
				System.out.println("Tip1 :Your MobileNo should be 10 digits");
				System.out.println("Tip2 :Your password must be 8 digits");
				System.exit(0); // to stop the flow //
		}
			
 
		cabType();
	  
	}
	 

	//Level 2 - Display the cabtypes //
	
	  public static void cabType() {
		  System.out.println("LEVEL 2");
		String[] cabTypes = new String[3];
		cabTypes[0] = "Micro";
		cabTypes[1] = "Mini";
		cabTypes[2] = "Prime";
		System.out.println("choose one from the listed cabtypes:");
		Arrays.toString(cabTypes);
		System.out.println("No.of.Cab Types:" + cabTypes.length);
		//for array print
		for(int i=0;i<cabTypes.length;i++) {
			String cType = cabTypes[i];
			System.out.println(cType);
		}
		fareCalc();
		//for each
		//for(String type: cabTypes) {
			//System.out.println(type);
		//}
		} 

	// Level 3 - Calculate the fare according to the cabchoices//

	public static void fareCalc( ) {
		System.out.println("LEVEL 3");
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the cabchoice:");
		String[] cabTypes = new String[3];
		cabTypes[0] = "Micro";
		cabTypes[1] = "Mini";
		cabTypes[2] = "Prime";
		boolean isvalid = false;
		String cabChoice = S.next();
		for(String type : cabTypes) {
			if(type.equalsIgnoreCase(cabChoice)) {  //searching whether the entered cabchoice is in our listed cab array //
				isvalid = true;
				break;
		}
		}
		if(isvalid) {
			System.out.println("your choosed " + cabChoice);
		}
		else {
			System.out.println("Invalid Cabtype"); 
			System.exit(0); //Tell whether the entered cab is valid or not //
		}
			
		System.out.println("Enter the distance in km:");
		int km = S.nextInt();
		if(cabChoice.equalsIgnoreCase("Micro")) {
		 fare = 10 * km;
			System.out.println("Your fare for your micro cab is :" + fare);
			
		}
		if(cabChoice.equalsIgnoreCase("Mini")) {
		 fare = 15 * km;
				System.out.println("Your fare for your mini cab is :" + fare);
				
			}
		if(cabChoice.equalsIgnoreCase("Prime")) {
			fare = 20 * km;
				System.out.println("Your fare for your prime cab is : " + fare);
				
			}
		System.out.println(fare);
		Gst(fare);
		
			
			
		
	} 
	//Level 4 - Calculate fare with GST //
	public static void Gst(int fare) {
		System.out.println("LEVEL 4");
		
		System.out.println("GST = 7%");
		 fare_gst =((fare * 7)/100 + fare);
		System.out.println("Your total fare with GST:");
		System.out.println(fare_gst);
		booking();
		
		
	}
	//Level 5 -  confirm the booking according to the pickupdate and time //
	public static void booking() {
		System.out.println("LEVEL 5");
		Scanner S = new Scanner(System.in);
		System.out.println("Enter the picupdate:");
		String pickupdate = S.next();
		System.out.println("Enter the pickuptime:");
		String picktimestr = S.next();
		LocalTime cabpickuptime_obj = LocalTime.parse(picktimestr); // time to obj //
		
		LocalDate currentdate = LocalDate.now(); // current date //
		LocalTime currenttime = LocalTime.now();// current time //
		
		LocalDate dobobj = LocalDate.parse(pickupdate); // date to obj //
		//date checking //
		if(dobobj.isBefore(currentdate)) {
			System.out.println("Entered date is before the current date");System.out.println("Sorry!Unbale to book");
		}
		if(dobobj.isAfter(currentdate)) {
			System.out.println("Entered date is after he current date");
		}
		if(dobobj.isEqual(currentdate)) {
			System.out.println("Given date is today ");
		}
		//time checking //
		if(cabpickuptime_obj.isBefore(currenttime)) {
			System.out.println("Entered time is befor the current time");System.out.println("Sorry! Unable to book");
		}
		if(cabpickuptime_obj.isAfter(currenttime)) {
			System.out.println("Entered time is after the current time"); 
		}
		if(dobobj.isAfter(currentdate) ||dobobj.isEqual(currentdate	)||	cabpickuptime_obj.isAfter(currenttime)) {
			System.out.println("You are eligibile for booking,Happy journey");
		}
		peakCheck();
		
		
		
	}  
	//Level 6 
	//from the pickup time, get the hours and check whether its a peak hour and increase the fare of 1.25%//
		public static void peakCheck() {
			System.out.println("LEVEL 6");
			Scanner S = new Scanner(System.in);
			System.out.println("Enter the pickuptime:");
			String picktimestr = S.next();
			LocalTime cabpickuptime_obj = LocalTime.parse(picktimestr);
			int hour = cabpickuptime_obj.getHour();
			System.out.println("Hour:"+hour);
				if(hour>=17 && hour <=19) {   // 5 to 7 pm //
				System.out.println("Its a peak hour");
				float		fare_peak = 	(fare_gst * 125) / 100 + fare_gst ;	
				System.out.println("Your fare for peakhour is :" + fare_peak );
			}
			else {
				System.out.println("Its not a peak hour");
			}
				seniorCheck();
	
	
	
	}
		//Level 7 //
		//check whether user is a senior citizen , If it is , make a  discount of 60% //
		
		public static void seniorCheck() {
			System.out.println("LEVEL 7");
			Scanner S = new Scanner(System.in);
	    	System.out.println("Enter Date of Birth:");
	    	String dobstr = S.next();
	    	LocalDate dobobj = LocalDate.parse(dobstr);
	    	System.out.println("DOBOBJ:" + dobobj);
	    	LocalDate currentdate = LocalDate.now();
	    	Period P = Period.between(dobobj,currentdate);
	    	System.out.println("Years:" + P.getYears());
	    	if(P.getYears()>=60) {
	    		System.out.println("You are a senior citizen. You may get a discout of 60%");
	    		fare_senior = fare_gst - (60/100);
	    		System.out.println("YOUR TOTAL FARE WITH DISCOUNT: "+ fare_senior);
	    	}
	    	else {
	    		System.out.println("You are not a senior citizen");
	    	}
	    	
		}
}

