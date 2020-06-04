package com.lxj.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MybatisTest {

	public static void main(String[] args) {
		ResultSet rs = null;
		PreparedStatement stat = null;
		Connection conn = null;
		try {
//			1注册驱动
			Class.forName("com.mysql.jdbc.Driver");
//			2获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "1111");
//			3获取预处理对象
			stat = conn.prepareStatement("select * from user where id=?");
			stat.setInt(1, 10);
//			4执行sql
			rs = stat.executeQuery();
//			5封装结果集
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			6释放资源
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
