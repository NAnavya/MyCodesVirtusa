package com.hiringandtracking.repo;

import com.hiringandtracking.entity.VhitCollegeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VhitCollegeMasterRepo extends JpaRepository<VhitCollegeMaster,Integer> {

//    optional need to be added
//    @Query(value = "select * from vhit_college_master where vmc_name = ?1", nativeQuery = true)
    VhitCollegeMaster findCollegeByvmcName(String collegeName);


}
