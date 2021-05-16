package com.bala.inventory.client;

import com.bala.inventory.exceptions.CustomException;
import com.bala.inventory.services.DataManuplation;
import com.bala.inventory.utility.MyScanner;

//Write a menu driven program for inventory management where Product(id, name, quantity, price_per_unit).
//
//1. Add new product in inventory.
//2. Update the quantity of particular product.
//3. Display products where quantity is less than provided by a user.	 
//4. Display product sort on the basis of quantity.
//5. Delete a particular product from inventory.
//6. Exit
//
//Note: 
//
// - Appication must follow OOPs standard
// - Implement exception handling
// - Follow layer structure and best practices

public class InventoryApp {

	public static void main(String[] args) throws CustomException {
		DataManuplation dataManuplation = new DataManuplation();

		MyScanner scan = new MyScanner();
		int key = 0;
		boolean flag = true;
		do {
			System.out.println("*********press the key for action**********************************");
			System.out.println("*********press 1 for add new product*******************************");
			System.out.println("*********press 2 for update quantity*******************************");
			System.out.println("*********press 3 for display based on user quantity****************");
			System.out.println("*********press 4 for display based on quantity*********************");
			System.out.println("*********press 5 for Delete particular product from inventory******");
			System.out.println("*********press 6 for exit******************************************");
			key = scan.myScan().nextInt();

			switch (key) {
			case 1:

				dataManuplation.addProduct();
				break;
			case 2:
				System.out.println("Enter id and quantity");
				dataManuplation.updateProduct();
				break;
			case 3:
				System.out.println("3 display based on user entered quantity");
				dataManuplation.customDisplayProduct();
				break;
			case 4:
				System.out.println("4 displaying on based quantity");
				dataManuplation.displayProduct();
				break;
			case 5:
				dataManuplation.deleteProduct();
				break;
			case 6:
				flag = false;
				System.out.println("you have exited");
				break;

			default:
				System.out.println("you have entered a worng value");
				break;
			}

		} while (flag);

	}

}
