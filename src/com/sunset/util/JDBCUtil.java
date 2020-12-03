package com.sunset.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JDBCUtil {
	//实例化数据库连接池  DBCPde 数据库连接池
	private static DataSource dataSource;

	//读取文件
	static { //apache  tomcat  mybatis 
		Properties properties = new Properties(); // map集合
		//获得src 根目录下面的文件,读取成流
		InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(inputStream);//将文件读取成map集合
			//根据map集合的配置实例化数据库连接池
			dataSource = new BasicDataSourceFactory().createDataSource(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//获得数据库连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	// 1.加载驱动,获得连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection(); //数据库连接池里获取的
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//关闭
	public static void close(Connection connection, Statement statement, ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close(); //连接是池子里的连接,归还到池子
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}