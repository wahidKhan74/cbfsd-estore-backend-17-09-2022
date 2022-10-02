package com.simplilearn.estore.admin.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.estore.admin.model.OrderItems;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class OrderItemsDAO implements DAO<OrderItems>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<OrderItems> getAll() {
		List<OrderItems> ordersList = new ArrayList<OrderItems>();
		try {
			String sql = "select * from orderItems";
			ResultSet set = db.executeQuery(sql);
			while (set.next()) {
				OrderItems orderItem = new OrderItems();
				orderItem.setOrderItemId(set.getInt("orderItemId"));
				orderItem.setOrderId(set.getInt("orderId"));
				orderItem.setProductId(set.getInt("productId"));
				orderItem.setProductCode(set.getString("productCode"));
				orderItem.setProductImg(set.getString("productImg"));
				orderItem.setProductTitle(set.getString("productTitle"));
				orderItem.setProductDescription(set.getString("productDescription"));
				orderItem.setProductCategory(set.getString("productCategory"));
				orderItem.setPrice(set.getInt("price"));
				orderItem.setQuantity(set.getInt("quantity"));
				orderItem.setTotalPrice(set.getInt("totalPrice"));

				ordersList.add(orderItem);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return ordersList;
	}

	public OrderItems getOne(long id) {
		OrderItems orderItem = new OrderItems();

		try {
			String sql = "select * from orderItems where orderItemId = " + id;
			ResultSet set = db.executeQuery(sql);
			if (set.next()) {
				orderItem.setOrderItemId(set.getInt("orderItemId"));
				orderItem.setOrderId(set.getInt("orderId"));
				orderItem.setProductId(set.getInt("productId"));
				orderItem.setProductCode(set.getString("productCode"));
				orderItem.setProductImg(set.getString("productImg"));
				orderItem.setProductTitle(set.getString("productTitle"));
				orderItem.setProductDescription(set.getString("productDescription"));
				orderItem.setProductCategory(set.getString("productCategory"));
				orderItem.setPrice(set.getInt("price"));
				orderItem.setQuantity(set.getInt("quantity"));
				orderItem.setTotalPrice(set.getInt("totalPrice"));
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}

		return orderItem;
	}

	public void save(OrderItems obj) {
		try {
			String sql = String.format(
					"insert into orderItems values (null, %d, %d, '%s', '%s', '%s', '%s', '%s', %d, %d, %d)",
					obj.getOrderId(), obj.getProductId(), obj.getProductCode(), obj.getProductImg(),
					obj.getProductTitle(), obj.getProductDescription(), obj.getProductCategory(), obj.getPrice(),
					obj.getQuantity(), obj.getTotalPrice());
			String message = (db.executeUpdate(sql) > 0) ? "Order Item Saved" : "Order Item cannot be Saved";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

	public void update(OrderItems obj) {
		try {
			String sql = String.format(
					"update orderItems set orderId=%d, productId=%d, productCode='%s', productImg='%s', productTitle='%s', productDescription='%s', productCategory='%s', price=%d, quantity=%d, totalPrice=%d where orderItemId=%d",
					obj.getOrderId(), obj.getProductId(), obj.getProductCode(), obj.getProductImg(),
					obj.getProductTitle(), obj.getProductDescription(), obj.getProductCategory(), obj.getPrice(),
					obj.getQuantity(), obj.getTotalPrice());
			String message = (db.executeUpdate(sql) > 0) ? "Order Item Updated" : "OrderItem cannot be Updated";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from orderItems where orderItemId = " + id;
			String message = (db.executeUpdate(sql) > 0) ? "Order Item Deleted" : "Order Item cannot be Deleted";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: " + e);
		}
		
	}

}
