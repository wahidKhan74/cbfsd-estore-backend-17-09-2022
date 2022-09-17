package com.simplilearn.estore.admin.model;

import java.util.Date;

public class Shipments {

	private int shipmentId;
	private int orderId;
	private int shipmentStatus;
	private String shipmentTitle;
	private Date shipmentDate;
	private Date expectedDeliveryDate;
	private String shipmentMethod;
	private String shipmentCompany;
	
	// default constructor
	public Shipments() {
		super();
	}

	// parameterized constructor
	public Shipments(int shipmentId, int orderId, int shipmentStatus, String shipmentTitle, Date shipmentDate,
			Date expectedDeliveryDate, String shipmentMethod, String shipmentCompany) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentStatus = shipmentStatus;
		this.shipmentTitle = shipmentTitle;
		this.shipmentDate = shipmentDate;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.shipmentMethod = shipmentMethod;
		this.shipmentCompany = shipmentCompany;
	}

	// getter setter methods
	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(int shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipmentTitle() {
		return shipmentTitle;
	}

	public void setShipmentTitle(String shipmentTitle) {
		this.shipmentTitle = shipmentTitle;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getShipmentMethod() {
		return shipmentMethod;
	}

	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	public String getShipmentCompany() {
		return shipmentCompany;
	}

	public void setShipmentCompany(String shipmentCompany) {
		this.shipmentCompany = shipmentCompany;
	}
	
	// override to string 
	@Override
	public String toString() {
		return "Shipments [shipmentId=" + shipmentId + ", orderId=" + orderId + ", shipmentStatus=" + shipmentStatus
				+ ", shipmentTitle=" + shipmentTitle + ", shipmentDate=" + shipmentDate + ", expectedDeliveryDate="
				+ expectedDeliveryDate + ", shipmentMethod=" + shipmentMethod + ", shipmentCompany=" + shipmentCompany
				+ "]";
	}
	
}

