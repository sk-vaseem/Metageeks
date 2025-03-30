package com.pack;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		 
		Scanner scan=new Scanner(System.in);
		String flag="Y";
		 do
		 {
			 Customer customer=new Customer();
			 CustomerDAO customerDao=new CustomerDAO();
		System.out.println("1.Insert");
		System.out.println("2.Display on Id");
		System.out.println("3.Delete");
		System.out.println("4.Display All");
		System.out.println("5.Update");
		System.out.println("Enter ur choice");
		int ch=scan.nextInt();
		
		switch(ch)
		{
		case 1:
		{
			
			customer.setCustName("abc");
			customer.setAddress("a add");
			customer.setPhone("425536446");
			int k=customerDao.insert(customer);
			if (k!=0)
				System.out.println("successfully inserted");
			else
				System.out.println("failed");
			break;
		}
		
		case 2:
		{
			System.out.println("Enter cust id");
			int id=scan.nextInt();
			
			customer=customerDao.display(id);
			System.out.println(customer.getCustName());
			break;
		}
		
		case 3:
		{
			System.out.println("Enter cust id");
			int id=scan.nextInt();
			int del=customerDao.deleteCustomer(id);
			  if (del>0)
				  System.out.println("deleted");
			  break;
		}
		case 4:
		{
			  System.out.println("into case");
			  List<Customer> customers=customerDao.displayAll();
			  for (Customer u:customers)
			  {
				  System.out.println(u.getCustName());
				  System.out.println(u.getPhone());  
				   
			  }	
			break;
		}
		case 5:
			
		{
			System.out.println("Enter cust id and the new data");
			int id=scan.nextInt();
			String nam=scan.next();
			  int upd=customerDao.updateCustomer(id, nam);
			  if (upd>0)
				  System.out.println("updated");
			
			
		}
		}
		
		
		System.out.println("Do u want to continue");
	      flag=scan.next();
		 }while (flag.equals("Y"));
		}
		
	
	
	
	
	/*Customer customer=new Customer();
		CustomerDAO customerDao=new CustomerDAO();
	
		Customer obj=new Customer();
		customer.setCustName("abc");
		customer.setAddress("a add");
		customer.setPhone("425536446");
		int k=customerDao.insert(customer);
		if (k!=0)
			System.out.println("successfully inserted");
		else
			System.out.println("failed");
		
		customer=customerDao.display(107);
		System.out.println(customer.getCustName());
		
		int del=customerDao.deleteCustomer(106);
		  if (del>0)
			  System.out.println("deleted");
		
		  List<Customer> customers=customerDao.displayAll();
		  for (Customer u:customers)
		  {
			  System.out.println(u.getCustName());
			  System.out.println(u.getPhone());  
			   
		  }
		  
		  int upd=customerDao.updateCustomer(108, "Priya");
		  if (upd>0)
			  System.out.println("updated");
		  
	}*/

}
