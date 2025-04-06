package com.pack;

import java.util.Scanner;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomerDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public int insert(Customer customer) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			int res = (int) session.save(customer);
			tx.commit();
			System.out.println("Saved");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Customer display(int customerId) {
		try (Session session = sessionFactory.openSession()) {
			Customer customer = session.get(Customer.class, customerId);
			if (customer != null) {
				System.out.println(customer);
			} else {
				System.out.println("Customer not found with ID: " + customerId);
			}
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteCustomer(int customerId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, customerId);
			if (customer != null) {
				session.delete(customer);
				tx.commit();
				System.out.println("Deleted customer with ID: " + customerId);
				return 1;
			} else {
				System.out.println("Customer not found with ID: " + customerId);
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void displayAll() {
		try (Session session = sessionFactory.openSession()) {
			Query<Customer> query = session.createQuery("from Customer", Customer.class);
			List<Customer> customers = query.getResultList();
			int count = 0;
			for (Customer customer : customers) {
				count++;
				System.out.println(customer);
			}
			System.out.println("Total customers: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updateCustomer(int customerId, String custName) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Customer customer = session.get(Customer.class, customerId);
			if (customer != null) {
				customer.setCustName(custName);
				session.update(customer);
				tx.commit();
				System.out.println("Updated customer with ID: " + customerId);
				return 1;
			} else {
				System.out.println("Customer not found with ID: " + customerId);
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int insertWithDetails(Scanner scanner) {
		try {
			Customer customer = new Customer();
			System.out.println("Enter customer name:");
			customer.setCustName(scanner.nextLine());
			System.out.println("Enter customer address:");
			customer.setAddress(scanner.nextLine());
			System.out.println("Enter customer phone:");
			customer.setPhone(scanner.nextLine());

			return insert(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
