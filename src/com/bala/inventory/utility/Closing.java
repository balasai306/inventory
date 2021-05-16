package com.bala.inventory.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Closing {

	public  void closeConnection(ResultSet resultSet) {
		// TODO Auto-generated method stub
		if (resultSet != null) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	
	public void closeConnection(Connection con) {
		// TODO Auto-generated method stub
		if (con != null) {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public  void closeConnection(Statement statement) {
		// TODO Auto-generated method stub
		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
