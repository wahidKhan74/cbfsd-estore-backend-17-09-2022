package com.simplilearn.estore.admin.model;

import java.util.Date;

public class Orders {

	// order details properties
	private int orderId;
	private Date orderDate;
	private String orderStatus;
	
	//pricing properties
	private int totalItems;
	private int itemsSubTotal;
	private int shipmentCharges;
	private int totalAmount;
	private int paymentStatus;
	
	// payment status properties
	private String paymentStatusTitle;
	private int paymentMethod;
	private String paymentMethodTitle;
	
	// customer / user properties
	private int userId;
	private String email;
	private String address;
	private String name;
	private Long contact;
	
	// default constructor
	public Orders() {
		super();
	}

	// parameterized constructor
	public Orders(int orderId, Date orderDate, String orderStatus, int totalItems, int itemsSubTotal,
			int shipmentCharges, int totalAmount, int paymentStatus, String paymentStatusTitle, int paymentMethod,
			String paymentMethodTitle, int userId, String email, String address, String name, Long contact) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalItems = totalItems;
		this.itemsSubTotal = itemsSubTotal;
		this.shipmentCharges = shipmentCharges;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.paymentStatusTitle = paymentStatusTitle;
		this.paymentMethod = paymentMethod;
		this.paymentMethodTitle = paymentMethodTitle;
		this.userId = userId;
		this.email = email;
		this.address = address;
		this.name = name;
		this.contact = contact;
	}

	// getter & setter methods
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getItemsSubTotal() {
		return itemsSubTotal;
	}

	public void setItemsSubTotal(int itemsSubTotal) {
		this.itemsSubTotal = itemsSubTotal;
	}

	public int getShipmentCharges() {
		return shipmentCharges;
	}

	public void setShipmentCharges(int shipmentCharges) {
		this.shipmentCharges = shipmentCharges;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatusTitle() {
		return paymentStatusTitle;
	}

	public void setPaymentStatusTitle(String paymentStatusTitle) {
		this.paymentStatusTitle = paymentStatusTitle;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodTitle() {
		return paymentMethodTitle;
	}

	public void setPaymentMethodTitle(String paymentMethodTitle) {
		this.paymentMethodTitle = paymentMethodTitle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	// override to string
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", totalItems=" + totalItems + ", itemsSubTotal=" + itemsSubTotal + ", shipmentCharges="
				+ shipmentCharges + ", totalAmount=" + totalAmount + ", paymentStatus=" + paymentStatus
				+ ", paymentStatusTitle=" + paymentStatusTitle + ", paymentMethod=" + paymentMethod
				+ ", paymentMethodTitle=" + paymentMethodTitle + ", userId=" + userId + ", email=" + email
				+ ", address=" + address + ", name=" + name + ", contact=" + contact + "]";
	}

}
