package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.BankManager;

public class BankManagerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aryan");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//==============================================================================================

	// Save Bank Manager

	public BankManager saveBankManager(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		return bankManager;
	}

//=============================================================================================

	// Delete

	public boolean deleteBankManagerById(int b_id) {
		BankManager bankManager = entityManager.find(BankManager.class, b_id);
		entityTransaction.begin();
		entityManager.remove(bankManager);
		entityTransaction.commit();
		return true;

	}

//==============================================================================================

	// Update BankManager Email By Id

	public BankManager updateBankManagerByIdEmail(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		return bankManager;
	}

//=============================================================================================

	// Update BankManager Password By Id

	public BankManager updateBankManagerByIdUsernamePassword(BankManager bankManager) {
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		return bankManager;
	}

//=============================================================================================

	// Get All BankManagers

	public List<BankManager> getAllBankManager() {
		String sql = "SELECT e from BankManager e";
		Query query = entityManager.createQuery(sql);
		List<BankManager> bankManagers = query.getResultList();
		return bankManagers;
	}

//============================================================================================

	// Get BankManager By Id

	public BankManager getBankManagerById(int b_id) {
		return entityManager.find(BankManager.class, b_id);
	}

//=============================================================================================

	// Approve Manager

	public boolean approval(int a_id, int m_id) {
		BankManager bankManager = entityManager.find(BankManager.class, m_id);
		entityTransaction.begin();
		entityManager.merge(bankManager);
		entityTransaction.commit();
		return true;
	}

//=============================================================================================

}
