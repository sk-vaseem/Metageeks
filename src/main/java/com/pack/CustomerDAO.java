package com.pack;

import java.util.Iterator;
import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.HibernateUtil;
import com.pack.Customer;

public class CustomerDAO {
	
	public int insert(Customer customer)
	{
		 
			 
	 
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 		
 
		Transaction tx=null;
		tx=session.beginTransaction();
		
		int res=(int)session.save(customer); 
		tx.commit();
		System.out.println("Saved");
		
		session.close(); 
	 
		return res;
	}

	
	public Customer display(int customerId)
	{
		  
		 return customer;
		
	     	    
		
	}
	
	
	public int deleteCustomer(int customerId)
	{
		
		  
   	  return id;
   	  
   	  
	}
	
	public List<Customer> displayAll()
	{
		 
		 return customers;
		 
		  	
		
		
		
	}
	

	public int updateCustomer(int customerId,String custName)
	{
		
		 
   	  return i;
   	  
   	  
	}
	
	}
	
	 

