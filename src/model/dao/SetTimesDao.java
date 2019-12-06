package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetTimesDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static int setTimes(int times, String name) {
		try {
			Class.forName(CONNECTION);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		name += "Words";
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			String sql = "update " + name + " set times='" + times  + "'";
			int t = stmt.executeUpdate(sql);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
