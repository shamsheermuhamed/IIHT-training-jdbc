package jdbc;

import java.sql.*;
import java.util.Scanner;
public class Delete {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="delete from student where id=?";
	
	public static void main(String[] args) {

		try(Connection con=DriverManager.getConnection(url,user,pass);
				PreparedStatement ps=con.prepareStatement(query);){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter student id");
			int id=sc.nextInt();
			ps.setInt(1, id);
			int b=ps.executeUpdate();
			if(b==1) {
				System.out.println("Student deleted successfully");
			} else {
				System.out.println("No student found with the given id");
			}
		}catch(SQLException e) {
			
		}
	}
}
