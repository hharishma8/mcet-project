package com.mcet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice;
		System.out.println("1.Enroll students NGM ");
		System.out.println("2.Enroll students MCET ");
		System.out.println("3.Search MCET students by mobile number");
		System.out.println("4.Search MCET students by rollno");
		System.out.println("5.Update semester fee");
		System.out.println("Enter the choice 1,2,3,4,5");
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(i);
		choice=Integer.parseInt(b.readLine());
		switch(choice){    
		case 1: 
			Student_NGM sngm = new Student_NGM();
			sngm.get_details();
	        break;  
		case 2:    
			Student s = new Student();
			s.get_details();
			s.db_dataupdate();
			
	        break;  
		case 3:
			Student s1 = new Student();
			s1.get_studentdetail();
			
		case 4:
		    Student s2 = new Student();
		    s2.get_studentdetail1();
		case 5:
			Student s3 =new Student();
			s3.fee_update();
		    
		default:     
		   System.out.println("Invalid choice");


	}

}
}
