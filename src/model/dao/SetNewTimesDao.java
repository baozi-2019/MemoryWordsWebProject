package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exeption.DBConnException;
import modle.entity.Words;
import util.DBUtil;

public class SetNewTimesDao {
	
	public static void setNewTimes(String name, Vector<Words> words) {
		name += "Words";
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = DBUtil.getMysqlConn();
			stmt = connection.createStatement();
			int i;
			for (i = 0; i < words.size(); i++) {
				String sql = "update " + name + " set times=" + words.elementAt(i).getTimes()  + " where english='" + words.elementAt(i).getEnglish() +"'";
				stmt.executeUpdate(sql);
			}
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
	}
}
