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
//			1ע������
			Class.forName("com.mysql.jdbc.Driver");
//			2��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "1111");
//			3��ȡԤ�������
			stat = conn.prepareStatement("select * from user where id=?");
			stat.setInt(1, 10);
//			4ִ��sql
			rs = stat.executeQuery();
//			5��װ�����
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			6�ͷ���Դ
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
