package com.simplilearn.estore.admin.dao;

import java.util.List;

import com.simplilearn.estore.admin.model.Users;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class UsersDAO implements DAO<Users>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Users getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Users obj) {
		// TODO Auto-generated method stub
		
	}

	public void update(Users obj) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
