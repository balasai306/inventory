package com.bala.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bala.inventory.exceptions.CustomException;
import com.bala.inventory.model.Product;
import com.bala.inventory.utility.Closing;
import com.bala.inventory.utility.Connector;

public class DaoOperationsImpl implements DaoOperations {
	Connector connection = new Connector();
	Closing close = new Closing();

	@Override
	public int addProduct(String name, int quantity, int price) throws CustomException {
		// TODO Auto-generated method stub

		PreparedStatement psmt = null;
		Connection con = null;
		String sql = "insert into products (pname,quantity,price) values(?,?,?)";
		int count = 0;

		try {
			con = connection.getConnection();

			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, quantity);
			psmt.setInt(3, price);
			count = psmt.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("SQL exception occured in addProduct ");
		} catch (CustomException e) {
			throw new CustomException("exception occured in addProduct");
		} finally {
			close.closeConnection(psmt);
			close.closeConnection(con);

		}
		return count;
	}

	@Override
	public int updateProduct(int quantity, int id) throws CustomException {
		String sql = "update products set quantity=? where id=?";
		int count = 0;
		Connector connection = new Connector();
		Connection con = null;
		PreparedStatement psmt = null;

		try {
			con = connection.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, quantity);
			psmt.setInt(2, id);
			count = psmt.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("SQL exception occured during updation");
		} catch (CustomException e) {
			throw new CustomException("exception occured in updation Product");
		} finally {
			close.closeConnection(psmt);
			close.closeConnection(con);

		}

		return count;

	}

	@Override
	public List<Product> displayProducts() throws CustomException {
		String sql = "select * from products";
		Connector connection = new Connector();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			con = connection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				int id = rs.getInt(1);
				product.setId(id);
				String name = rs.getString(2);
				product.setName(name);
				int quantity = rs.getInt(3);
				product.setQuantity(quantity);
				int price = rs.getInt(4);
				product.setPrice(price);
				products.add(product);
			}

		} catch (SQLException e) {
			throw new CustomException("SQL exception occured during fetching to display");
		} catch (CustomException e) {
			throw new CustomException("exception occured in Product fetching");
		} finally {
			close.closeConnection(rs);
			close.closeConnection(stmt);
			close.closeConnection(con);

		}

		return products;

	}

	@Override
	public int deleteProduct(int id) throws CustomException {
		Connector connection= new Connector();
		String sql="delete from products where id=?";
		Connection con=null;
		PreparedStatement psmt= null;
		int count=0;
		try {
			con =connection.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
		 count	=psmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomException("SQL exception occured during deletion of data");
		} catch (CustomException e) {
			throw new CustomException("exception occured in Product fetching");
		} finally {
			
			close.closeConnection(psmt);
			close.closeConnection(con);

		}
		return count;
		

	}

}
