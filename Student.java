package com.mcet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Student implements Details {
	 String name,email,course,address;
	 int rollno,semester;
	 String college="mcet";
	 String dbname="/postgres";
	 String table="/mcetstudent";
	 String dburl="jdbc:postgresql://localhost:5432";
	 String user="postgres";
	 String pwd="password123";
	 long mobile,fee;
             public void get_details() {
            	
            	 try {

                	 InputStreamReader i = new InputStreamReader(System.in);
             		BufferedReader b = new BufferedReader(i);
             		
                	 System.out.println("WELCOME TO MCET");
                	System.out.println("Enter students name "); 
                	name=b.readLine();
                	System.out.println("Enter students email ");
                	email=b.readLine();
                	System.out.println("Enter students Mobile");
                	mobile=Long.parseLong(b.readLine());
                	System.out.println("Enter students course ");
                	course=b.readLine();
                	System.out.println("Enter students address ");
                	address=b.readLine();
                	System.out.println("Enter students rollno");
                	rollno=Integer.parseInt(b.readLine());
                	System.out.println("Name: "+name);
                	System.out.println("Email: "+email);
                	System.out.println("Mobileno: "+mobile);
                	System.out.println("Course: "+course);
                	System.out.println("address: "+address);
                	
                 

                	



     } catch (IOException ex){ System.out.println(ex.getMessage());}
             }
             

			
			public void db_dataupdate() throws SQLException {
				try(Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);) {
					String sql="INSERT INTO mcetstudent (name,mobile,college,address,course,email,rollno) VALUES (?,?,?,?,?,?,?)";
					if (c != null) {
		                System.out.println("Connected to the database! " +dbname);
		                PreparedStatement pstmt = c.prepareStatement(sql);
		                pstmt.setString(1, name);
		                pstmt.setLong(2, mobile);
		                pstmt.setString(3, college);
		                pstmt.setString(4, address);
		                pstmt.setString(5, course);
		                pstmt.setString(6, email);
		                pstmt.setInt(7, rollno);
		                
		                pstmt.executeUpdate();
		                System.out.println(name+" "+mobile+" "+email+"  "+address+" "+course+"  Added to table " +table);
			               
		                
		                
		            } else {
		                System.out.println("Failed to make connection! "+dbname);
		            }
					
				}
				
			}
			public void get_studentdetail() throws SQLException, NumberFormatException, IOException {
				try(Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);) {
					String sql="SELECT * FROM mcetstudent WHERE mobile=?";
					long mobile;
					
					if (c != null) {
		                System.out.println("Connected to the database! " +dbname);
		                InputStreamReader r = new InputStreamReader(System.in);    
		                BufferedReader br = new BufferedReader(r); 
		                System.out.println("Enter the Students mobile number :");
		                mobile=Long.parseLong(br.readLine());
		                PreparedStatement pstmt = c.prepareStatement(sql);
		                				               
		                pstmt.setLong(1, mobile);
		                				                
		                ResultSet rs = pstmt.executeQuery();
		                while (rs.next()) {
		                System.out.println(rs.getString("name") + "\t"   + rs.getLong("mobile") + "\t" + rs.getString("college")+ "\t" + rs.getString("address")+ "\t" + rs.getString("course")+ "\t" + rs.getString("email")+"\t"+rs.getInt("rollno"));
		                }
					
		    public void get_studentdetail1() throws SQLException, NumberFormatException, IOException {
		    				try(Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);) {
		    					String sql="SELECT * FROM mcetstudent WHERE rollno=?";
		    					int rollno;
		    					
		    					if (c != null) {
		    		                System.out.println("Connected to the database! " +dbname);
		    		                InputStreamReader r = new InputStreamReader(System.in);    
		    		                BufferedReader br = new BufferedReader(r); 
		    		                System.out.println("Enter the Students rollno number :");
		    		                rollno=Integer.parseInt(br.readLine());
		    		                PreparedStatement pstmt = c.prepareStatement(sql);
		    		                				               
		    		                pstmt.setInt(1, rollno);
		    		                				                
		    		                ResultSet rs = pstmt.executeQuery();
		    		                while (rs.next()) {
		    		                System.out.println(rs.getString("name") + "\t"   + rs.getLong("mobile") + "\t" + rs.getString("college")+ "\t" + rs.getString("address")+ "\t" + rs.getString("course")+ "\t" + rs.getString("email")+"\t"+rs.getInt("rollno"));
		    		                }        
		                
		            } else {
		                System.out.println("Failed to make connection! "+dbname);
		            }
				
			}
}



			@Override
			public void get_staffdetails() {
				// TODO Auto-generated method stub
				
			
			}
			public void fee_update() throws SQLException, Exception, IOException {
				// TODO Auto-generated method stub
				try(Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);) {
					String sql="INSERT INTO mcetfee (rollno,semester,fee) VALUES (?,?,?)";
					String sqlrno="SELECT * FROM mcetstudent WHERE rollno=?";
					if (c != null) {
		                     System.out.println("Connected to the database! " +dbname);
                                InputStreamReader i = new InputStreamReader(System.in);
             		            BufferedReader b = new BufferedReader(i);
                                System.out.println("Enter students rollno");
                	            rollno=Integer.parseInt(b.readLine());
                                System.out.println("Enter students semester");
                	            semester=Integer.parseInt(b.readLine());
                                System.out.println("Enter students semester fee");
                	            fee=Long.parseLong(b.readLine());
                	            PreparedStatement pstmt1 = c.prepareStatement(sqlrno);
 				               
	    		                pstmt1.setInt(1, rollno);
	    		                				                
	    		                ResultSet rs1 = pstmt1.executeQuery();
                            if (!rs1.isBeforeFirst() ) {    
                           	 System.out.println("No data"); 
                            } 
                            else {
		                        PreparedStatement pstmt = c.prepareStatement(sql);
		                
		                        pstmt.setInt(1, rollno);
                                pstmt.setInt(2, semester);
                                pstmt.setLong(3, fee);
		                
		                        pstmt.executeUpdate();
		                System.out.println(rollno+" "+semester+" "+fee);
			               
                            }
		                
		            } else {
		                System.out.println("Failed to make connection! "+dbname);
		            }
}
			
			}
}
					
