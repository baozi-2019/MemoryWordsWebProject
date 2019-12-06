package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modle.entity.Words;

public class SetNewTimesDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static void setNewTimes(String name, Vector<Words> words) {
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
			int i;
			for (i = 0; i < words.size(); i++) {
				String sql = "update " + name + " set times=" + words.elementAt(i).getTimes()  + " where english='" + words.elementAt(i).getEnglish() +"'";
				stmt.executeUpdate(sql);
			}
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
	}
}
