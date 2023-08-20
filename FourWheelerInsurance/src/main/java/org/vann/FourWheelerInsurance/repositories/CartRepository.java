package org.vann.FourWheelerInsurance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vann.FourWheelerInsurance.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByCustid(int custid);

	Cart findByCustidAndPid(int customerid, int pid);
}
