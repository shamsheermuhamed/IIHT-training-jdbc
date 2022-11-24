package jdbc;

/* code for all crud operations in a single class */

import java.sql.*;
import java.util.Scanner;

public class CrudOperations {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from student";
	public static int x=0;
	
	public static void main(String[] args) {
		do {
		try(Connection con=DriverManager.getConnection(url,user,pass);
				PreparedStatement ps=con.prepareStatement(query);){
		   
			x=getvalues();
		    switch(x) {
		    	case 1: getAllStudents(con,ps);
		    			break;
		    	case 2: getStudentById(con,ps);
		    			break;
		    	case 3: insertStudent(con,ps);
		    			break;
		    	case 4: updateStudent(con,ps);
		    			break;
		    	case 5:deleteStudent(con,ps);
		    			break;
		    	case 6:System.exit(0);
    			       break;
		    	default: break;
		    }
		   
		}catch(SQLException e) {
			
		}
		}while(x<6);
	}
	
	private static int getvalues() {
		System.out.println("\n\n 1.Getallstudents \n 2.GetStudentById \n 3.Insert Student"
				+ "\n 4.Update student \n 5.Delete student \n 6.exit");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the operation number to perform");
		int x=sc.nextInt();
		return x;
	}
	
	private static void deleteStudent(Connection con, PreparedStatement ps) throws SQLException{
		// TODO Auto-generated method stub
		String query="delete from student where id=?";
		ps=con.prepareStatement(query);
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
		
	}

	private static void updateStudent(Connection con, PreparedStatement ps) throws SQLException{

		String query="update student set marks = ? where id = ?;";
		ps=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student id");
		int id=sc.nextInt();
		System.out.println("enter marks to update");
		int marks=sc.nextInt();
		
		ps.setInt(1, marks);
		ps.setInt(2, id);
		int b=ps.executeUpdate();
		if(b==1) {
			System.out.println("Student marks updated successfully");
		}
		else {
			System.out.println("No student found with the given id");
		}
	}

	private static void insertStudent(Connection con, PreparedStatement ps) throws SQLException{
		String query="insert into student (id,name,city,course,marks) values(?,?,?,?,?);";
		ps=con.prepareStatement(query);
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
	}

	public static void getAllStudents(Connection con, PreparedStatement ps) throws SQLException {
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.print("\nid = "+ rs.getInt("id"));
			System.out.print("\t\tname = "+ rs.getString("name"));
			System.out.print("\t\tcity = "+ rs.getString("city"));
			System.out.print("\t\tsubject = "+ rs.getString("course"));
			System.out.print("\t\tmarks = "+ rs.getInt("marks"));
		}
	}
	
	public static void getStudentById(Connection con, PreparedStatement ps) throws SQLException {
		String query1="select * from student where id=?";
		ps=con.prepareStatement(query1);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student id");
		int id=sc.nextInt();
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.print("\nid = "+ rs.getInt("id"));
			System.out.print("\t\tname = "+ rs.getString("name"));
			System.out.print("\t\tcity = "+ rs.getString("city"));
			System.out.print("\t\tsubject = "+ rs.getString("course"));
			System.out.print("\t\tmarks = "+ rs.getInt("marks"));
		}
	}
}
