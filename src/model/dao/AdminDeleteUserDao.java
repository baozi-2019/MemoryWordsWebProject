package model.dao;

import exeption.DBConnException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDeleteUserDao {
	public static int adminDeleteUser(String name, boolean admin) {
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
				preStmt = connection.prepareStatement("delete from user where name=?");
				preStmt.setString(1, name);
				preStmt.executeUpdate();
				if (admin == false) {
					String DBTname = name + "Words";
					stmt = connection.createStatement();
					stmt.executeUpdate("drop table " + DBTname);
				}
			} else {
				return 0;
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
