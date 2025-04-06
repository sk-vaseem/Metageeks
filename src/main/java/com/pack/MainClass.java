package com.pack;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			CustomerDAO customerDao = new CustomerDAO();
			do {
				System.out.println();
				System.out.println("1. Insert");
				System.out.println("2. Display on Id");
				System.out.println("3. Delete");
				System.out.println("4. Display All");
				System.out.println("5. Update");
				System.out.println();
				System.out.println("Enter your choice:");

				while (!scan.hasNextInt()) {
					System.out.println("Invalid choice. Please enter a number:");
					scan.next();
				}

				int ch = scan.nextInt();
				scan.nextLine(); // Consume the newline left-over

				switch (ch) {
				case 1: {
					int k = customerDao.insertWithDetails(scan);
					if (k != 0)
						System.out.println("Successfully inserted");
					else
						System.out.println("Failed");
					break;
				}

				case 2: {
					System.out.println("Enter customer ID:");

					while (!scan.hasNextInt()) {
						System.out.println("Invalid ID. Please enter a number:");
						scan.next();
					}

					int id = scan.nextInt();
					scan.nextLine(); // Consume the newline left-over
					Customer customer = customerDao.display(id);
					if (customer != null) {
						System.out.println(customer.getCustName());
					} else {
						System.out.println("Customer not found with ID: " + id);
					}
					break;
				}

				case 3: {
					System.out.println("Enter customer ID:");

					while (!scan.hasNextInt()) {
						System.out.println("Invalid ID. Please enter a number:");
						scan.next();
					}

					int id = scan.nextInt();
					scan.nextLine(); // Consume the newline left-over
					int del = customerDao.deleteCustomer(id);
					if (del > 0)
						System.out.println("Deleted successfully");
					else
						System.out.println("Customer not found with ID: " + id);
					break;
				}

				case 4: {
					customerDao.displayAll();
					break;
				}

				case 5: {
					System.out.println("Enter customer ID and the new name:");

					while (!scan.hasNextInt()) {
						System.out.println("Invalid ID. Please enter a number:");
						scan.next();
					}

					int id = scan.nextInt();
					scan.nextLine(); // Consume the newline left-over
					String name = scan.nextLine();
					int upd = customerDao.updateCustomer(id, name);
					if (upd > 0)
						System.out.println("Updated successfully");
					else
						System.out.println("Customer not found with ID: " + id);
					break;
				}

				default: {
					System.out.println("Invalid choice. Please try again.");
					break;
				}
				}
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
