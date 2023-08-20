package org.vann.FourWheelerInsurance.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vann.FourWheelerInsurance.entities.Orderitems;


@Repository

public interface OrderRepository extends JpaRepository<Orderitems, Integer> {
	List<Orderitems> findByCustomerid(int customerid);
	}