package com.simplilearn.estore.enduser.model;

public class Wishlist {

	private int wishlistId;
	private int productId;
	private int userId;
	
	// no argument constructor
	Wishlist(){ }
	
	// parameterized constructor
	public Wishlist(int wishlistId, int productId, int userId) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.userId = userId;
	}
	
	// getter setter methods
	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
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
	// override tostring

	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", productId=" + productId + ", userId=" + userId + "]";
	}
	
}
