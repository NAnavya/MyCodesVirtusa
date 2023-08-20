package org.vann.FourWheelerInsurance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Cart;
import org.vann.FourWheelerInsurance.exceptions.CartDataNotFoundException;
import org.vann.FourWheelerInsurance.repositories.CartRepository;

@Service
@Transactional
public class CartService
{

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(CartService.class);
@Autowired
private CartRepository cartRepo;


public void addToCart(Cart new_cart)
{
log.info("Policy Added to Cart For the firsttime");
Cart old_cart= cartRepo.findByCustidAndPid(new_cart.getId(), new_cart.getId());
if(old_cart == null) {
cartRepo.save(new_cart);
}
else {
updateCartData(new_cart,old_cart);
}
}

public List<Cart> getByCustomerId(int customerId){
List<Cart> custcart = cartRepo.findByCustid(customerId);
if(custcart.isEmpty()) {
log.error("No Item in the cart for customerId"+customerId);
throw new CartDataNotFoundException("No Item in the cart");
}
return custcart;
}


public Cart getByCustomerIdAndProductId(int customerId,int pid) {
log.info(customerId+" Cart data is fetched");
return cartRepo.findByCustidAndPid(customerId, pid);
}

public void updateCartData(Cart new_cart,Cart old_cart) {
log.info("Product Added to cart Successfully Based on Condition");
old_cart.setId(new_cart.getId());

old_cart.setPolicyName(new_cart.getPolicyName());

old_cart.setPolicyPrice(new_cart.getPolicyPrice());
old_cart.setNumberOfYearsPlan(new_cart.getNumberOfYearsPlan());

cartRepo.save(old_cart);
}

public void updateCartData(Cart new_cart,int id) {
log.info("Product Data in Cart Updated Successfully");
Cart old_cart = cartRepo.findByCustidAndPid(id, new_cart.getId());
old_cart.setId(new_cart.getId());
old_cart.setPolicyName(new_cart.getPolicyName());

old_cart.setPolicyPrice(new_cart.getPolicyPrice());
old_cart.setNumberOfYearsPlan(new_cart.getNumberOfYearsPlan());

cartRepo.save(old_cart);
}

public void deleteFromCart(int id) {
log.info("Cart data with id"+id+"deleted Successfully");
cartRepo.deleteById(id);
}
}