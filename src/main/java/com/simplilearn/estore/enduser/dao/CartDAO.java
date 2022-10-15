package com.simplilearn.estore.enduser.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.enduser.model.Cart;
import com.simplilearn.estore.utility.DBUtility;

public class CartDAO implements DAO<Cart>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Cart> getAll() {
		List<Cart> cartList = new ArrayList<Cart>();
		try {
			String sql = "select * from CART";
			ResultSet set = db.executeQuery(sql);
			while(set.next()) { 
				Cart cart = new Cart();
				cart.setCartId(set.getInt("cartId"));
				cart.setProductId(set.getInt("productId"));
				cart.setUserId(set.getInt("userId"));
				cart.setQuantity(set.getInt("quantity"));
				cartList.add(cart);
			}
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
		return cartList;
	}

	public Cart getOne(long id) {
		Cart cart = new Cart();
		try {
			String sql = "select * from CART where cartId="+id;
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
				cart.setCartId(set.getInt("cartId"));
				cart.setProductId(set.getInt("productId"));
				cart.setUserId(set.getInt("userId"));
				cart.setQuantity(set.getInt("quantity"));
			}
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
		return cart;
	}

	public Cart getOneByUserId(long userId) {
		Cart cart = new Cart();
		try {
			String sql = "select * from CART where userId="+userId;
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
				cart.setCartId(set.getInt("cartId"));
				cart.setProductId(set.getInt("productId"));
				cart.setUserId(set.getInt("userId"));
				
			}
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
		return cart;
	}
	
	public void save(Cart obj) {
		try {
			String sql = String.format("insert into CART(productId, userId,quantity) values ('%d' , '%d', '%d')", 
					obj.getProductId(), obj.getUserId(), obj.getQuantity());
			String message = ( db.executeUpdate(sql) > 0 ) ? "Cart Items was created successfully." : "Unable to save items to cart.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
		
	}

	public void update(Cart obj) {
		try {
			String sql = String.format("update CART set productId='%d', userId='%d' , quantity='%d' where cartId='%d'",
					obj.getProductId(), obj.getUserId(),obj.getQuantity(),  obj.getCartId());
			String message = ( db.executeUpdate(sql) > 0 ) ? "Cart Items was updated successfully." : "Unable to update items to cart.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from CART where cartId="+id;
			String message = ( db.executeUpdate(sql) > 0 ) ? "Cart Items was deleted successfully." : "Unable to delete items to cart.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
	}
	
	
	public void deleteCartByUserId(long userId) {
		try {
			String sql = "delete from CART where userId="+userId;
			String message = ( db.executeUpdate(sql) > 0 ) ? "Cart Items was deleted successfully." : "Unable to delete items to cart.";
			System.out.println(message);
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong :: " + e);
		}
	}

}
