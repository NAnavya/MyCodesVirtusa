package com.virtusa.UrbanFashionSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.UrbanFashionSpringBoot.dao.CartItemsRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.CartRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.ProductRepository;
import com.virtusa.UrbanFashionSpringBoot.dao.RegistrationRepository;
import com.virtusa.UrbanFashionSpringBoot.exception.ExistException;
import com.virtusa.UrbanFashionSpringBoot.model.CartItemsModel;
import com.virtusa.UrbanFashionSpringBoot.model.CartModel;
import com.virtusa.UrbanFashionSpringBoot.model.ProductModel;
import com.virtusa.UrbanFashionSpringBoot.model.RegistrationModel;

@Service
public class UserServiceImplementation implements userService  {
	
	@Autowired
	CartRepository mcarrepo;

	@Autowired
	RegistrationRepository rrepo;

	@Autowired
	ProductRepository prepo;

	@Autowired
	CartItemsRepository carrepo;
	

	RegistrationModel model1 = new RegistrationModel();

	@Override
	public RegistrationModel editUser(String uemail , RegistrationModel model) {
		

		if(rrepo.existsByUemail(uemail)) {
			model1 = rrepo.findByUemail(uemail);
			model1.setUname(model.getUname());;
			return rrepo.save(model1);
		}
		else
			return null;


	}

	@Override
	public RegistrationModel viewUser(String uemail) {
		if(rrepo.existsByUemail(uemail)) {
			return rrepo.findByUemail(uemail);
		}
		else 
			return null;
	}

	@Override
	public boolean deleteUser(String uemail) {
		if(rrepo.existsByUemail(uemail)) {
			rrepo.delete(rrepo.findByUemail(uemail));
			return true;
		}
		else 
			return false;
	}

	@Override
	public List<ProductModel> viewProducts() {
		return prepo.findAll();
	}

	@Override
	public String addProductsToCart(String uemail,int pid, CartItemsModel cmodel) {
		
		String res = null;
		try {
			model1 = rrepo.findByUemail(uemail);
			ProductModel pm = new ProductModel();
			pm = prepo.findByPid(pid);
			if(rrepo.existsByUemail(uemail)) {
				if(prepo.existsByPid(pid)) {
					if(!(carrepo.existsByPid(pm))) {
						if(mcarrepo.existsByUser(model1)) {
							
							CartModel mcarm1 = mcarrepo.findByUser(model1);
							List<CartItemsModel> lcm = mcarm1.getCartItems();
							CartItemsModel carm = new CartItemsModel();
							carm.setPname(pm.getPname());
							carm.setPcompany(pm.getPcompany());
							carm.setPcost(pm.getScost());
							carm.setPquantity(cmodel.getPquantity());
							pm.setPquantity(pm.getPquantity() - carm.getPquantity());
							carm.setTcost(carm.getPquantity() * carm.getPcost());
							carm.setPid(pm);
							carm.setCart(mcarm1);
							lcm.add(carm);
							carrepo.save(carm);
							prepo.save(pm);
							throw new ExistException("list added to cart");
						}
						else {
						if(pm.getPquantity() >= cmodel.getPquantity()) {
							List<CartItemsModel> lcm = new ArrayList<>();
							CartItemsModel carm = new CartItemsModel();
							CartModel mcarm = new CartModel();
							carm.setPname(pm.getPname());
							carm.setPcompany(pm.getPcompany());
							carm.setPcost(pm.getScost());
							carm.setPquantity(cmodel.getPquantity());
							pm.setPquantity(pm.getPquantity() - carm.getPquantity());
							carm.setTcost(carm.getPquantity() * carm.getPcost());
							carm.setPid(pm);
							mcarm.setUser(model1);
							lcm.add(carm);
							mcarm.setCartItems(lcm);
							carm.setCart(mcarm);
							carrepo.save(carm);
							prepo.save(pm);
							mcarrepo.save(mcarm);
							throw new ExistException("Added Product");
						}
						else
							throw new ExistException("Product Quantity exceeded");
						}
					}
					else
						updateCart(pm,cmodel.getPquantity());
				}
				else
					throw new ExistException("product id doesn't exist");
			}
			else throw new ExistException("User email doesn't exist");
		}
		catch(ExistException e) {
			res =  e.getMessage();
		}
		return res;
	}

	private String updateCart(ProductModel pm, int pquantity) {
		
			CartItemsModel cm = new CartItemsModel();
			cm = carrepo.findByPid(pm);
			if(pm.getPquantity() >= pquantity) {
				cm.setPquantity(pquantity + cm.getPquantity());
				pm.setPquantity(pm.getPquantity() - pquantity);
				cm.setTcost(cm.getPquantity() * cm.getPcost());
				carrepo.save(cm);
				prepo.save(pm);
				throw new ExistException("Product Updated");
			}
			else
				throw new ExistException("Product Quantity exceeded");

	}


}
