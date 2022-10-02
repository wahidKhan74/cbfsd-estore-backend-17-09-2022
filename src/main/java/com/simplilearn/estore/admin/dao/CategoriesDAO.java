package com.simplilearn.estore.admin.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.estore.admin.model.Categories;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class CategoriesDAO implements DAO<Categories>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Categories> getAll() {
		List<Categories> categoriesList = new ArrayList<Categories>();
		try {
			String sql = "select * from categories";
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
				Categories category = new Categories();
				//set /map result set to object
				category.setCategoryId(set.getInt("categoryId"));
				category.setCategoryName(set.getString("categoryName"));
				category.setCategoryDescription(set.getString("categoryDescription"));
				category.setCategoryImageUrl(set.getString(0));
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				Date addedOnDate = format.parse(set.getString("addedOn"));
				category.setAddedOn(addedOnDate);
				//add category into categoriesList
				categoriesList.add(category);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e);
		}
		return categoriesList;
	}

	public Categories getOne(long id) {
		Categories category = new Categories();
		try {
			String sql = "select * from categories where categoryId = " + id;
			ResultSet set = db.executeQuery(sql);
			if (set.next()) {
				//set /map result set to object
				category.setCategoryId(set.getInt("categoryId"));
				category.setCategoryName(set.getString("categoryName"));
				category.setCategoryDescription(set.getString("categoryDescription"));
				category.setCategoryImageUrl(set.getString(0));
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				Date addedOnDate = format.parse(set.getString("addedOn"));
				category.setAddedOn(addedOnDate);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return category;
	}

	public void save(Categories obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = "insert into categories values(null, '" + obj.getCategoryName() + "', '"
					+ obj.getCategoryDescription() + ", '" + obj.getCategoryImageUrl() + "', " + obj.getActive()
					+ " , '" + addedOnDate + "')";
			String message = (db.executeUpdate(sql) > 0) ? "Category Saved successfully" : "Unable to save category";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
	}

	public void update(Categories obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = "update categories set categoryName = '" + obj.getCategoryName() + "', categoryDescription = '"
					+ obj.getCategoryDescription() + ", categoryImageUrl = '" + obj.getCategoryImageUrl()
					+ "', active = " + obj.getActive() + " , addedOn = '" + addedOnDate + "' where categoryId = "
					+ obj.getCategoryId();
			String message = (db.executeUpdate(sql) > 0) ? "category Updated successfully"
					: "Unable to update category";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from categories where categoryId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Category id deleted" : "Category cannot be deleted";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
	}

}
