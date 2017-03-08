package connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
	
	static Statement stmt;
	static java.sql.Connection con;
	static String userid = "root";
	static String password = "";
	private static ResultSet rs = null;
	static String url = "jdbc:mysql://127.0.0.1:3306/CineGo";
	
	public static void close(){
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static java.sql.Connection getConnection()
	{
		try {
			con =DriverManager.getConnection(url, userid, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet selectFrom(String queryString){

		java.sql.Connection con = getConnection();
		try{
			stmt = ((java.sql.Connection) con).createStatement();
			setRs((ResultSet) stmt.executeQuery(queryString));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getRs();
	}
	
	public static void update(String queryString){

		java.sql.Connection con = getConnection();
		try{
			stmt = ((java.sql.Connection) con).createStatement();
			stmt.executeUpdate(queryString);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		Connection.rs = rs;
	}	
	
}		
	

