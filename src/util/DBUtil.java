package util;

import exeption.DBConnException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String MYSQL_CONNECTION = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://192.168.9.122:3306/memory_words?useSSL=true&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static final String MYSQL_NAME = "root";
    private static final String MYSQL_PASSWORD = "root";

//    private static final String MSSQL_CONNECTION = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String MSSQL_URL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MemoryWords";
//    private static final String MSSQL_NAME = "sa";
//    private static final String MSSQL_PASSWORD = "baozi199929";

    public static Connection getMysqlConn() throws DBConnException {
        try {
            Class.forName(MYSQL_CONNECTION).newInstance();

            return DriverManager.getConnection(MYSQL_URL, MYSQL_NAME, MYSQL_PASSWORD);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("mysql驱动未加载成功", e);
        } catch (SQLException e) {
            throw new DBConnException("获取mysql连接失败，请重试", e);
        }
    }
}
