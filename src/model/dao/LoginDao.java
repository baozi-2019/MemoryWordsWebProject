package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modle.entity.Users;

/**
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: LoginDao.java
* @Description: 连接数据库，查询登录身份是否正确
*
* @version: v1.0.0
* @author: baozi
* @date: 2019年12月3日 上午8:07:02 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019年12月3日       	baozi           v1.0.0                              无
 */

public class LoginDao {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
	private static final String NAME = "sa";
	private static final String PASSWORD = "baozi199929";
	
	/**
	 * 
	* @Function: LoginDao.java
	* @Description: 连接数据库，登录身份与数据库进行对比
	*
	* @param:传入输入的用户信息
	* @return：0：登录信息错误，1：普通用户登录，2：管理员登录，-1：驱动类加载失败，-2：数据库连接失败；-3：数据库连接关闭失败
	* @throws：SQL异常、驱动类异常
	*
	* @version: v1.0.0
	* @author: baozi
	* @date: 2019年12月3日 上午8:08:28 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2019年12月3日      baozi           v1.0.0               修改原因
	 */
	public static int login(Users user) {
		int flag = 0;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
		Connection connection = null;
		PreparedStatement preStmt = null;
		ResultSet resualt = null;
		try {
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			String sql = "select admin from [user] where name=? and password=?";
			preStmt = connection.prepareStatement(sql);
			preStmt.setNString(1, user.getName());
			preStmt.setNString(2, user.getPassword());
			resualt = preStmt.executeQuery();
			if (resualt.next()) {
				boolean admin = resualt.getBoolean("admin");
				if (!admin) {
					flag = 1;
				} else {
					flag = 2;
				}
			} else {
				flag = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		} finally {
			try {
				resualt.close();
				preStmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return -3;
			}
		}
		return flag;
	}
	
}
