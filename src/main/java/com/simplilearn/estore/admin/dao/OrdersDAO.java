package com.simplilearn.estore.admin.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.estore.admin.model.Orders;
import com.simplilearn.estore.dao.DAO;
import com.simplilearn.estore.utility.DBUtility;

public class OrdersDAO implements DAO<Orders>{

	DBUtility db = DBUtility.getDBUtility();
	
	public List<Orders> getAll() {
		List<Orders> ordersList = new ArrayList<Orders>();
		try {
			String sql = "select * from orders";
			ResultSet set = db.executeQuery(sql);
			while (set.next()) {
				Orders order = new Orders();
				order.setOrderId(set.getInt("orderId"));
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				Date orderDate = format.parse(set.getString("orderDate"));
				order.setOrderDate(orderDate);
				order.setOrderStatus(set.getString("orderStatus"));
				order.setTotalItems(set.getInt("totalItems"));
				order.setItemsSubTotal(set.getInt("itemsSubTotal"));
				order.setShipmentCharges(set.getInt("shipmentCharges"));
				order.setTotalAmount(set.getInt("totalAmount"));
				order.setPaymentStatus(set.getInt("paymentStatus"));
				order.setPaymentStatusTitle(set.getString("paymentStatusTitle"));
				order.setPaymentMethod(set.getInt("paymentMethod"));
				order.setPaymentMethodTitle(set.getString("paymentMethodTitle"));
				order.setUserId(set.getInt("userId"));			
				ordersList.add(order);
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return ordersList;
	}

	public Orders getOne(long id) {
		Orders order = new Orders();
		try {
			String sql = "select * from orders where orderId = " + id;
			ResultSet set = db.executeQuery(sql);
			if (set.next()) {
				order.setOrderId(set.getInt("orderId"));
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				Date orderDate = format.parse(set.getString("orderDate"));
				order.setOrderDate(orderDate);
				order.setOrderStatus(set.getString("orderStatus"));
				order.setTotalItems(set.getInt("totalItems"));
				order.setItemsSubTotal(set.getInt("itemsSubTotal"));
				order.setShipmentCharges(set.getInt("shipmentCharges"));
				order.setTotalAmount(set.getInt("totalAmount"));
				order.setPaymentStatus(set.getInt("paymentStatus"));
				order.setPaymentStatusTitle(set.getString("paymentStatusTitle"));
				order.setPaymentMethod(set.getInt("paymentMethod"));
				order.setPaymentMethodTitle(set.getString("paymentMethodTitle"));
				order.setUserId(set.getInt("userId"));
				
			}
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e);
		}
		return order;
	}

	public void save(Orders object) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			String orderDate = format.format(object.getOrderDate());
			String sql = String.format("insert into orders values (null, '%s', '%s', %d, %d, %d, %d, %d, '%s', %d, '%s', %d, '%s', '%s', %d, '%s')", 
				orderDate,
				object.getOrderStatus(),
				object.getTotalItems(),
				object.getItemsSubTotal(),
				object.getShipmentCharges(),
				object.getTotalAmount(),
				object.getPaymentStatus(),
				object.getPaymentStatusTitle(),
				object.getPaymentMethod(),
				object.getPaymentMethodTitle(),
				object.getUserId()
			);
			String message = (db.executeUpdate(sql) > 0) ? "Order Saved" : "Order cannot be Saved";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: "+e);
		}
		
	}

	public void update(Orders object) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			String orderDate = format.format(object.getOrderDate());
			String sql = String.format("update orders set orderDate='%s', orderStatus='%s', totalItems=%d, itemsSubTotal=%d, shipmentCharges=%d, totalAmount=%d, paymentStatus=%d, paymentStatusTitle='%s', paymentMethod=%d, paymentMethodTitle='%s', userId='%s', name='%s', email='%s', contact=%d, address='%s' where orderId=%d", 
				orderDate,
				object.getOrderStatus(),
				object.getTotalItems(),
				object.getItemsSubTotal(),
				object.getShipmentCharges(),
				object.getTotalAmount(),
				object.getPaymentStatus(),
				object.getPaymentStatusTitle(),
				object.getPaymentMethod(),
				object.getPaymentMethodTitle(),
				object.getUserId()
			);
			String message = (db.executeUpdate(sql) > 0) ? "Admin Updated Order successfuly" : "Order cannot be updated";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: "+e);
		}
		
	}

	public void delete(long id) {
		try {
			String sql = "delete from orders where orderId = "+id;
			String message = (db.executeUpdate(sql) > 0) ? "Order Deleted" : "Order cannot be Deleted";
			System.out.println(message);
		} catch (Exception e) {
			System.out.println("Exception is: "+e);
		}
		
	}

}
