package com.lxj_03;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import com.jdbcUtils.JDBCUtilsConfig;

/*
 * 使用dbutils工具包 中的queryRunner类来实现对数据的insert delete update
 * 调用QueryRunner类中update(connection conn,String sql,Object...params)方法
 */
public class QueryRunnerDemo {
	private static Connection con = JDBCUtilsConfig.getConnection();

	public static void main(String[] args) throws SQLException {
		// insert();
		// update();
		delete();
	}

//	delete方法
	public static void delete() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "delete from sort where sid =?";
		qr.update(con, sql, 6);

	}

//update方法
	public static void update() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update sort set sname=?,sprice=?,sdesc=? where sid=?";
		Object[] params = { "水果", 10.3, "营养健康", 4 };
		int row = qr.update(con, sql, params);
		System.out.println(row);
	}

//insert方法
	public static void insert() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into sort (sname,sprice,sdesc) values (?,?,?)";
		Object[] params = { "山地车", 1000, "低碳环保" };
		int row = qr.update(con, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}

}
