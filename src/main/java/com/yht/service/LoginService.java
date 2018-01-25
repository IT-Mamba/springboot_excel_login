package com.yht.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yht.util.SignUtil;

@Service
public class LoginService {

	// 数据库连接URL，当前连接的是E:/H2目录下的gacl数据库
	private static final String JDBC_URL = "jdbc:h2:~/pay";
	// 连接数据库时使用的用户名
	private static final String USER = "pay";
	// 连接数据库时使用的密码
	private static final String PASSWORD = "pay123";
	// 连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
	private static final String DRIVER_CLASS = "org.h2.Driver";

	public boolean verifyLogin(String username,String password) {
		boolean verifyStatus = false;
		try {
			String sign = SignUtil.signByMD5(password, "yht123");
			//List<User> userList = loginDao.findByUsernameAndPassword(user.getUsername(), sign);
			List<Object> userH2List = findByNameAndPaswd(username, sign);
			if (userH2List.size() > 0) {
				verifyStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifyStatus;
	}

	private List<Object> findByNameAndPaswd(String username, String password) throws Exception {
		List<Object> userList = new ArrayList<Object>();
		// 加载H2数据库驱动
		Class.forName(DRIVER_CLASS);
		// 根据连接URL，用户名，密码获取数据库连接
		Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
		Statement stmt = conn.createStatement();
		// 查询
		ResultSet rs = stmt.executeQuery("SELECT username FROM tb_user_management where username = '" + username + "' and password = '" + password + "';");
		while (rs.next()) {
			userList.add(rs.getString("username"));
		}
		stmt.close();
		// 关闭连接
		conn.close();
		return userList;
	}

}
