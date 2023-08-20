package org.vann.FourWheelerInsurance.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vann.FourWheelerInsurance.entities.Orderitems;
import org.vann.FourWheelerInsurance.repositories.OrderRepository;

@Service
@Transactional
public class OrderService
{

final private static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(OrderService.class);

@Autowired
private OrderRepository orderRepo;



public List<Orderitems> getOrders(){
return orderRepo.findAll();
}

public List<Orderitems> getOrderByCustomerId(int customerId) {
return orderRepo.findByCustomerid(customerId);
}


public void saveOrders(List<Orderitems> orderItems)
{
orderRepo.saveAll(orderItems);
log.info(orderItems+" saved Successfully");
}
public void deleteOrder(int orderid) {

	orderRepo.deleteById(orderid);

}
}