package model.dao;

import exeption.DBConnException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminAddUserDao {
	
	public static int adminAddUser(String name, String password, boolean admin) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		Statement stmt = null;
		ResultSet resualt = null;
		try {
			connection = DBUtil.getMysqlConn();
			preStmt = connection.prepareStatement("select * from [user] where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				return 0;
			} else {
				if (admin == true) {
					preStmt = connection.prepareStatement("insert into [user](name,password,admin,times) values (?,?,1,2)");
					preStmt.setString(1, name);
					preStmt.setString(2, password);
					preStmt.executeUpdate();
				} else {
					preStmt = connection.prepareStatement("insert into [user](name,password,admin,times) values (?,?,0,2)");
					preStmt.setString(1, name);
					preStmt.setString(2, password);
					preStmt.executeUpdate();
					stmt = connection.createStatement();
					String DBTname = name + "Words"; 
					stmt.executeUpdate("select * into " + DBTname + " from words");
				}
			}
		} catch (SQLException | DBConnException e) {
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
