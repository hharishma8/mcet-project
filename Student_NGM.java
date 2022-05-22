package com.mcet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Student_NGM implements Details {
	 public void get_details() {
		 InputStreamReader i = new InputStreamReader(System.in);
			BufferedReader b = new BufferedReader(i);
		 System.out.println("WELCOME TO NGM COLLEGE");
     	System.out.println("Enter students name "); 
     	System.out.println("Enter students email ");
     	System.out.println("Enter students Mobileno");
     	System.out.println("Enter students Course ");
      }

	@Override
	public void get_staffdetails() {
		// TODO Auto-generated method stub
		
	}

}
