package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static int register(String name, String password) {
		try {
			Class.forName(CONNECTION);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		PreparedStatement preStmt = null;
		Statement stmt = null;
		ResultSet resualt = null;
		try {
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			preStmt = connection.prepareStatement("select * from [user] where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				return 0;
			} else {
				preStmt = connection.prepareStatement("insert into [user](name,password,admin,times) values (?,?,0,2)");
				preStmt.setString(1, name);
				preStmt.setString(2, password);
				int flag = preStmt.executeUpdate();
				stmt = connection.createStatement();
				String DBTname = name + "Words"; 
				int flags = stmt.executeUpdate("select * into " + DBTname + " from words");
				if (flag == 0) {
					return 0;
				}
				if (flags ==0) {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
