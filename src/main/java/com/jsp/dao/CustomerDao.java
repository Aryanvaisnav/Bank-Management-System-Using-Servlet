package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Customer;

public class CustomerDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aryan");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//===============================================================================================
	
	// Save Customer
	
	public Customer saveCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}
	
//==============================================================================================

	// Delete Customer By Id

	public boolean deleteCustomerById(int c_id) {
		Customer customer = entityManager.find(Customer.class, c_id);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//==============================================================================================

	// Update Customer Email

	public boolean updateCustomerByIdEmail(int c_id, String c_email) {
		Customer customer = entityManager.find(Customer.class, c_email);
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return true;
	}
	
//==============================================================================================
	
	// Deposit Money
	
	public Customer depositMoneyById(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return customer;
	}
	
//============================================================================================
	
	// Money Withdrawal
	
	public Customer withdrawMoneyById(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return customer;
	}
	
//=============================================================================================
	
	// Money Transfer
	
	public boolean transferMoneyById(Customer customer1,Customer customer2) {
		entityTransaction.begin();
		entityManager.merge(customer1);
		entityManager.merge(customer2);
		entityTransaction.commit();
		return true;
	}
	
//============================================================================================
	
	// Get All Customers
	
	public List<Customer> getAllCustomer(){
		String sql ="SELECT e from Customer e";
		Query query=entityManager.createQuery(sql);
		List<Customer> customers=query.getResultList();
		return customers;
	}
	
//============================================================================================

	// Get Customer By Id
	
	public Customer getCustomerById(int c_id) {
		Customer customer= entityManager.find(Customer.class, c_id);
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
		
	}
	
//===========================================================================================
	
	// Update Customer Details
	
	public boolean updateCustomerNameMono(String c_name, long c_mono) {
		Customer customer = entityManager.find(Customer.class, c_name);
		entityTransaction.begin();
		entityManager.merge(c_name);
		entityManager.merge(c_mono);
		entityTransaction.commit();
		return true;
		
	}
	
//============================================================================================
	
	// Approve Customer
	
	public boolean approveCustomer(int c_id, int m_id) {
		Customer customer = entityManager.find(Customer.class, c_id);
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return true;
	}
	
//===========================================================================================

}