package model.dao;

import exeption.DBConnException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminChangeUserDao {
	
	public static int adminChangeUser(String name, String password) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet resualt = null;
		try {
			connection = DBUtil.getMysqlConn();
			preStmt = connection.prepareStatement("select * from [user] where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				preStmt = connection.prepareStatement("update [user] set password=? where name=?");
				preStmt.setString(1, password);
				preStmt.setString(2, name);
				preStmt.executeUpdate();
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
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}
