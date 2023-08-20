package org.vann.FourWheelerInsurance.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vann.FourWheelerInsurance.entities.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}