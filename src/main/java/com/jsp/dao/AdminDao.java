package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aryan");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//==============================================================================================

	// Save Admin

	public Admin saveAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

//=============================================================================================

	// Delete Admin By Id

	public boolean deleteAdminById(int a_id) {
		Admin admin = entityManager.find(Admin.class, a_id);
		if (admin != null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//==============================================================================================

	// Update Admin Email

	public Admin updateAdminByIdEmail(Admin admin) {
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

//============================================================================================

	// Get All Admin

	public List<Admin> getAllAdmin() {
		String sql = "SELECT e from Admin e";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		return admins;
	}

//=============================================================================================

	// Get Admin By Id

	public Admin getAdminById(int a_id) {
		Admin admin = entityManager.find(Admin.class, a_id);
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

//============================================================================================

}