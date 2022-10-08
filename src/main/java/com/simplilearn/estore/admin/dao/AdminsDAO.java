package com.simplilearn.estore.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.estore.admin.model.Admins;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class AdminsDAO implements DAO<Admins>{
	
	DBUtility db = DBUtility.getDBUtility();

	// validate admin login
	public void login(Admins admin) {
		try {
			String sql = "select * from ADMINS where email='"+admin.getEmail() +"' and password ='" +admin.getPassword()+ "'";
			ResultSet res = db.executeQuery(sql);
			// object mapping
			if(res.next()) {
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("Email"));
				admin.setPassword(res.getString("password"));
				admin.setLoginType(res.getInt("loginType"));
				String date = res.getString("addedOn");
				SimpleDateFormat format = new SimpleDateFormat("YYYY:MMM:DD");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}
	}
	
	
	public List<Admins> getAll() {
		List<Admins> adminList  = new ArrayList<Admins>();
		try {
			String sql = "select * from ADMINS";
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				Admins admin = new Admins();
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("Email"));
				admin.setPassword(res.getString("password"));
				String date = res.getString("addedOn");
				admin.setLoginType(res.getInt("loginType"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
				adminList.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong :: " + e.getMessage());
		}
		return adminList;
	}

	public Admins getOne(long id) {
		Admins admin = new Admins();
		try {
			String sql = "select * from ADMINS where adminId="+id;
			ResultSet res = db.executeQuery(sql);
			// object mapping
			if(res.next()) {
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("Email"));
				admin.setPassword(res.getString("password"));
				String date = res.getString("addedOn");
				admin.setLoginType(res.getInt("loginType"));
				SimpleDateFormat format = new SimpleDateFormat("YYYY:MMM:DD");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}
		return admin;
	}

	public void save(Admins obj) {
		try {
			String sql = "insert into ADMINS (email,password, fullName, loginType) values ('"+obj.getEmail()+"', '"+obj.getPassword()+"','"+obj.getFullName()
			+"', "+obj.getLoginType()+")";
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record saved successfully" : "Unable to save Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}		
	}

	public void update(Admins obj) {
		try {
			String sql = "update ADMINS set email = '"+obj.getEmail()+"', password ='"+obj.getPassword()+"', fullName = '"+obj.getFullName()
			+"', loginType = "+obj.getLoginType()+" where adminId = "+obj.getAdminId();    
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record updated successfully" : "Unable to update Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from ADMINS where adminId = " + id;
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record deleted successfully" : "Unable to delete Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e.getMessage());
		}	
		
	}

}
