package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modle.entity.Words;

/**
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: LoadWordsDao.java
* @Description: 加载单词，一次将词库里的单词全部加载。
*
* @version: v1.0.0
* @author: baozi
* @date: 2019年12月4日 下午1:04:31 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019年12月4日       	baozi           v1.0.0                             无
 */

public class LoadWordsDao {
	private static final String CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	public static Vector<Words> loadwords(String name) {
		Vector<Words> wordSet = new Vector<Words>();
		name += "Words";
		try {
			Class.forName(CONNECTION);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			stmt = connection.createStatement();
			String sql = "select * from " + name + " where times > 0";
			result = stmt.executeQuery(sql);
			while (result.next()) {
				Words word = new Words();
				word.setEnglish(result.getNString(1));
				word.setChinese(result.getNString(2));
				word.setTimes(result.getInt(3));
				wordSet.add(word);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return wordSet;
	}
}
