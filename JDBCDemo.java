package com.lxj_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcUtils.JDBCUtils;
import com.lxj.domain.Sort;

/*
 * jdbc 读取书库sort 表   ，每行书据封装到sort类的对象中
 * 多个sort对象 存储到集合中
 */
public class JDBCDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from sort";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
//		System.out.println(rs);
		List<Sort> list = new ArrayList<Sort>();
		while (rs.next()) {
			Sort s = new Sort(rs.getInt("sid"), rs.getString("sname"), rs.getDouble("sprice"), rs.getString("sdesc"));
			list.add(s);
		}
//		for (int i = 0; i < list.size(); i++) {
//			Sort s = list.get(i);
//			System.out.println(s);
//		}
		for (Sort s : list) {
			System.out.println(s);
		}

	}
}
