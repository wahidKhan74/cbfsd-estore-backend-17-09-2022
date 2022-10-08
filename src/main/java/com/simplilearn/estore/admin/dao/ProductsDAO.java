package com.simplilearn.estore.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.estore.admin.model.Products;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class ProductsDAO implements DAO<Products>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Products> getAll() {
		List<Products> productsList = new ArrayList<Products>();
		try {
			String sql = "select * from products";
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
				Products product = new Products();
				//set /map result set to object
				product.setProductId(set.getInt("productId"));
				product.setProductTitle(set.getString("productTitle"));
				product.setProductDescription(set.getString("productDescription"));
				product.setPrice(set.getInt("price"));
				product.setProductCode(set.getString("productCode"));
				product.setRating(set.getInt("rating"));
				product.setThumnailImage(set.getInt("tumnailImage"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOnDate = format.parse(set.getString("addedOn"));
				product.setAddedOn(addedOnDate);
				
				productsList.add(product);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong :: " + e);
		}
		return productsList;
	}

	public Products getOne(long id) {
		Products product = new Products();
		try {
			String sql = "select * from products where productId = " + id;
			ResultSet set = db.executeQuery(sql);
			if (set.next()) {
				//set /map result set to object
				//set /map result set to object
				product.setProductId(set.getInt("productId"));
				product.setProductTitle(set.getString("productTitle"));
				product.setProductDescription(set.getString("productDescription"));
				product.setPrice(set.getInt("price"));
				product.setProductCode(set.getString("productCode"));
				product.setRating(set.getInt("rating"));
				product.setThumnailImage(set.getInt("tumnailImage"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date addedOnDate = format.parse(set.getString("addedOn"));
				product.setAddedOn(addedOnDate);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return product;
	}

	public void save(Products obj) {
		try {
			String sql = "insert into PRODUCTS (productTitle, productDescription, price, rating, productCode) values('" + obj.getProductTitle() + "', '"
					+ obj.getProductDescription() + "', " + obj.getPrice() + ", " + obj.getRating()
					+ ", '" + obj.getProductCode() + "')";
			String message = (db.executeUpdate(sql) > 0) ? "Products Saved successfully" : "Unable to save products";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Exception is: " + e);
		}
		
	}

	public void update(Products obj) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addedOnDate = format.format(obj.getAddedOn());
			String sql = "update products set productTitle = '" + obj.getProductTitle() + "', productDescription = '"
					+ obj.getProductDescription() + ", price = '" + obj.getPrice()
					+ "', rating = " + obj.getRating() + " , addedOn = '" + addedOnDate + "' where categoryId = "
					+ obj.getProductId();
			String message = (db.executeUpdate(sql) > 0) ? "Products Updated successfully"
					: "Unable to update products";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from products where productId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Products is deleted" : "Product cannot be deleted";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

}
