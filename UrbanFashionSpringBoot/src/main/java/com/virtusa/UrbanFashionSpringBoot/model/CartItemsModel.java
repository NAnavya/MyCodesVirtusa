package com.virtusa.UrbanFashionSpringBoot.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItemsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitem;
	private String pname;
	private String pcompany;
	private int pquantity;
	private int pcost;
	private int tcost;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "Cart_cid")
	private CartModel cart;
	
	
	@ManyToOne
	@JoinColumn(name = "products_pid")
	private ProductModel pid;

	
	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	

	public int getCartitem() {
		return cartitem;
	}

	public void setCartitem(int cartitem) {
		this.cartitem = cartitem;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getTcost() {
		return tcost;
	}

	public void setTcost(int tcost) {
		this.tcost = tcost;
	}

	public ProductModel getPid() {
		return pid;
	}

	public void setPid(ProductModel pid) {
		this.pid = pid;
	}

}
