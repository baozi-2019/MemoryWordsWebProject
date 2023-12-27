package model.dao;

import exeption.DBConnException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterDao {
	
	public static int register(String name, String password) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		Statement stmt = null;
		ResultSet resualt = null;
		try {
			connection = DBUtil.getMysqlConn();
			preStmt = connection.prepareStatement("select * from user where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				return 0;
			} else {
				preStmt = connection.prepareStatement("insert into user(name,password,admin,times) values (?,?,0,2)");
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
		} catch (SQLException | DBConnException e) {
			e.printStackTrace();
		} finally {
			try {
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
