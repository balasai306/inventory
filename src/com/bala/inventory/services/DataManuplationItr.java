package com.bala.inventory.services;

import com.bala.inventory.exceptions.CustomException;

public interface DataManuplationItr  {
	public void addProduct() throws CustomException ;
	public void updateProduct() throws CustomException ;
	public void displayProduct()throws CustomException ;
	public void customDisplayProduct()throws CustomException ;
	public void deleteProduct()throws CustomException ;
}
