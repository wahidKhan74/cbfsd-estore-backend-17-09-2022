package com.simplilearn.estore.enduser.model;

public class Cart {

	private int cartId;
	private int productId;
	private int userId;
	private int quantity;

	// no argument constructor
	public Cart() {	}

	// parameterized constructor
	public Cart(int cartId, int productId, int userId, int quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}
	// getter & setters

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// override tostring
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity
				+ "]";
	}

}
