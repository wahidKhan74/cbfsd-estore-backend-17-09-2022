package com.simplilearn.estore.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.estore.admin.model.Users;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class UsersDAO implements DAO<Users>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Users> getAll() {
		List<Users> usersList = new ArrayList<>();
		Users user = new Users();
		try {
			String sql = "select * from users where userId = ";
			ResultSet set = db.executeQuery(sql);
			while (set.next()) {
				user.setUserId(set.getInt("userId"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOnDate = format.parse(set.getString("addedOn"));
				user.setAddedOn(addedOnDate);
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setFullName(set.getString("fullName"));
				user.setStreet(set.getString("street"));
				user.setCity(set.getString("city"));
				user.setState(set.getString("state"));
				user.setCountry(set.getString("country"));
				user.setPincode(set.getInt("pincode"));
				user.setImage(set.getString("image"));
				user.setContact(set.getLong("contact"));
				usersList.add(user);

			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}

		return usersList;
	}

	public Users getOne(long id) {
		Users user = new Users();
		try {
			String sql = "select * from users where userId = " + id;
			ResultSet set = db.executeQuery(sql);
			if (set.next()) {
				user.setUserId(set.getInt("userId"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setFullName(set.getString("fullName"));
				user.setStreet(set.getString("street"));
				user.setCity(set.getString("city"));
				user.setState(set.getString("state"));
				user.setCountry(set.getString("country"));
				user.setPincode(set.getInt("pincode"));
				user.setImage(set.getString("image"));
				user.setContact(set.getLong("contact"));

			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return user;
	}

	public void save(Users obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = String.format(
					"insert into users values(null, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', %d, '%s')",
					obj.getEmail(), obj.getPassword(), obj.getFullName(), obj.getStreet(), obj.getCity(),
					obj.getState(), obj.getCountry(), obj.getPincode(), obj.getImage(), obj.getContact(), addedOnDate);

			String message = (db.executeUpdate(sql) > 0) ? "User saved successfully" : "Unable to save user";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception message is " + e.getMessage());
		}
		
	}

	public void update(Users obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = String.format(
					"update users set email='%s', password='%s', fullName='%s', street='%s', city='%s', state='%s', country='%s', pincode='%s', image='%s', contact='%d', addedonDate='%s' where userId=%d",
					obj.getEmail(), obj.getPassword(), obj.getFullName(), obj.getStreet(), obj.getCity(),
					obj.getState(), obj.getCountry(), obj.getPincode(), obj.getImage(), obj.getContact(), addedOnDate,
					obj.getUserId()

			);

			String message = (db.executeUpdate(sql) > 0) ? "User upadted successfully" : "Unable to update user";
			System.out.println(message);

		} catch (Exception e) {

			System.out.println("Exception message is " + e.getMessage());
		}
		
	}

	public void delete(long id) {
		try {

			String sql = "delete from users where userId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "User deleted successfully" : "Unable to delete user";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

}
