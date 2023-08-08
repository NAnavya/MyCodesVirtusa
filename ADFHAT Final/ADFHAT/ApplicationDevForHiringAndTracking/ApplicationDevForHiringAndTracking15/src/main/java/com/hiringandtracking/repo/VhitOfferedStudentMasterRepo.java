package com.hiringandtracking.repo;


import com.hiringandtracking.entity.VhitOfferedStudentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VhitOfferedStudentMasterRepo extends JpaRepository<VhitOfferedStudentMaster,Long> {

    Optional<VhitOfferedStudentMaster> findStudentByvosAadhaarNo(String aadharNo);

}
