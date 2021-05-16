package com.bala.inventory.dao;

import java.util.List;

import com.bala.inventory.exceptions.CustomException;
import com.bala.inventory.model.Product;

public interface DaoOperations {
	int addProduct(String name, int quantity, int price) throws CustomException;

	int updateProduct(int quantity, int id) throws CustomException;


	public List<Product> displayProducts() throws CustomException;

	public int deleteProduct(int id) throws CustomException;

}
