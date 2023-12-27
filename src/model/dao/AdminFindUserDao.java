package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exeption.DBConnException;
import modle.entity.Users;
import util.DBUtil;

public class AdminFindUserDao {
	
	public static int findUser(String name, Users user) {
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet resualt = null;
		try {
			connection = DBUtil.getMysqlConn();
			preStmt = connection.prepareStatement("select * from user where name=?");
			preStmt.setString(1, name);
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				user.setName(resualt.getNString(1));
				user.setPassword(resualt.getNString(2));
				user.setAdmin(resualt.getBoolean(3));
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
