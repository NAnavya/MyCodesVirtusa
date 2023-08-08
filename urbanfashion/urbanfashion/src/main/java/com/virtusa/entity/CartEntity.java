package com.virtusa.entity;

public class CartEntity {

	private int cartid;
	private int userid;
	private int productid;
	private String productname;
	private int productquantity;
	private int cost;

	public CartEntity(int cartid, int userid, int productid, String productname, int productquantity, int cost) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.productid = productid;
		this.productname = productname;
		this.productquantity = productquantity;
		this.cost = cost;
	}

	public CartEntity() {

	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getproductquantity() {
		return productquantity;
	}

	public void setproductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Cart [productid=" + productid + ", productname=" + productname + ", productquantity=" + productquantity
				+ ", cost=" + cost + "]";
	}

}
