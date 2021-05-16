package com.bala.inventory.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bala.inventory.dao.DaoOperationsImpl;
import com.bala.inventory.exceptions.CustomException;
import com.bala.inventory.model.Product;
import com.bala.inventory.utility.MyScanner;

public class DataManuplation implements DataManuplationItr {
	static MyScanner scan = new MyScanner();
	
	public void addProduct() throws CustomException {
		System.out.println("Enter Name,Quantity,Price");

		String name = scan.myScan().next();
		int quantity = scan.myScan().nextInt();
		int price = scan.myScan().nextInt();
		DaoOperationsImpl doi = new DaoOperationsImpl();
		int count = doi.addProduct(name, quantity, price);
		if (count > 0) {
			System.out.println("insertion sucessful");
		} else {
			System.out.println("insertion failed");
		}

	}

	public void updateProduct() throws CustomException {
		

		int id = scan.myScan().nextInt();
		int quantity = scan.myScan().nextInt();

		DaoOperationsImpl doi = new DaoOperationsImpl();
		int count = doi.updateProduct(quantity, id);
		if (count > 0) {
			System.out.println("updation sucessful");
		} else {
			System.out.println("updation failed");
		}

	}

	/**
	 * @throws CustomException
	 */
	public void displayProduct() throws CustomException {

		DaoOperationsImpl doi = new DaoOperationsImpl();
		List<Product> products = doi.displayProducts();
		List<Product> productsSorting = sort(products);
		disp(productsSorting);

	}

	private void disp(List<Product> productsSorting) {
		for (Product p : productsSorting) {
			System.out.println(p);
		}

	}

	private List<Product> sort(List<Product> products) {
		Collections.sort(products, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
			

				return o1.getQuantity() - o2.getQuantity();
			}

		});

		return products;

	}

	public void customDisplayProduct() throws CustomException {
		System.out.println("Enter quantity");

		int quantity = scan.myScan().nextInt();

		DaoOperationsImpl doi = new DaoOperationsImpl();
		List<Product> products = doi.displayProducts();
		List<Product> productsSorting = sort(products);
		customDisp(productsSorting, quantity);

	}

	private void customDisp(List<Product> productsSorting, int quantity) {

		for (Product p : productsSorting) {
			if (p.getQuantity() > quantity) {
				System.out.println(p);
			}

		}

	}
	public void deleteProduct() throws CustomException {
		System.out.println("Enter id to delete product");

		int id = scan.myScan().nextInt();
		DaoOperationsImpl doi = new DaoOperationsImpl();
		int count = doi.deleteProduct(id);
		if (count > 0) {
			System.out.println("deletion sucessful");
		} else {
			System.out.println("deletion  failed");
		}


	}
}
