package com.pack;

import java.util.Random;

public class Customer {
	
	
	private int customerId;
	public int getCustomerId() {
		return customerId; 
	}
	public void setCustomerId(int customerId) {
		
		this.customerId = customerId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String custName;
	private String address;
	private String phone;
public String toString()
{
	
	return customerId+" "+custName+" "+address+" "+phone;
}
}
