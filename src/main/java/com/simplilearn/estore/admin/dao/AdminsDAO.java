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
			String sql = "select * from admins where email='"+admin.getEmail() +"' and password ='" +admin.getPassword()+ "'";
			ResultSet res = db.executeQuery(sql);
			// object mapping
			if(res.next()) {
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("Email"));
				admin.setPassword(res.getString("password"));
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
		Admins admin = new Admins();
		try {
			String sql = "select * from admins";
			ResultSet res = db.executeQuery(sql);
			while(res.next()) {
				admin.setAdminId(res.getInt("adminId"));
				admin.setFullName(res.getString("fullName"));
				admin.setEmail(res.getString("Email"));
				admin.setPassword(res.getString("password"));
				String date = res.getString("addedOn");
				admin.setLoginType(res.getInt("loginType"));
				SimpleDateFormat format = new SimpleDateFormat("YYYY:MMM:DD");
				Date addedOn = format.parse(date);
				admin.setAddedOn(addedOn);
				adminList.add(admin);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}
		return adminList;
	}

	public Admins getOne(long id) {
		Admins admin = new Admins();
		try {
			String sql = "select * from admins where adminId="+id;
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
			SimpleDateFormat format = new SimpleDateFormat("YYYY:MMM:DD");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = "insert into admins values (null, '"+obj.getEmail()+"', '"+obj.getPassword()+"','"+obj.getFullName()
			+"', "+obj.getLoginType()+", '"+addedOnDate+"')";
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record saved successfully" : "Unable to save Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}		
	}

	public void update(Admins obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("YYYY:MMM:DD");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = "update admins set email = '"+obj.getEmail()+"', password ='"+obj.getPassword()+"', fullName = '"+obj.getFullName()
			+"'. loginType = "+obj.getLoginType()+", addedOn = '"+addedOnDate+"' where adminId = "+obj.getAdminId();    
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record updated successfully" : "Unable to update Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}	
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from admins where adminId = " + id;
			int rowaffected = db.executeUpdate(sql);
			String message = (rowaffected >0 ) ? "Admin record deleted successfully" : "Unable to delete Admin data.";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e.getMessage());
		}	
		
	}

}
