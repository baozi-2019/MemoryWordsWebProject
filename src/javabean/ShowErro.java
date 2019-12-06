package javabean;

/**
 * 
* 
* Copyright: Copyright (c) 2019 Baozi
* @ClassName: ShowErro.java
* @Description: 展示错误信息
*
* @version: v1.0.0
* @author: baozi
* @date: 2019年12月3日 上午9:13:07 
*
* Modification History:
* Date         		Author          Version          Description
*---------------------------------------------------------*
* 2019年12月3日       	baozi           v1.0.0                                无
 */
public class ShowErro {
	private int erroCode;
	private String erroMessage;
	public void setErroCode(int erroCode) {
		this.erroCode = erroCode;
		switch(erroCode) {
		case -1 : erroMessage = "驱动类导入失败，请联系管理员解决。"; break;
		case -2 : erroMessage = "数据库连接失败或sql语句错误，请联系系统 管理员解决。"; break;
		case -3 : erroMessage = "SQL Server连接关闭失败，请联系系统 管理员解决。"; break;
		case 0 : erroMessage = "请重新登录！！"; break;
		default : erroMessage = "未知代码！！";
		}
	}

	public String getErroMessage() {
		return erroMessage;
	}
	
}
