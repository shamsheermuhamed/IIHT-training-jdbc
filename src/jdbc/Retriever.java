package jdbc;

import java.sql.*;

public class Retriever {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from student where id=?";
	
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection(url,user,pass);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery(query);){
			
			while(rs.next()) {
				System.out.print("\nid = "+ rs.getInt("id"));
				System.out.print("\t\tname = "+ rs.getString("name"));
				System.out.print("\t\tcity = "+ rs.getString("city"));
				System.out.print("\t\tsubject = "+ rs.getString("course"));
				System.out.print("\t\tmarks = "+ rs.getInt("marks"));
			}
			
		} catch(SQLException e) {
			
		}
	}

}
