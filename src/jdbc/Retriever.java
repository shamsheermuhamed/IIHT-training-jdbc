package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Retriever {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from student";
	static final String query1="select * from student where id=?";
	
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection(url,user,pass);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery(query);
				PreparedStatement ps=con.prepareStatement(query1);){
			System.out.println("Deatils of students");
			while(rs.next()) {
				System.out.print("\nid = "+ rs.getInt("id"));
				System.out.print("\t\tname = "+ rs.getString("name"));
				System.out.print("\t\tcity = "+ rs.getString("city"));
				System.out.print("\t\tsubject = "+ rs.getString("course"));
				System.out.print("\t\tmarks = "+ rs.getInt("marks"));
			}
			
			System.out.println("\n\n Enter student id for specific student details");
			Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			ps.setInt(1, id);
			ResultSet rs1= ps.executeQuery();
			while(rs1.next()) {
				System.out.print("\nid = "+ rs1.getInt("id"));
				System.out.print("\t\tname = "+ rs1.getString("name"));
				System.out.print("\t\tcity = "+ rs1.getString("city"));
				System.out.print("\t\tsubject = "+ rs1.getString("course"));
				System.out.print("\t\tmarks = "+ rs1.getInt("marks"));
			}
			
			
		} catch(SQLException e) {
			
		}
	}

}
