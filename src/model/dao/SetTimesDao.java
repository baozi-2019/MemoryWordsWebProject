package model.dao;

import exeption.DBConnException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetTimesDao {
	
	public static int setTimes(int times, String name) {
		name += "Words";
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = DBUtil.getMysqlConn();
			stmt = connection.createStatement();
			String sql = "update " + name + " set times='" + times  + "'";
			int t = stmt.executeUpdate(sql);
			return t;
		} catch (SQLException | DBConnException e) {
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
