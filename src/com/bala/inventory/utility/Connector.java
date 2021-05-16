package com.bala.inventory.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bala.inventory.exceptions.CustomException;

public class Connector {
	public Connection getConnection() throws CustomException {
//		String url="jdbc:mysql://localhost:3306/inventory";
//		String user="root";
//		String password="1234";
		Connection connect = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException("Exception found in connector" + e.getMessage());
		}

		return connect;

	}

}
