package com.itheima.service;

import java.sql.SQLException;

import com.itheima.bean.User;
import com.itheima.dao.LoginDao;

public class LoginService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		//创建LoginDao
		LoginDao ld = new LoginDao();
		
		return ld.getUserByUsernameAndPwd(username,password);
	}

}
