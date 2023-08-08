package com.virtusa.entity;

public class ProductsEntity {
	
	private int productid;
	private String productname;
	private String productsize;
	private int productquantity;
	private String productcompany;
	private int userid;
	private int productcost;
	
	public ProductsEntity(int productid, String productname, String productsize, int productquantity,
			String productcompany, int userid, int productcost) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productsize = productsize;
		this.productquantity = productquantity;
		this.productcompany = productcompany;
		this.userid = userid;
		this.productcost = productcost;
	}
	
	public ProductsEntity() {
		
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

	public String getProductsize() {
		return productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public String getProductcompany() {
		return productcompany;
	}

	public void setProductcompany(String productcompany) {
		this.productcompany = productcompany;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductcost() {
		return productcost;
	}

	public void setProductcost(int productcost) {
		this.productcost = productcost;
	}

	@Override
	public String toString() {
		return "Products [productid=" + productid + ", productname=" + productname + ", productsize="
				+ productsize + ", productquantity=" + productquantity + ", productcompany=" + productcompany
				+", userid=" + userid + ", productcost=" + productcost + "]";
	}
	
	
}
