package com.virtusa.UrbanFashionSpringBoot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "User_id")
	private RegistrationModel user;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
	private List<CartItemsModel> cartItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RegistrationModel getUser() {
		return user;
	}

	public void setUser(RegistrationModel user) {
		this.user = user;
	}

	public List<CartItemsModel> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemsModel> cartItems) {
		this.cartItems = cartItems;
	}
	
	

}
