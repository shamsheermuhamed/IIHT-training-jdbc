package jdbc;

import java.sql.*;
import java.util.Scanner;
public class Insertion {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="insert into student (id,name,city,course,marks) values(?,?,?,?,?);";

	public static void main(String[] args) {

		try(Connection con=DriverManager.getConnection(url,user,pass);
				Statement st= con.createStatement();
				PreparedStatement ps=con.prepareStatement(query);){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student id");
			int id=sc.nextInt();
			System.out.println("enter student name");
			String name=sc.next();
			System.out.println("enter student city");
			String city=sc.next();
			System.out.println("enter student course");
			String course=sc.next();
			System.out.println("enter student marks");
			int marks=sc.nextInt();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			ps.setString(4, course);
			ps.setInt(5, marks);
			int b=ps.executeUpdate();
			if(b==1) {
				System.out.println("Student details added successfully");
			}
		}catch(SQLException e) {
			
		}
		
		
	}

}
