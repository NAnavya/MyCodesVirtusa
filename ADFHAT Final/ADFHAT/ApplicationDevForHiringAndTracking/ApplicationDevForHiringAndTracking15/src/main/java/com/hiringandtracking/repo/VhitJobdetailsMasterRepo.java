package com.hiringandtracking.repo;

import com.hiringandtracking.entity.VhitJobdetailsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VhitJobdetailsMasterRepo extends JpaRepository<VhitJobdetailsMaster,Integer> {

//    @Query(value = "SELECT * FROM vhit_jobdetails where vjm_role_name = ?1", nativeQuery = true)
    VhitJobdetailsMaster findJobDetailsByvjmRoleName(String roleName);
}
