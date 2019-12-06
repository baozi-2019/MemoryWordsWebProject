package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modle.entity.Users;

public class AdminFindUserDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static int findUser(String name, Users user) {
		try {
			Class.forName(CONNECTION);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet resualt = null;
		try {
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			preStmt = connection.prepareStatement("select * from [user] where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				user.setName(resualt.getNString(1));
				user.setPassword(resualt.getNString(2));
				user.setAdmin(resualt.getBoolean(3));
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
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
