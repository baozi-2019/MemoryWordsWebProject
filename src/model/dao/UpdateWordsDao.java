package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateWordsDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static int changeWords(String english, String chinese, int times) {
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
			preStmt = connection.prepareStatement("select * from words where english=?");
			preStmt.setString(1, english);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				preStmt = connection.prepareStatement("update words set chinese=?, times=? where english=?");
				preStmt.setString(1, chinese);
				preStmt.setInt(2, times);
				preStmt.setString(3, english);
				preStmt.executeUpdate();
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
	public static int deleteWords(String english) {
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
			preStmt = connection.prepareStatement("select * from words where english=?");
			preStmt.setString(1, english);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				preStmt = connection.prepareStatement("delete from words where english=?");
				preStmt.setString(1, english);
				preStmt.executeUpdate();
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resualt != null) {
					resualt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
	
	public static int addWords(String english, String chinese) {
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
			preStmt = connection.prepareStatement("select * from words where english=?");
			preStmt.setString(1, english);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				return 0;
			} else {
				connection = DriverManager.getConnection(URL, NAME, PASSWORD);
				preStmt = connection.prepareStatement("insert into words(english,chinese,times) values (?,?,2)");
				preStmt.setString(1, english);
				preStmt.setString(2, chinese);
				preStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resualt != null) {
					resualt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
