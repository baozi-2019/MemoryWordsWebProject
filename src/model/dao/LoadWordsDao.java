package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import exeption.DBConnException;
import modle.entity.Words;
import util.DBUtil;

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
	
	public static Vector<Words> loadwords(String name) {
		Vector<Words> wordSet = new Vector<Words>();
		name += "Words";
		Connection connection = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			connection = DBUtil.getMysqlConn();
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
		} catch (SQLException | DBConnException e) {
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
