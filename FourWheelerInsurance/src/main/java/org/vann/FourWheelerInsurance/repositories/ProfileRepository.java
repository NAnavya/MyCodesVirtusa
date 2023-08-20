package org.vann.FourWheelerInsurance.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vann.FourWheelerInsurance.entities.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

 

}
 