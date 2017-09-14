package com.bingcao;

import java.sql.*;

public class GetSqlData {

	public String getdata(String name) {
		String pwd = "null";
		Connection conn = ConnectSql.SQLConn();
		try {
			if (!conn.isClosed()) {
				System.out.println("数据库连接成功");
				Statement state = conn.createStatement();
				String sql = "select * from userinfo where name=" + "'" + name
						+ "'";
				ResultSet rs = state.executeQuery(sql);

				if (rs.next()) {
					pwd = rs.getString("password");
				} else {
					System.out.println("找不到用户名");

				}
				rs.close();
			} else {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwd;
	}
}