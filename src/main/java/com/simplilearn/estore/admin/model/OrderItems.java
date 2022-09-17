package com.simplilearn.estore.admin.model;

public class OrderItems {

	private int orderItemId;
	private int orderId;
	private int productId;
	private String productTitle;
	private String productDescription;
	private String productCode;
	private String productImg;
	private String productCategory;
	private int price;
	private int quantity;
	private int totalPrice;
	
	// default constructor
	public OrderItems() {
		super();
	}
	
	// parameterized constructor
	public OrderItems(int orderItemId, int orderId, int productId, String productTitle, String productDescription,
			String productCode, String productImg, String productCategory, int price, int quantity, int totalPrice) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
		this.productCode = productCode;
		this.productImg = productImg;
		this.productCategory = productCategory;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	// getter & setter methods
	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	// override to string 
	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", productTitle=" + productTitle + ", productDescription=" + productDescription + ", productCode="
				+ productCode + ", productImg=" + productImg + ", productCategory=" + productCategory + ", price="
				+ price + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
}
